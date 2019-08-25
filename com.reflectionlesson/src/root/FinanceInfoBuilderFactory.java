package root;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

// Объявление аннотации для класса
@FinanceAnnotation(financeBuilder = "root.WebFinanceInfoBuilder")
public class FinanceInfoBuilderFactory
{
    public static FinanceInfoBuilder getFinanceInfoBuilder() {
        try {
            // Получаем аннотацию к классу. Т.к. это наш класс, то можно его приводить
            FinanceAnnotation financeAnnotation =
                    FinanceInfoBuilderFactory.class.getAnnotation(FinanceAnnotation.class);
//            FinanceAnnotation financeAnnotation = (FinanceAnnotation)ann;

            // Загружаем класс по имени
            Class aClass = Class.forName(financeAnnotation.financeBuilder());
            // Т.к. наш класс должен имплементировать интерфейс FinanceInfoBuilder
            // то мы можем сделать приведение к интерфейсу
            FinanceInfoBuilder builder = (FinanceInfoBuilder)aClass.getDeclaredConstructor().newInstance();
            return builder;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace(System.out);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package root;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SimpleReflectionExample
{
    public static void main(String[] args) {
        // Получаем нужный объект
        FinanceInfoBuilder financeInfoBuilder = FinanceInfoBuilderFactory.getFinanceInfoBuilder();
        // Вызываем метод
        FinanceInformation financeInformation = financeInfoBuilder.buildFinacneInformation();
        financeInformation.droch();
        System.out.println(financeInformation.getClass().getName());
        // Вызов getClass() позволяет получить описание класса у объекта
        System.out.println("Имя класса:" + financeInfoBuilder.getClass().getCanonicalName());
        // Дальше можем делать с полученной информацией все, что захотим

      /*  //Пример обращения к полям и методам класса
        try {
            demoReflection();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }*/
    }

    private static void demoReflection() throws Exception {
        // Заружаем описание класса
        Class example = Class.forName("root.SimpleClass");
        SimpleClass sc = (SimpleClass) example.getDeclaredConstructor().newInstance();

        // Обращение к полю
        demoReflectionField(example, sc);

        // Обращение к методу
        demoReflectionMethod(example, sc);
    }

    private static void demoReflectionField(Class example, SimpleClass sc) throws Exception {
        // Получить обхект типа Field - обратите внимание, что поле private
        Field f = example.getDeclaredField("first");
        // Выставить разрешение для доступа к полю
        System.out.println(f.isAccessible());
        f.setAccessible(true);
        System.out.println(f.isAccessible());

        // Получить значение поля - оно у нас пока NULL
        String test = (String)f.get(sc);
        System.out.println("Field before SET:" + sc.getFirst());
        // Установить значение поля
        f.set(sc, "Test");
        System.out.println("Field after SET:" + sc.getFirst());
    }

    private static void demoReflectionMethod(Class example, SimpleClass sc) throws Exception {
        // Вызов метода без параметров
        // Получить обхект типа Method по имени
        Method method1 = example.getMethod("simple");
        // Вызвать метод с помощью invoke - передать туда только объект
        String simple = (String)method1.invoke(sc);
        System.out.println("Simple:" + simple);

        // Вызов метода с параметрами
        // Сначала надо определить список параметров - вспоминаем overloading
        // У нас это две строки - String
        Class[] paramTypes = new Class[] {String.class, String.class};
        // Получить обхект типа Method по имени и по списку параметров
        Method concat = example.getMethod("concat", paramTypes);
        // Вызвать метод - передать туда объект и два параметра типа строка
        String answer = (String)concat.invoke(sc, "1", "2");
        System.out.println("Concat:" + answer);
    }
}
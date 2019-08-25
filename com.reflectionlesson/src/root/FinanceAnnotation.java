package root;

import java.lang.annotation.Retention;

// Мы собираемся использовать аннотацию во время исполнения
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@interface FinanceAnnotation
{
    // Объявляем параметр для имени класса со значением по умолчанию
    String financeBuilder() default "root.DbFinanceInfoBuilder";
}
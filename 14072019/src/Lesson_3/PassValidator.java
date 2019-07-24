package Lesson_3;

public class PassValidator {
    public Boolean validate(String pass) {
//        1 Обязательно есть хоть 1 цифра
        if (pass.matches(".*\\d+.*") && pass.matches(".{8,20}")
                && pass.matches(".*[A-Z]+.*") && pass.matches(".*[a-z]+.*")
                && pass.matches(".*\\W.*"))
            return true;
//        4 Обязательно дожен быть спец символ
        return false;
    }
}

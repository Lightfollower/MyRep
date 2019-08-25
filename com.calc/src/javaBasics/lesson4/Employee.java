package javaBasics.lesson4;

import java.util.Arrays;
import java.util.Collections;

public class Employee {

    public static void main(String[] args) {

        Dog dog = new Dog(200, 5, 2);
        Cat cat = new Cat(300, 4, 7);
        System.out.println(dog.run(100));
        System.out.println(dog.run(300));
        System.out.println(cat.run(100));
        System.out.println(cat.run(300));
        System.out.println(dog.swim(4));
        System.out.println(dog.swim(6));
        System.out.println(cat.swim(3));
        System.out.println(cat.swim(9));

        Employee[] employees = {
                new Employee("Вася 590001", "Биологический источник электроенергии", "Matrix.com", "111", 0, 33),
                new Employee("Вася 590002", "Биологический источник электроенергии", "Matrix.com", "111", 0, 43),
                new Employee("Вася 590003", "Биологический источник электроенергии", "Matrix.com", "111", 0, 23),
                new Employee("Вася 590004", "Биологический источник электроенергии", "Matrix.com", "111", 0, 53),
                new Employee("Вася 590005", "Биологический источник электроенергии", "Matrix.com", "111", 0, 13)
        };
        for (Employee e :
                employees) {
            if (e.age > 40)
                e.getEmployeeInfo();
        }
    }

    private String name;
    private String position;
    private String eMail;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String name, String position, String eMail, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void getEmployeeInfo() {
        System.out.println(name);
        System.out.println(position);
        System.out.println(eMail);
        System.out.println(phoneNumber);
        System.out.println(salary);
        System.out.println(age + "\n");

    }

}

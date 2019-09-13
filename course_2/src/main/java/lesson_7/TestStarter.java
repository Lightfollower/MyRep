package lesson_7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestStarter {

    public static void start(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        int indexOfBeforeAnnotationMethod = -1;
        int indexOfAfterAnnotationMethod = -1;
        List<Method> methodArrayList = new ArrayList<>();

        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getAnnotation(BeforeSuite.class) != null) {
                if (indexOfBeforeAnnotationMethod == -1) {
                    System.out.println(i);
                    indexOfBeforeAnnotationMethod = i;
                } else {
                    throw new RuntimeException("Want too much before you start");
                }
            }

            if (methods[i].getAnnotation(AfterSuite.class) != null) {
                if (indexOfAfterAnnotationMethod == -1) {
                    System.out.println(i);
                    indexOfAfterAnnotationMethod = i;
                } else {
                    throw new RuntimeException("Want too much after completion");
                }
            }

            if (methods[i].getAnnotation(Test.class) != null) {
                methodArrayList.add(methods[i]);
            }
        }
        try {
            methods[indexOfBeforeAnnotationMethod].invoke(testClass.getDeclaredConstructor().newInstance());

            methodArrayList.sort((o1, o2) -> o2.getAnnotation(Test.class).value() - o1.getAnnotation(Test.class).value());
            for (Method m :
                    methodArrayList) {
                m.invoke(testClass.getDeclaredConstructor().newInstance());
            }

            methods[indexOfAfterAnnotationMethod].invoke(testClass.getDeclaredConstructor().newInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        start(Tests.class);
    }

}

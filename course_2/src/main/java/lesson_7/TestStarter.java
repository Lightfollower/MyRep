package lesson_7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class TestStarter {

    public static void start(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        int indexOfBeforeAnnotationMethod = -1;
        int indexOfAfterAnnotationMethod = -1;
        TreeMap<Integer, ArrayList<Method>> separatedByPriorityMethods = new TreeMap<>(Collections.reverseOrder());

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
                if (!separatedByPriorityMethods.containsKey(methods[i].getAnnotation(Test.class).value())) {
                    separatedByPriorityMethods.put(Integer.valueOf(methods[i].getAnnotation(Test.class).value()), new ArrayList<>());
                }
                separatedByPriorityMethods.get(methods[i].getAnnotation(Test.class).value()).add(methods[i]);
            }
        }
        try {
            methods[indexOfBeforeAnnotationMethod].invoke(testClass.getDeclaredConstructor().newInstance());
//            for (int i = 10; i >= 0; i--) {
//                if (separatedByPriorityMethods.containsKey(i)) {
//                    for (Method m :
//                            separatedByPriorityMethods.get(i)) {
//                        m.invoke(testClass.getDeclaredConstructor().newInstance());
//                    }
//                }
//            }
            separatedByPriorityMethods.forEach((k,v) -> v.forEach((q) -> {
                try {
                    q.invoke(testClass.getDeclaredConstructor().newInstance());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }));
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

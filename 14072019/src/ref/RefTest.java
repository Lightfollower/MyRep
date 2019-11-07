package ref;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class RefTest {
    static MainClass mainClass;

    static {
        try {
            mainClass = new MainClass();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        List<Object[]> strings1 = new ArrayList<>();
        List<String> strings = new ArrayList<>();
//        for (int i = 0; i < MainClass.answers.size(); i++) {
//            strings.add("Ololo");
//        }
        for (int i = 0; i < mainClass.answers.size(); i++) {
            System.out.println("asd");
            strings1.add(new String[]{"Ololo", mainClass.answers.get(i)});
        }
        return strings1;
    }
    Object expected;
    Object incoming;
    public RefTest(Object expected, Object incoming) {
        this.expected = expected;
        this.incoming = incoming;
    }

    @Before
    public void init() {
    }


    @Test
    public void homeWorkTest() {
        Assert.assertEquals(expected, incoming);
    }

//    @Test(expected = RuntimeException.class)
//    public void runtimeExceptionTest() {
//    }

}
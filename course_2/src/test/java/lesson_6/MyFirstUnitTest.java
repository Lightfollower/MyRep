package lesson_6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyFirstUnitTest {
    @Parameterized.Parameters
    public static Collection<int[][]> data() {
        return Arrays.asList(new int[][][]{
                {{5, 6}, {1,2,3,4,5,6}},
                {{456,987,444,123},{4,5,4,6,7,8,9,4,456,987,444,123}},
                {{987, 456, 2134},{-1, 5, 4, 987, 456, 2134}},
                {{987, 456, 2134},{-1, 5, 0, 987, 456, 2134}}
        });
    }
    int[] expected;
    int[] incoming;
    public MyFirstUnitTest(int[] expected, int[] incoming) {
        this.expected = expected;
        this.incoming = incoming;
    }


    @Test
    public void arrayModificationTest() {
        Assert.assertArrayEquals(expected, MainClass.lastFourTrimmer(incoming));
    }

    @Test(expected = RuntimeException.class)
    public void runtimeExceptionTest() {
        MainClass.lastFourTrimmer(1, 2, 3, 5);
    }

}

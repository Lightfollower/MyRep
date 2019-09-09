package lesson_6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayValidationTest {

    @Parameterized.Parameters
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
                        {1, 1, 1, 4, 4, 1, 4, 4},
                        {1, 1, 1, 1, 1, 1},
                        {4, 4, 4, 4},
                        {1, 4, 4, 1, 1, 4, 3}
                }
        );
    }

    int[] incoming;

    public ArrayValidationTest(int[] incoming) {
        this.incoming = incoming;
    }

    @Test
    public void arrayModificationTest() {
        Assert.assertTrue(MainClass.oneFourArrayValidator(incoming));
    }
}
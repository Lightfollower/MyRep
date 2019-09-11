package lesson_7;

public class Tests {

    @BeforeSuite
    public void executeBefore() {
        System.out.println("before");
    }

    @AfterSuite
    public void executeAfter(){
        System.out.println("after");
    }

    @Test(1)
    public void test1() {
        System.out.println("1");
    }

    @Test
    public void test2() {
        System.out.println("2");

    }

    @Test(9)
    public void test3() {
        System.out.println("3");

    }

    @Test(2)
    public void test4() {
        System.out.println("4");

    }
    @Test(8)
    public void test5() {
        System.out.println("5");

    }


}

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {
    int[] arr;

    @Before
    public void setUp(){
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    @Test
    public void test1(){
        int result = 0;
        Assert.assertEquals("first test is successful", result, new BinarySearchClass(arr).binarySearch(1, 0, arr.length));
    }

    @Test
    public void test2(){
        int result = 9;
        Assert.assertEquals("second test is successful", result, new BinarySearchClass(arr).binarySearch(10, 0, arr.length));
    }

    @Test
    public void test3(){
        int result = 4;
        Assert.assertEquals("third test is successful", result, new BinarySearchClass(arr).binarySearch(5, 0, arr.length));
    }

    @Test
    public void test4(){
        int result = -1;
        Assert.assertEquals("fourth test is successful", result, new BinarySearchClass(arr).binarySearch(12, 0, arr.length));
    }
}

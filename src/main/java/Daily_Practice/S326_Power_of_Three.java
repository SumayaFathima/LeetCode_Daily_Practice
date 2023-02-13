package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S326_Power_of_Three {

    @Test
    public void example1() {
        int n = 27;
        boolean output = true;
        Assert.assertEquals(isPowerOfThree(n), output);
    }

    @Test
    public void example2() {
        int n = 0;
        boolean output = false;
        Assert.assertEquals(isPowerOfThree(n), output);
    }

    @Test
    public void example3() {
        int n = -1;
        boolean output = false;
        Assert.assertEquals(isPowerOfThree(n), output);
    }

    @Test
    public void example4() {
        int n = 3;
        boolean output = true;
        Assert.assertEquals(isPowerOfThree(n), output);
    }

    @Test
    public void example5() {
        int n = 2;
        boolean output = false;
        Assert.assertEquals(isPowerOfThree(n), output);
    }

    /*
    if n <=0 return false
    A loop with n%3==0 then divide n by 3
    if n becomes 1 return true else false
    */
    public boolean isPowerOfThree(int n) {

        if(n<=0) return false;

        while(n%3==0){
            n=n/3;
        }

        if(n==1) return true;

        return false;
    }
}
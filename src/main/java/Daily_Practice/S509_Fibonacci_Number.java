package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S509_Fibonacci_Number {

    @Test
    public void example1() {

        int n = 5;
        int output = 120;
        Assert.assertEquals(fib(n), output);
    }
    @Test
    public void example2() {
        int n = 3;
        int output = 2;
        Assert.assertEquals(fib(n), output);
    }

    @Test
    public void example3() {

        int n = 4;
        int output = 3;
        Assert.assertEquals(fib(n), output);
    }
/*
1. Create f1 =0 and f2 =1
2. Traverse from 2 till n
3. Add f1 and f2
4. return f
 */

    public int fib(int n) {
        if(n<2) return n;

        int f=0, f1 = 0,f2 = 1;

        for(int i = 2; i<=n; i++) {

            f = f1+f2;
            f1= f2;
            f2 = f;
        }
        return f;
    }
}


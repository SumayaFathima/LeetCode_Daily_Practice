package Sliding_Window.Recursion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S02_Fibonacci_Number {

    // https://leetcode.com/problems/fibonacci-number/

    @Test
    public void example1() {

        int n =2;
        int output =1;
        Assert.assertEquals(fib(n), output);
    }

    public int fib(int n) {

        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}



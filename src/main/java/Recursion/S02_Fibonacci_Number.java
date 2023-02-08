package Recursion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S02_Fibonacci_Number {

    //Leetcode_509 : https://leetcode.com/problems/fibonacci-number/

    @Test
    public void example1() {

        int n = 2;
        int output = 1;
        Assert.assertEquals(fibonacci(n), output);
    }
    private int fibonacci(int n) {
        if (n <= 1) return n;
        return recursion(2, n, 0, 1);
    }

    public int recursion(int index, int n, int val1, int val2) {
        if (index == n) return val2 + val1;

        int temp = val2;
        val2 = val2 + val1;
        val1 = temp;
        return recursion(index + 1, n, val1, val2);
    }
}

//bruteforce :
   /* private int fibonacci(int n) {   //0 1 1 2 3 5 8 13 21 33 54
        if (n <= 1) return n;
        int val1 = 0;
        int val2 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = val2;
            val2 = val2 + val1;
            val1 = temp;
        }
        return val2;
    }
    */

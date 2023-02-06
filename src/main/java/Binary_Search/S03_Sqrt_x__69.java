package Binary_Search;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class S03_Sqrt_x__69 {

    /* Leetcode_69 : https://leetcode.com/problems/sqrtx/

    Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer
    should be non-negative as well.

    You must not use any built-in exponent function or operator.
    For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

    Constraints:

        0 <= x <= 231 - 1

   */

    @Test
    public void example1() {
        int x = 4;
        int output = 2;
        Assert.assertEquals(searchInsert(x), output);
    }

    @Test
    public void example2() {
        int x = 8;
        int output = 2;
        Assert.assertEquals(searchInsert(x), output);
    }

    @Test
    public void example3() {
        int x = 0;
        int output = 0;
        Assert.assertEquals(searchInsert(x), output);
    }

    @Test
    public void example4() {
        int x = 1;
        int output = 1;
        Assert.assertEquals(searchInsert(x), output);
    }

    @Test
    public void example5() {
        int x = 7;
        int output = 2;
        Assert.assertEquals(searchInsert(x), output);
    }


    public int searchInsert(int x) {

        long left =0, right = x, mid, ans=0;

        while(left <= right) {

            mid = (left + right) / 2;

            if (mid * mid < x) {
                left = mid + 1;
                ans = mid; }

            else if (mid * mid > x)
                right = mid - 1;

            else return (int) mid;
        }

        return (int) ans;
    }
}
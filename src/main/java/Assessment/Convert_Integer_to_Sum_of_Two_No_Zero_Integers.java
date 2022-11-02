package Assessment;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Convert_Integer_to_Sum_of_Two_No_Zero_Integers {

    /* Leetcode_1317 https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/

        No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.
        Given an integer n, return a list of two integers [A, B] where:

            A and B are No-Zero integers.
            A + B = n
        The test cases are generated so that there is at least one valid solution. If there are many valid solutions you can
        return any of them.

        Constraints:

            2 <= n <= 104
    */

    @Test
    public void example1() {
        int num = 100;
        int[] output = {1, 99};
        Assert.assertEquals(convertInteger(num), output);
    }

    @Test
    public void example2() {
        int num = 11;
        int[] output = {2,9};
        Assert.assertEquals(convertInteger(num), output);
    }

    @Test
    public void example3() {
        int num = 101;
        int[] output = {2,99};
        Assert.assertEquals(convertInteger(num), output);
    }

    @Test
    public void example4() {
        int num = 5;
        int[] output = {1, 4};
        Assert.assertEquals(convertInteger(num), output);
    }

    /* Pseudo code :

        1. A loop traversing from 1 to given num
        2. Checks for the condition if the array value and num - array value gives the num with non zero numbers
        3. It iterates until it finds the correct match
        4. Returns the list of two integers
     */
    public int[] convertInteger(int num) {

        for (int i = 1; i < num; i++) {

            if (nonZero(i) && nonZero(num - i)) {
                return new int[]{i, num - i};
            }
        }
        return null;
    }
        private boolean nonZero(int num) {
            while (num > 0) {
                if (num%10 == 0)
                    return false;
                num=num/10;
            }
            return true;
        }
    }
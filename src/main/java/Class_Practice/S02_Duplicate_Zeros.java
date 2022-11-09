package Class_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S02_Duplicate_Zeros {

    /* Leetcode_1089 : https://leetcode.com/problems/duplicate-zeros/

    Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
    Note that elements beyond the length of the original array are not written. Do the above modifications to the input array
    in place and do not return anything.

    Constraints:

        1 <= arr.length <= 104
        0 <= arr[i] <= 9

     */

    @Test
    public void example1() {
        int[] nums = {1, 0, 2, 3, 0, 4, 5, 0};
        int[] output = {1,0,0,2,3,0,0,4};
        Assert.assertEquals(duplicateZeros(nums), output);
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        int[] output = {1,2,3};
        Assert.assertEquals(duplicateZeros(nums), output);
    }

    @Test
    public void example3() {
        int[] nums = {0};
        int[] output = {0};
        Assert.assertEquals(duplicateZeros(nums), output);
    }

    @Test
    public void example4() {
        int[] nums = {1};
        int[] output = {1};
        Assert.assertEquals(duplicateZeros(nums), output);
    }

    @Test
    public void example5() {
        int[] nums = {0,0,0,0};
        int[] output = {0,0,0,0};
        Assert.assertEquals(duplicateZeros(nums), output);
    }

    @Test
    public void example6() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 0};
        int[] output = {1,1,1,1,1,1,1,0};
        Assert.assertEquals(duplicateZeros(nums), output);
    }

    @Test
    public void example7() {
        int[] nums = {8,5,0,9,0,3,4,70};
        int[] output = {8,5,0,0,9,0,0,3};
        Assert.assertEquals(duplicateZeros(nums), output);
    }

    /* Pseudo code :

        1. A loop to take the count of zeros from the array
        2. Initialize newlen = nums.length + zerocount
        3. Another loop where i = nums.length - 1 and j = newlen - 1. Also i < j and i--, j--
        4. If nums of i != 0 --> check for j<nums.length
                  *  if yes then place nums[i] value in nums[j]
                  *  else move back to the loop
        5. If nums of i ==0 --> check for j<nums.length
                  *  if yes then place nums[i] value in nums[j] and j-- then again place nums[i] value in nums[j]
                  * else j-- and move back to the loop
     */


  /*  public int[] duplicateZeros(int[] nums) {

        for(int i =0; i<nums.length; i++) {

            if(nums[i] == 0 && i+1 <nums.length) {

                for(int j=nums.length-1; j>i+1; j--) {

                    nums[j] = nums[j-1];
                }
                nums[i+1] =0;
                i++;
            }
        }
        return nums;
    }
} */


    public int[] duplicateZeros(int[] nums) {

        int zerocount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zerocount++;
        }

        int newlen = nums.length + zerocount;

        for (int i = nums.length - 1, j = newlen - 1; i < j; i--, j--) {

            if (nums[i] != 0) {
                if (j < nums.length)
                    nums[j] = nums[i];
            }
            else {
                if (j < nums.length)
                    nums[j] = nums[i];
                j--;
                if (j < nums.length)
                    nums[j] = nums[i];
            }
        }
        return nums;
    }
}
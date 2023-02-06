package LinkedList;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.*;

public class Rotate_Array {


    @Test
    public void example1() {

        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int[] output = {5,6,7,1,2,3,4};
        Assert.assertEquals(rotate(nums, k), output);
    }

    @Test
    public void example2() {

        int[] nums = {1,2,3,4};
        int k = 0;
        int[] output = {1,2,3,4};
        Assert.assertEquals(rotate(nums, k), output);
    }

    @Test
    public void example3() {

        int[] nums = {1,2,3};
        int k = 5;
        int[] output = {2,3,1};
        Assert.assertEquals(rotate(nums, k), output);
    }

    @Test
    public void example4() {

        int[] nums = {1,-2,3, -5,-4,6,-1,0};
        int k = 1;
        int[] output = {0,1,-2,3, -5,-4,6,-1};
        Assert.assertEquals(rotate(nums, k), output);
    }

    /*

    1. Initialize i =0
    2. traverse while k>0
    3. save last value in temp
    4. Traverse from right till 1 and move last before index to current index
    5. then place temp in 0th index
    6. Decrement k

  /*  public int[] rotate(int[] nums, int k) {

        int i=0;
        while (k > 0) {
            int temp = nums[nums.length - 1];

            for  (i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[i] = temp;
            k--;
        }
        return nums;
    }
} */

    /*

    1. Take k as k%nums.length if k is greater than the length
    2. First reverse all numbers from 0 to end
    3. Now split into 2
             * From 0 to k-1
    4.       * From k to end
    5. Have a swap method to swap these functions

     */
    public int[] rotate(int[] nums, int k) {   //5,6,7,1,2,3,4

        k = k%nums.length;

        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k-1);
        swap(nums, k, nums.length - 1);

        return nums;
    }
        private void swap(int[] nums, int left, int right) {

            while(left <right) {
                int temp = nums[right];
                nums[right--] = nums[left];
                nums[left++] = temp;
            }
    }
}
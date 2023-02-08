package Daily_Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class S189_Rotate_Array {

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

    /*
    1. Take k as k%nums.length if k is greater than the length
    2. First reverse all numbers from 0 to end
    3. Now split into 2
            * From 0 to k-1
            * From k to end
    4. Have a swap method to swap these functions
     */
    public int[] rotate(int[] nums, int k) {

        if (k > nums.length)
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
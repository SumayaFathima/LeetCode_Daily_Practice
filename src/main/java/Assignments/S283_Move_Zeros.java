package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S283_Move_Zeros {

    @Test
    public void example1(){
        int[] nums = {0,1,0,3,12};
        int[] output = {1,3,12,0,0};
        Assert.assertEquals(moveZeroes(nums), output);
    }
    @Test
    public void example2(){
        int[] nums = {0};
        int[] output = {0};
        Assert.assertEquals(moveZeroes(nums), output);
    }
    @Test
    public void example3(){
        int[] nums = {0,0,0,0};
        int[] output = {0,0,0,0};
        Assert.assertEquals(moveZeroes(nums), output);
    }
    @Test
    public void example4(){
        int[] nums = {0,0,0,0,1};
        int[] output = {1,0,0,0,0};
        Assert.assertEquals(moveZeroes(nums), output);
    }

    /*
     - create 2 pointers left and right as 0
     - Tarverse while right < nums length
     - if right value != 0 then swap left and right and increment left
     - increment right by default
     - return nums
     */
    public int[] moveZeroes(int[] nums) {

        int left =0, right =0;

        while(right<nums.length) {

            if(nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
        return nums;
    }
}

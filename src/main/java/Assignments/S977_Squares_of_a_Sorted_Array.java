package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class S977_Squares_of_a_Sorted_Array {

    @Test
    public void example1() {
        int[] nums = {-4,-1,0,3,10};
        int[] output = {0,1,9,16,100};
        Assert.assertEquals(sortedSquares(nums), output);
    }

    @Test
    public void example2() {
        int[] nums = {-7,-3,2,3,11};
        int[] output = {4,9,9,49,121};
        Assert.assertEquals(sortedSquares(nums), output);
    }
    @Test
    public void example3() {
        int[] nums = {-5};
        int[] output = {25};
        Assert.assertEquals(sortedSquares(nums), output);
    }
    @Test
    public void example4() {
        int[] nums = {6,-6};
        int[] output = {36,36};
        Assert.assertEquals(sortedSquares(nums), output);
    }

    /*
        - Traverse each element and replace with its squares
        - sort the array and return
     */
    public int[] sortedSquares(int[] nums) {

        for(int i=0; i< nums.length; i++) {
            nums[i] =  nums[i] *  nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}

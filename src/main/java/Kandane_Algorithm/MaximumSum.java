package Kandane_Algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MaximumSum {

    /*
        Given an integer array nums, find the contiguous subarray(containing atleast one number) which has the largest sum
       and return the sum.
       A subarray is a contiguous part of an array.

    */

    @Test
    public void example1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int output = 6;
        Assert.assertEquals(maximumSum(nums), output);
    }

    @Test
    public void example2() {
        int[] nums = {2};
        int output = 2;
        Assert.assertEquals(maximumSum(nums), output);
    }

    @Test
    public void example3() {
        int[] nums = {-2, -1, -7, -8, -4, -1};
        int output = -1;
        Assert.assertEquals(maximumSum(nums), output);
    }

    @Test
    public void example4() {
        int[] nums = {-2,0,-1};
        int output = 0;
        Assert.assertEquals(maximumSum(nums), output);
    }

    @Test
    public void example5() {
        int[] nums = {0,0,0};
        int output = 0;
        Assert.assertEquals(maximumSum(nums), output);
    }


    //kandame algorithm for only positive numbers

    /* private int maximumSum(int[] nums) {

        int maximum = Integer.MIN_VALUE;
        int sum =0;

        for(int i=0; i<nums.length;i++) {

            sum +=nums[i];

            if(sum<0) {
                sum=0;
            }

            maximum =  Math.max(maximum, sum);
        }
            return maximum;
    }
} */

    // Kandane algorithm for positive and negative numbers

    private int maximumSum(int[] nums) {

        int maximum = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (maximum < sum)
                maximum = sum;

            if (sum < 0)
                sum = 0;
        }
        return maximum;
    }
}


//Another way

  /*  private int maximumSum(int[] nums) {

        int result = nums[0];
        int max = nums[0];
        int min = nums[0];

        for(int i=1;i<nums.length;i++) {

            max = Math.max(nums[i], Math.max(nums[i]+max,nums[i]+min));
            min = Math.min(nums[i], Math.min(nums[i]+max,nums[i]+min));

            result = Math.max(result, max);
        }
        return result;
    }
} */


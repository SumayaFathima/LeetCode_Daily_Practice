package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S1493_Longest_Subarray_of_1_s_After_Deleting_One_Element {
    @Test
    public void example1() {
        int[] nums = {1,1,0,1};
        int output = 3;
        Assert.assertEquals(longestSubarray(nums), output);
    }

    @Test
    public void example2() {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        int output = 5;
        Assert.assertEquals(longestSubarray(nums), output);
    }

    @Test
    public void example3() {
        int[] nums = {1,1,1};
        int output = 2;
        Assert.assertEquals(longestSubarray(nums), output);
    }

    @Test
    public void example4() {
        int[] nums = {1,1,0,1};
        int output = 3;
        Assert.assertEquals(longestSubarray(nums), output);
    }
    /*
        - Create 2 pointers left and right
        - Traverse while right < nums length
        - if right value is 0 then increment zercount
        - a loop until zerocount becomes < 1
            - if left value is 0 then decrement zercount
            - incremnt left
        - find the max distance
        - return max
     */
    public int longestSubarray(int[] nums) {

        int left =0, right = 0, zerocount =0;
        int max = Integer.MIN_VALUE;

        while(right < nums.length) {

            if(nums[right] == 0) zerocount++;

            while(zerocount > 1 ) {
                if(nums[left] == 0) zerocount--;
                left++;
            }
            max = Math.max(max, right - left);
            right++;
        }
        return max;
    }
}


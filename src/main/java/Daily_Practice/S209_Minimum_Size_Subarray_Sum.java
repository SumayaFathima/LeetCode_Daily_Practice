package Daily_Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class S209_Minimum_Size_Subarray_Sum {

    @Test
    public void example1() {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int output = 2;
        Assert.assertEquals(minSubArrayLen(nums, target), output);
    }

    public void example2() {
        int[] nums = {1,4,4};
        int target = 4;
        int output = 1;
        Assert.assertEquals(minSubArrayLen(nums, target), output);
    }
    public void example3() {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int output = 2;
        Assert.assertEquals(minSubArrayLen(nums, target), output);
    }

    /* Pseudo code:
        - Create 2 pointers left =0 and right =0
        - Traverse right till array length
        - increment right and add in sum until sum is < target
        - while sum goes beyond or equal to target
        - find length and increment left from sum until sum goes < target
        - if min is still max value return 0
        - return min by default
     */
    public int minSubArrayLen(int[] nums, int target) {

        int left =0, right =0, sum =0, min = Integer.MAX_VALUE;

        while(right< nums.length) {

            sum += nums[right];

            while(sum >= target) {
                min = Math.min(min, right-left+1);
                sum -= nums[left];
                left++;
            }

            right++;
        }

        if(min == Integer.MAX_VALUE) return 0;

        return min;
    }
}

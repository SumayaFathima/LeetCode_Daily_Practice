package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class S01_MinimumSizeSubarraySum {

    /* Leetcode_209 : https://leetcode.com/problems/minimum-size-subarray-sum/

        Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
        subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
        If there is no such subarray, return 0 instead.

        Constraints:

            1 <= target <= 10^9
            1 <= nums.length <= 10^5
            1 <= nums[i] <= 10^4
     */
    @Test
    public void example1() {

        int[] input = {2, 3, 1, 2, 4, 3};
        int k = 7;
        int output = 2;
        Assert.assertEquals(minimumSizeSum(input, k), output);
    }

    @Test
    public void example2() {

        int[] input = {1, 4, 4};
        int k = 4;
        int output = 1;
        Assert.assertEquals(minimumSizeSum(input, k), output);
    }

    @Test
    public void example3() {

        int[] input = {1, 1, 1, 1, 1, 1};
        int k = 11;
        int output = 0;
        Assert.assertEquals(minimumSizeSum(input, k), output);
    }

    @Test
    public void example4() {

        int[] input = {1, 2,3,4,5};
        int k = 11;
        int output = 3;
        Assert.assertEquals(minimumSizeSum(input, k), output);
    }

    /* Pseudo code :

    1. Create two pointers grow and shrink at same place
    2. Traverse while left<input.length, if sum < k then right++ and add the value to the sum
    3. if sum >=k then left --, and subtract its value from the sum and calculate the index distance (right-left)
    4. if the sum <k again, then repeat step 2
    5. Iterate until condition breaks
    6. If adding all values and doesn't meet the target then return 0
    7. Return the distance
     */
    private int minimumSizeSum(int[] input, int k) {

        int distance = Integer.MAX_VALUE;
        int left =0, right =0, sum=0;

        while(left<input.length) {

            if(sum<k && right<input.length )
                sum += input[right++];

            else if (sum >=k) {
                distance = Math.min(distance, right -left);
                sum -= input[left];
                left++;
            }
            else if (distance == Integer.MAX_VALUE) return 0;
            else break;
        }
        return distance;
    }
}

 /*  private int minimumSizeSum(int[] input, int k) {

        if (input.length == 0) return 0;
        if (input.length == 1) return 1;

        int minimum = Integer.MAX_VALUE, length  =0;

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0, right = left, sum=0;

        while (left < input.length && right < input.length) {
                sum += input[right];
                if(sum < k) {
                    map.put(input[right], map.getOrDefault(input[right], 0) + 1);
                    right++;
                }
                else {
                    minimum = Math.min(minimum, right-left+1);
                    map.clear();
                    right = ++left;
                    sum=0;
                }
        }
        return minimum;
    }
}
*/

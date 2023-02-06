package Sliding_Window;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collections;

import static com.google.common.primitives.Ints.reverse;


public class S04_MinDiffBtwnHighestAndLowestOfKScores{

    /* Leetcode_1984 : https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/

    You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student.
    You are also given an integer k.
    Pick the scores of any k students from the array so that the difference between the highest and the lowest of the k scores
    is minimized.
    Return the minimum possible difference.

    Constraints:
        1 <= k <= nums.length <= 1000
        0 <= nums[i] <= 10^5
    */

    @Test
    public void example1() {

        int[] input = {9, 4, 1, 7};
        int k = 2;
        int output = 2;
        Assert.assertEquals(minimumDifferenceHandL(input, k), output);
    }

    @Test
    public void example2() {

        int[] input = {9, 4, 1, 7, 6};
        int k = 3;
        int output = 1;
        Assert.assertEquals(minimumDifferenceHandL(input, k), output);
    }

    @Test
    public void example3() {

        int[] input = {90};
        int k = 1;
        int output = 0;
        Assert.assertEquals(minimumDifferenceHandL(input, k), output);
    }


    /*  Pseudo Code :

       1. Create pointer =0, and diff=0 and sort the array in descending order
       2. Traverse till the length of k in the first window and calculate the diff
       3. Store the diff in minimum
       4. Traverse while pointer <input.length, subtract the pointer with pointer+1 and store in diff
       5. Compare diff and minimum value and store the minimum value in minimum
       6. Iterate the loop while pointer < input.length
       7. Return the minimum value
    */

  /*  public int minimumDifferenceHandL(int[] input, int k) {

        int minimum = Integer.MAX_VALUE;
        int pointer=input.length-1, diff =0;

        if(k<=1) return 0;

        Arrays.sort(input);

        while(pointer>0) {
            diff = input[pointer] - input[pointer-1];
            pointer--;
            break;
        }
        minimum = diff;
        while(pointer>0 ) {
            diff = input[pointer] - input[pointer-1];
            minimum = Math.min(minimum, diff);
            pointer--;
        };

        return minimum;
    }
} */

    public int minimumDifferenceHandL(int[] input, int k) {
        int n = input.length;
        int res = Integer.MAX_VALUE; // 1 4 7 9
        Arrays.sort(input);

        for(int i=0;i<=n-k;i++) {
            res = Math.min(res, input[i + k - 1] - input[i]);
        }
        return res;
        }
}

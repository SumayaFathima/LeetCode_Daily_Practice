package Sliding_Window;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class SubarrayProductLessThanK {

    /* Leetcode_713 : https://leetcode.com/problems/subarray-product-less-than-k/

        Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product
        of all the elements in the subarray is strictly less than k.

        Constraints:
            1 <= nums.length <= 3 * 10^4
            1 <= nums[i] <= 1000
            0 <= k <= 1^6
     */

    @Test
    public void example1() {

        int[] nums = {10, 5, 2, 6};
        int k = 100;
        int output = 8;
        Assert.assertEquals(subarrayProduct(nums, k), output);
    }

    @Test
    public void example2() {

        int[] nums = {1, 2, 3};
        int k = 0;
        int output = 0;
        Assert.assertEquals(subarrayProduct(nums, k), output);
    }

    @Test
    public void example3() {

        int[] nums = {7, 9, 6};
        int k = 2;
        int output = 0;
        Assert.assertEquals(subarrayProduct(nums, k), output);
    }

    @Test
    public void example4() {

        int[] nums = {6};
        int k = 10;
        int output = 1;
        Assert.assertEquals(subarrayProduct(nums, k), output);
    }

    @Test
    public void example5() {

        int[] nums = {1, 1, 1};
        int k = 1;
        int output = 0;
        Assert.assertEquals(subarrayProduct(nums, k), output);
    }

    @Test
    public void example6() {

        int[] nums = {0, 0, 5};
        int k = 10;
        int output = 6;
        Assert.assertEquals(subarrayProduct(nums, k), output);
    }


    /* Pseudo code:

      1. Consider 2 loops i and j
      2. Traverse first loop while i < nums.length. Checks for current value if it is < k and stores in mul
      3. Traverse second loop while j < nums.length and modifies mul by multiplying with the next value
      4. Check for the multiplied value <k, then count++;
      5. Else break and increment i and iterate the loop until the condition fails
      6. Return the count of the subarrays whose product was < k


  /*  private int subarrayProduct(int[] nums, int k) {

        int count = 0, mul = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < k)
                count++;

            mul = nums[i];

            for (int j = i + 1; j < nums.length; j++) {

                mul = mul * nums[j];

                if (mul < k)
                    count++;
                else
                    break;
            }
        }

        return count;
    }
} */

    private int subarrayProduct(int[] nums, int k) {

        if (k == 0) return 0;
        int left = 0, right = 0, mul = 1, count = 0;

       while (right < nums.length) {

            mul = mul * nums[right];

            while (left < nums.length && mul >= k) {
                mul = mul / nums[left];
                left++;
            }

            if (mul < k) {
                count += right - left + 1;

            }
           right++;
        }
        return count;
    }
}

  /*  public int subarrayProduct(int[] nums, int k) {

        int mul = 1, pointer = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {

            mul *= nums[i];
            while (pointer <= i && mul >= k) { // must check l <= i, must be >=
                mul /= nums[pointer++];
            }
            res += i - pointer + 1;  // edge
        }
        return res;
    }
} */

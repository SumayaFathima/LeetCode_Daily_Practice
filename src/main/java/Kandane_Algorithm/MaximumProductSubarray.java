package Kandane_Algorithm;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class MaximumProductSubarray {

    /* Leetcode_152 : https://leetcode.com/problems/maximum-product-subarray/

    Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
    and return the product.
    The test cases are generated so that the answer will fit in a 32-bit integer.
    A subarray is a contiguous subsequence of the array.

    Constraints:
      1 <= nums.length <= 2 * 10^4
      -10 <= nums[i] <= 10
      The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

   */

    @Test
    public void example4() {

        int[] nums = {2, 3, -2, 4};
        int output = 6;
        Assert.assertEquals(maximumProduct(nums), output);
    }


    /* Pseudo code for Bruteforce :

    1. Create two loops i=0 and j=i
    2. Initialize mul =1 after i loop so that for each loop when j begins mul can be 1 to get maximum value
    3. start with first element and prod with mul and find the maximum value
    4. Repeat until condition satisfies
    5. Return maximum
     */

    /*  Bruteforce :

   private int maximumProduct(int[] nums) {

      int maximum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            int mul = 1;

            for(int j = i; j< nums.length; j++) {
                mul = mul * nums[j];
                maximum = Math.max(mul, maximum);
            }
        }
        return maximum;
    }
} */

// Another way :

  /* Pseudo code :

     1. Initially store 0th index value in min, max and result
     2. Traverse the array from 1st index
     3. For each element, update min and max
     4. Max is the maximum of current element and (maximum of product of current element and max, product of current element and min)
     5. Min is the minimum of current element and (minimum of product of current element and max, product of current element and min)
     6. Return maximum of result and max

    */

/* public int maximumProduct(int[] nums) {

        if(nums==null||nums.length==0)   return 0;
        if(nums.length == 1) return nums[0];

        int result = nums[0];
        int max = nums[0];
        int min = nums[0];

        for(int i=1;i<nums.length;i++) {

            max = Math.max(nums[i], Math.max(nums[i]*max,nums[i]*min));
            min = Math.min(nums[i], Math.min(nums[i]*max,nums[i]*min));

            result = Math.max(result, max);
        }
        return result;
    }
}
*/

    // Kandane :
    private int maximumProduct(int[] nums) {//2 3 -2 4

        int prod = 1;
        int maxProd = nums[0];
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            if (maxProd < prod) maxProd = prod;
            if (prod == 0) prod = 1;
        }
        prod = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            prod *= nums[j];
            if (maxProd < prod) maxProd = prod;
            if (prod == 0) prod = 1;
        }
        return maxProd;
    }
}
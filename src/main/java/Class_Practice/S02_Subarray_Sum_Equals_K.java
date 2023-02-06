package Class_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class S02_Subarray_Sum_Equals_K {

    /* Leetcode_560 : https://leetcode.com/problems/subarray-sum-equals-k/

        Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
        A subarray is a contiguous non-empty sequence of elements within an array.

        Constraints:

            1 <= nums.length <= 2 * 104
            -1000 <= nums[i] <= 1000
            -107 <= k <= 107
     */

    @Test
    public void example1() {
        int[] nums = {1,1,1};
        int k=2;
        int output = 2;
        Assert.assertEquals(subarraySum(nums, k), output);
    }

    @Test
    public void example2() {
        int[] nums = {1,2,3};
        int k=3;
        int output = 2;
        Assert.assertEquals(subarraySum(nums, k), output);
    }

    @Test
    public void example3() {
        int[] nums = {-4,2,0,-2};
        int k= -2;
        int output = 4;
        Assert.assertEquals(subarraySum(nums, k), output);
    }

    @Test
    public void example4() {
        int[] nums = {-2,-2,-2,-2};
        int k= 2;
        int output = 0;
        Assert.assertEquals(subarraySum(nums, k), output);
    }

    @Test
    public void example5() {
        int[] nums = {2};
        int k= 5;
        int output = 0;
        Assert.assertEquals(subarraySum(nums, k), output);
    }

    //Bruteforce :

   /*  public int subarraySum(int[] nums, int k) {

            if(nums.length ==1 && nums[0] < k)  return 0;

            int count = 0, sum = 0;

            for (int i = 0; i < nums.length; i++) {
                sum =0;

                for(int j =i; j<nums.length; j++) {

                    sum += nums[j];
                    if(sum == k) {
                        count++;
                    }
                }
            }
            return count;
    }
} */

   public int subarraySum(int[] nums, int k) {

       HashMap<Integer, Integer> map = new HashMap<>();

       int count =0, sum=0;
       map.put(0,1);

       for(int i=0; i<nums.length; i++) {

           sum += nums[i];

           if(map.containsKey(sum-k)) {
               count += map.get(sum-k);
           }
           map.put(sum, map.getOrDefault(sum,0) +1);
       }
        return count;
   }
}

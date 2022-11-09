package Class_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class S02_Subarray_Sums_Divisible_by_K {

    /* Leetcode_974 : https://leetcode.com/problems/subarray-sums-divisible-by-k/

        Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
        A subarray is a contiguous part of an array.

        Constraints:

            1 <= nums.length <= 3 * 10^4
            -10^4 <= nums[i] <= 10^4
            2 <= k <= 10^4

    */

    @Test
    public void example1() {
        int[] nums = {4,5,0,-2,-3,1};
        int k=5;
        int output = 7;
        Assert.assertEquals(subarraysDivByK(nums, k), output);
    }

    @Test
    public void example2() {
        int[] nums = {5};
        int k=9;
        int output = 0;
        Assert.assertEquals(subarraysDivByK(nums, k), output);
    }

    @Test
    public void example3() {
        int[] nums = {1,1,1,1};
        int k=2;
        int output = 4;
        Assert.assertEquals(subarraysDivByK(nums, k), output);
    }

    @Test
    public void example4() {
        int[] nums = {-1,-1,-1,-1};
        int k=2;
        int output = 0;
        Assert.assertEquals(subarraysDivByK(nums, k), output);
    }

    //Bruteforce :
  /*  public int subarraysDivByK(int[] nums, int k) {

        int count =0, sum =0;

        for(int i=0; i<nums.length; i++) {

            sum =0;
            for(int j=i; j<nums.length; j++) {

                sum +=nums[j];

                if(sum %k == 0) {
                    count++;
                }
            }
        }   return count;
    }
} */

    public int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int count =0, sum=0;
        map.put(0,1);

        for(int i=0; i<nums.length; i++) {

            sum += nums[i];

            if(map.containsKey(sum%k ==0)) {
                count += map.get(sum%k ==0);
            }
            map.put(sum, map.getOrDefault(sum,0) +1);
        }
        return count;
    }
}

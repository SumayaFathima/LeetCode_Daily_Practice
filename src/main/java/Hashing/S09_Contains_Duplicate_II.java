package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;

public class S09_Contains_Duplicate_II {

    /* Leetcode_219 : https://leetcode.com/problems/contains-duplicate-ii/

        Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
        such that nums[i] == nums[j] and abs(i - j) <= k.

      Constraints:

        1 <= nums.length <= 10^5
       -109 <= nums[i] <= 10^9
        0 <= k <= 105

     */

    @Test
    public void example1() {   // negative, <, == , >

        int[] nums = {1,2,3,1};
        int k = 3;
        boolean output = true;
        Assert.assertEquals(containsDuplicateII(nums,k), output);
    }

    @Test
    public void example2() {

        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        boolean output = false;
        Assert.assertEquals(containsDuplicateII(nums,k), output);
    }

    @Test
    public void example3() {

        int[] nums = {1,0,1,1};
        int k = 1;
        boolean output = true;
        Assert.assertEquals(containsDuplicateII(nums,k), output);
    }

    @Test
    public void example4() {

        int[] nums = {1,2,2,4};
        int k = 5;
        boolean output = true;
        Assert.assertEquals(containsDuplicateII(nums,k), output);
    }

    @Test
    public void example5() {

        int[] nums = {1,1};
        int k = 0;
        boolean output = false;
        Assert.assertEquals(containsDuplicateII(nums,k), output);
    }

    @Test
    public void example6() {

        int[] nums = {-5,-5};
        int k = 1;
        boolean output = true;
        Assert.assertEquals(containsDuplicateII(nums,k), output);
    }


    /* Pseudo code :

       1. Declare a Hashmap of int and int
       2. Add the numbers to map with the current index value if the number is not in map
       3. If the number is already present in map then it checks for the existing index - current index <=k
       4. Return true if condition satisfies
    */


    public boolean containsDuplicateII(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {

            if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i])-i)<=k){
                return true;
            }
                else
                map.put(nums[i],i);
            }
        return false;
    }
}

    //Bruteforce :

     /*   public boolean containsDuplicateII(int[] nums, int k) {

        for(int i=0; i<nums.length; i++) {

            for(int j=i+1;j<nums.length;j++) {

                if(nums[i] == nums[j] && Math.abs(i-j) <=k)
                    return true;
            }
        } return false;

    }
}
 */
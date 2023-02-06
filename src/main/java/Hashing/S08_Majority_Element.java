package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashMap;

public class S08_Majority_Element {

    /* Leetcode_169 : https://leetcode.com/problems/majority-element/description/

        Given an array nums of size n, return the majority element.
        The majority element is the element that appears more than ⌊n / 2⌋ times.
        You may assume that the majority element always exists in the array.

        Constraints:

          n == nums.length
          1 <= n <= 5 * 104
         -109 <= nums[i] <= 109
     */

    @Test
    public void example1() {

        int[] nums = {3, 2, 3};
        int output = 3;
        Assert.assertEquals(majorityElement(nums), output);
    }

    @Test
    public void example2() {

        int[] nums = {2,2,1,1,1,2,2};
        int output = 2;
        Assert.assertEquals(majorityElement(nums), output);
    }

    @Test
    public void example3() {

        int[] nums = {5,5,5};
        int output = 5;
        Assert.assertEquals(majorityElement(nums), output);
    }

    @Test
    public void example4() {

        int[] nums = {1};
        int output = 1;
        Assert.assertEquals(majorityElement(nums), output);
    }

    @Test
    public void example5() {

        int[] nums = {-1,-2,-2,-2,-1};
        int output = -2;
        Assert.assertEquals(majorityElement(nums), output);
    }

    @Test
    public void example6() {

        int[] nums = {-5};
        int output = -5;
        Assert.assertEquals(majorityElement(nums), output);
    }

    /* Pseudo code:

        1. Declare a Hashmap of int and int
        2. Add the numbers to map with the frequency value
        3. If the frequency value crosses n/2, return the num

    */

    public int majorityElement(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
            if(map.get(n) > nums.length/2)
                return n;
        }
        return 0;
    }
}

    // Bruteforce :

  /*  public int majorityElement(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
            if (count > nums.length / 2)
                return nums[i];
        }
        return 0;
    }
} */
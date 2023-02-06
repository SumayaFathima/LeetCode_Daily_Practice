package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class S03_Number_of_Good_Pairs {

    /* Leetcode_1512 : https://leetcode.com/problems/number-of-good-pairs/description/

        Given an array of integers nums, return the number of good pairs.
        A pair (i, j) is called good if nums[i] == nums[j] and i < j.

        Constraints:

        1 <= nums.length <= 100
        1 <= nums[i] <= 100
    */


    @Test
    public void example1() {

        int[] nums = {1, 2, 3, 1, 1, 3};
        int output = 4;
        Assert.assertEquals(numberofGoodPairs(nums), output);
    }

    @Test
    public void example2() {

        int[] nums = {1,1,1,1};
        int output = 6;
        Assert.assertEquals(numberofGoodPairs(nums), output);
    }

    @Test
    public void example3() {

        int[] nums = {1, 2, 3};
        int output = 0;
        Assert.assertEquals(numberofGoodPairs(nums), output);
    }

    @Test
    public void example4() {

        int[] nums = {1,1,0,0,2,3};
        int output = 2;
        Assert.assertEquals(numberofGoodPairs(nums), output);
    }

/* Pseudo code :

    1. Declare a HashMap that stores key and value in the form of <nums[i], frequency of nums[i]>
    2. Loop once through the array to store <K,V> in map
    3. Check if map contains nums[i]
    4. Increase the count if nums[i] is repeated
    5. Also add it to the map and increase it's frequency.
    6. Else add it to map and initialize count to 1 as the first occurence of nums[i]
    7. Return count
 */

    public int numberofGoodPairs(int[] nums) {
    int count= 0;

    HashMap<Integer,Integer> map = new HashMap<>();

       for(int i=0; i<nums.length; i++)
         {

           if (map.containsKey(nums[i]))
             {
                 count += map.get(nums[i]);
                 map.put(nums[i], map.get(nums[i]) + 1);
            }
           else {
                 map.put(nums[i], 1);
           }
        }
        return count;
    }
}

    /* Bruteforce :
    int count =0;

        for(int i=0; i<nums.length; i++) {

        for(int j=0; j<nums.length; j++) {

            if(nums[i]== nums[j] && i<j) {
                count++;
            }
        }
    } return count;
  }
} */




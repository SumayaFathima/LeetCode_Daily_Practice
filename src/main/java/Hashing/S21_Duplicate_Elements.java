package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S21_Duplicate_Elements {

    /* Given an array and a positive number k, check whether the array contains any duplicate elements within the range k.
        If k is more than the array’s size, the solution should check for duplicates in the complete array.

    */


    @Test
    public void example1() {

        int[] nums = {1, 2, 3, 2};
        int k = 4;
        String output = "Duplicates found";
        Assert.assertEquals(nearbyDuplicate(nums, k), output);
    }

    @Test
    public void example2() {

        int[] nums = {1,0,1,1};
        int k = 1;
        String output = "Duplicates found";
        Assert.assertEquals(nearbyDuplicate(nums, k), output);
    }

    @Test
    public void example3() {

        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        String output = "Duplicates not found";
        Assert.assertEquals(nearbyDuplicate(nums, k), output);
    }

    /* Pseudo code :

     1. Declare hashmap of Integer and Integer
     2. Traverse while i<nums.length
     3. If map contains i then find the difference between i and the exiting index
     4. If the diff <=k then return duplicate else add in map
     5. Return not duplicate by default

    */
 /*   public String nearbyDuplicate(int[] nums, int k) {

        String dup = "Duplicates found";
        String notdup = "Duplicates not found";

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int diff = i - map.get(nums[i]);
                if (Math.abs(diff) <= k)
                    return dup;
            }
            map.put(nums[i], i);
        }
        return notdup;
    }
} */
   public String nearbyDuplicate(int[] nums, int k) {

        String dup = "Duplicates found";
        String notdup = "Duplicates not found";

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                if (set.size() > k) {
                set.remove(nums[i - k]);
                return dup;
            }
            else
                set.add(nums[i]);

        } return notdup;
    }
}
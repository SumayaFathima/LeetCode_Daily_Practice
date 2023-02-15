package Daily_Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;

public class S219_Contains_Duplicate_II {

    @Test
    public void example1() {
        int[] nums = {1,2,3,1};
        int k = 3;
        boolean output = true;
        Assert.assertEquals(containsDuplicateII(nums,k), output);
    }


    @Test
    public void example2() {
        int[] nums = {1,2,2,4};
        int k = 5;
        boolean output = true;
        Assert.assertEquals(containsDuplicateII(nums,k), output);
    }

    @Test
    public void example3() {
        int[] nums = {2,2};
        int k = 0;
        boolean output = false;
        Assert.assertEquals(containsDuplicateII(nums,k), output);
    }

    @Test
    public void example4() {
        int[] nums = {-6,-6};
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
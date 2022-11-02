package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;

public class Contains_Duplicate_II {

    @Test
    public void example1() {

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
    public void example4() {   //this should be true only right but has n

        int[] nums = {1};
        int k = 5;
        boolean output = false;
        Assert.assertEquals(containsDuplicateII(nums,k), output);
    }

    @Test
    public void example5() {

        int[] nums = {1};
        int k = 0;
        boolean output = false;
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

    //Bruteforce :   --> Time limit exceeded

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
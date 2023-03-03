package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class S1512_Number_of_Good_Pairs {

    @Test
    public void example1() {
        int[] nums = {1,2,3,1,1,3};
        int output = 4;
        Assert.assertEquals(numIdenticalPairs(nums), output);
    }

    @Test
    public void example2() {

        int[] nums = {1,1,1,1};
        int output = 6;
        Assert.assertEquals(numIdenticalPairs(nums), output);
    }

    @Test
    public void example3() {

        int[] nums = {1, 2, 3};
        int output = 0;
        Assert.assertEquals(numIdenticalPairs(nums), output);
    }

    @Test
    public void example4() {

        int[] nums = {5,5,4,4,1,2,6,6,6};
        int output = 5;
        Assert.assertEquals(numIdenticalPairs(nums), output);
    }

    /*
    Pseudo code :
        - Create a hashmap and add each element in map
        - If map contains element, get the value and add in count then increment the frequency
        - else add in map
        - return the count
     */
    public int numIdenticalPairs(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int count= 0;

        for(int i=0; i<nums.length; i++)
        {
            if (map.containsKey(nums[i])) {
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
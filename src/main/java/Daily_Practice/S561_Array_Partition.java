package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class S561_Array_Partition {

    @Test
    public void example1() {
        int[] nums = {1,4,3,2};
        int output = 4;
        Assert.assertEquals(arrayPairSum(nums), output);
    }

    @Test
    public void example2() {
        int[] nums = {6,2,6,5,1,2};
        int output = 9;
        Assert.assertEquals(arrayPairSum(nums), output);
    }

    /*
    Sort the array
    Traverse from 0 till nums.length. Have increment as i+=2
    Find min of i and i+1 and add in sum
    Return sum
     */
    public int arrayPairSum(int[] nums) {

        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += Math.min(nums[i], nums[i+1]);
        }
        return sum;
    }
}

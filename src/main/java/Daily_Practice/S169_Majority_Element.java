package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class S169_Majority_Element {

    @Test
    public void example1() {
        int[] nums = {3,2,3};
        int output = 3;
        Assert.assertEquals(majorityElement(nums), output);
    }

    @Test
    public void example2() {
        int[] nums = {2,2,1,1,1,2,2};
        int output = 2;
        Assert.assertEquals(majorityElement(nums), output);
    }

    /*
     - Sort the array
     - find the middle index by (left+right)/2;
     - return middle value in the array

     */
    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        int left =0, right = nums.length-1;

        int middle = (left+right)/2;

        return nums[middle];

    }
}

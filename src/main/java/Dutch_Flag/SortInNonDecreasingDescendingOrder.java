package Dutch_Flag;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortInNonDecreasingDescendingOrder {


     /*
        Given an array which contains only 0,1, and . Sort the array in an non-decreasing descending order.
    */

    @Test
    public void example1() {
        int[] nums = {1, 2, 0, 1, 2};
        int[] output = {2,2,1,1,0};
        Assert.assertEquals(sortArrayDescending(nums), output);
    }

    @Test
    public void example2() {
        int[] nums = {0,1, 1,2,0};
        int[] output = {2,1,1,0,0};
        Assert.assertEquals(sortArrayDescending(nums), output);
    }

   /* Condition
        1.Initialize low = nums.length -1, middle = nums.length-1, high = 0
        2.If the nums[middle] is 2, swap middle and high values and high++ pointer
        3.If the nums[middle] is 1, decrement middle pointer
        4.If the nums[middle] is 0, swap middle and low values and low--, middle-- pointer
        5.Break the loop when middle>=high or when middle > high
   */
    public int[] sortArrayDescending(int[] nums) {

        int low = nums.length -1, middle = nums.length-1, high = 0;

        while (middle >= high) {

            if (nums[middle] == 2) {
                int temp = nums[high];
                nums[high] = nums[middle];
                nums[middle] = temp;
                high++;
            }
            else if (nums[middle] == 1) {
                middle--;
            }
            else {
                int temp = nums[low];
                nums[low] = nums[middle];
                nums[middle] = temp;
                low--;
                middle--;
            }
        }
        return nums;
    }
}
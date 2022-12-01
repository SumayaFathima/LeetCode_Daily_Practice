package Dutch_Flag;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortInNonDecreasingAscendingOrder {


     /*
        Given an array which contains only 0,1, and 2. Sort the array in an non-decreasing order.

    */

    @Test
    public void example1() {
        int[] nums = {1, 2, 0, 1, 2};
        int[] output = {0, 1, 1, 2, 2};
        Assert.assertEquals(sortArrayAscending(nums), output);
    }

    @Test
    public void example2() {
        int[] nums = {0,1, 1, 2, 0};
        int[] output = {0,0,1,1,2};
        Assert.assertEquals(sortArrayAscending(nums), output);
    }

    /* Condition
     1.Initialize low = 0, middle = 0 high = nums.length-1
     2.If the nums[middle] is 2, swap middle and high values and high-- pointer
     3.If the nums[middle] is 1, increment middle pointer
     4.If the nums[middle] is 0, swap middle and low values and low++, middle++ pointer
     5.Break the loop when middle<=high or when middle > high
*/
 /*   public int[] sortArrayAscending(int[] nums) {

        int low = 0, middle = 0, high = nums.length - 1;

        while (middle <= high) {

            if (nums[middle] == 0) {

                int temp = nums[middle];
                nums[middle] = nums[low];
                nums[low] = temp;
                middle++;
                low++;
            }
            else if (nums[middle] == 1) {
                middle++;
            }
            else {
                int temp = nums[middle];
                nums[middle] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
        return nums;
    }
} */


    // Bruteforce :

       public int[] sortArrayAscending(int[] nums) {

        int[] newarray = new int[nums.length];
        int index = 0;

      //  for (int i : new int[]{0, 1, 2}) {
           for (int i = 0; i <= 2 ; i++) {
            for (int j = 0; j < newarray.length; j++) {

                if (nums[j] == i)
                    newarray[index++] = i;
            }
        }
        return newarray;
    }
}
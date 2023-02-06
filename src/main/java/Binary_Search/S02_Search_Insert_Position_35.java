package Binary_Search;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Arrays;

public class S02_Search_Insert_Position_35 {

    /* Leetcode : https://leetcode.com/problems/search-insert-position/

       Given a sorted array of distinct integers and a target value, return the index if the target is found.
       If not, return the index where it would be if it were inserted in order.

       You must write an algorithm with O(log n) runtime complexity.

    Constraints:

            1 <= nums.length <= 104
            -104 <= nums[i] <= 104
            nums contains distinct values sorted in ascending order.
            -104 <= target <= 104
     */

    @Test
    public void example1() {

        int[] nums = {1,3,5,6};
        int target = 5;
        int output = 2;
        Assert.assertEquals(searchInsert(nums, target), output);
    }

    @Test
    public void example2() {

        int[] nums = {1,3,5,6};
        int target = 7;
        int output = 4;
        Assert.assertEquals(searchInsert(nums, target), output);
    }
    @Test
    public void example4() {

        int[] nums = {1,3,5,6};
        int target = 2;
        int output = 1;
        Assert.assertEquals(searchInsert(nums, target), output);
    }

    @Test
    public void example5() {

        int[] nums = {3};
        int target = 2;
        int output = 0;
        Assert.assertEquals(searchInsert(nums, target), output);
    }

    @Test
    public void example6() {

        int[] nums = {3};
        int target = 4;
        int output = 1;
        Assert.assertEquals(searchInsert(nums, target), output);
    }

    @Test
    public void example7() {

        int[] nums = {-3,-1,5,6};
        int target = -2;
        int output = 1;
        Assert.assertEquals(searchInsert(nums, target), output);
    }

    /*


     */
    public int searchInsert(int[] nums, int target) {

     int left =0, right = nums.length-1, mid;   //1 3 5 6 //7

        while(left<=right) {

            mid = (left+right)/2;

            if(nums[mid] < target) {
                left = mid +1;
            }
            else if(nums[mid] > target) {
                right = mid -1;
            }
            else
                return mid;
        }

        return left;

    }
}

//Using
 /*   public int searchInsert(int[] nums, int target) {  // -1-1 = -2 *-1 2 -1

        int index = Arrays.binarySearch(nums, target);
        if(index < 0)
            return (-1*index)-1;

        return index;
    }
} */

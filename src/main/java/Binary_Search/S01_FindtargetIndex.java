package Binary_Search;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class S01_FindtargetIndex {


    /* Leetcode_704: https://leetcode.com/problems/binary-search/description/

    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function
    to search target in nums. If target exists, then return its index. Otherwise, return -1.
    You must write an algorithm with O(log n) runtime complexity.

     */

    @Test
    public void example1() {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int output = 4;
        Assert.assertEquals(find(nums, target), output);
    }

    @Test
    public void example2() {

        int[] nums = {-1,0,3};
        int target = 5;
        int output = -1;
        Assert.assertEquals(find(nums, target), output);
    }

    @Test
    public void example3() {

        int[] nums = {};
        int target = 9;
        int output = -1;
        Assert.assertEquals(find(nums, target), output);
    }

    @Test
    public void example4() {

        int[] nums = {-1,0,3,5,9,12};
        int target = 12;
        int output = 5;
        Assert.assertEquals(find(nums, target), output);
    }

    @Test
    public void example5() {

        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        int output = -1;
        Assert.assertEquals(find(nums, target), output);
    }

    @Test
    public void example6() {

        int[] nums = {1};
        int target = 1;
        int output = 0;
        Assert.assertEquals(find(nums, target), output);
    }

    public int find(int[] nums, int target) {

        int left =0, right = nums.length-1, mid;   // -1 0 3 5 9 12 //2

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

        return -1;

    }
}

package Assessment;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Two_Sum_II_Input_Array_Is_Sorted {

    /* Leetcode_167 : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that
    they add up to a specific target number.
    Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
    The tests are generated such that there is exactly one solution. You may not use the same element twice.
    Your solution must use only constant extra space.

    Constraints:

        2 <= numbers.length <= 3 * 10^4
        -1000 <= numbers[i] <= 1000
        numbers is sorted in non-decreasing order.
        -1000 <= target <= 1000
        The tests are generated such that there is exactly one solution.

   */

    @Test
    public void example1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] output = {1, 2};
        Assert.assertEquals(twoSum(nums, target), output);
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 4};
        int target = 6;
        int[] output = {1, 3};
        Assert.assertEquals(twoSum(nums, target), output);
    }

    @Test
    public void example3() {
        int[] nums = {-1, 0};
        int target = -1;
        int[] output = {1, 2};
        Assert.assertEquals(twoSum(nums, target), output);
    }

    @Test
    public void example4() {
        int[] nums = {-2, -2, -2, -2, -2};
        int target = -4;
        int[] output = {1, 5};
        Assert.assertEquals(twoSum(nums, target), output);
    }

    @Test
    public void example5() {
        int[] nums = {0, 0, 3, 4};
        int target = 3;
        int[] output = {1, 3};
        Assert.assertEquals(twoSum(nums, target), output);
    }

    /* Pseudo code:
        1. Create two pointers left=0, right=nums.length-1
        2. Traverse while left<right
        3. add left and right and store in sum
        4. If sum is equal to target then return the index value which starts with index 1
	    5. If sum > target, decrement right
	    6. Else decrement left
	    7. Return null by default

     */
   /* public int[] twoSum(int[] nums, int target) {

        int left=0, right=nums.length-1,sum=0;

        while(left<right) {
            sum = nums[left] + nums[right];

            if(sum == target) {
                return new int[]{left+1, right+1};
            }

            else if(sum > target)
                right--;

            else
                left++;

        } return null;
    }
} */

//Bruteforce :

    public int[] twoSum(int[] nums, int target) {

        int[] arr = new int[2];

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    arr[0] = i + 1;
                    arr[1] = j + 1;
                }
            }
        }
        return arr;
    }
}
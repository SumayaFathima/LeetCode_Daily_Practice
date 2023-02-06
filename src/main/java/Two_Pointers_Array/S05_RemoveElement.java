package Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class S05_RemoveElement {
	
	 /* Leetcode_27 : leetcode.com/problems/remove-element/
	  
	Given an integer array nums and an integer val, remove all occurrences
	of val in nums in-place. The relative order of the elements may be changed.
	
	Since it is impossible to change the length of the array in some languages,
	you must instead have the result be placed in the first part of the array nums.
	More formally, if there are k elements after removing the duplicates,
	then the first k elements of nums should hold the final result.
	It does not matter what you leave beyond the first k elements.
	
	Return k after placing the final result in the first k slots of nums.
	
	Do not allocate extra space for another array. You must do this by modifying
	the input array in-place with O(1) extra memory.
	
	Constraints:

	0 <= nums.length <= 100
	0 <= nums[i] <= 50
	0 <= val <= 100
	
	*/


	@Test
	public void example1() {
		int[] nums = {5, 3, 2, 1, 2, 3};
		int val = 3;
		int output = 2;
		Assert.assertEquals(removeElement(nums, val), output);
	}

	@Test
	public void example2() {
		int[] nums = {5};
		int val = 3;
		int output = 1;
		Assert.assertEquals(removeElement(nums, val), output);
	}

	@Test
	public void example3() {
		int[] nums = {4};
		int val = 4;
		int output = 0;
		Assert.assertEquals(removeElement(nums, val), output);
	}

	@Test
	public void example4() {
		int[] nums = {};
		int val = 8;
		int output = 0;
		Assert.assertEquals(removeElement(nums, val), output);
	}
	
	/*
	Pseudo Code :
	 
	 1. Check the condition if array length is 0, return 0;
	 2. Create two pointers, left=0 and right=0
	 2. Traverse till left <nums.length
	 3. If left != val, swap left and right and increment both
	 4. else increment left alone
	 5. Return right
	 */

	public int removeElement(int[] nums, int val) {

		if (nums.length == 0) return 0;

		int left = 0, right = 0;

		while (right < nums.length) {

			if (nums[right] != val) {
				nums[left++] = nums[right];
				right++;
			} else right++;
		}
		return left;
	}

}

	/*public int removeElement(int[] nums, int val) {

		if(nums.length == 0) return 0;
		int left =0;

		for(int right =0; i< nums.length; right++) {
			if (nums[right] != val) {
				nums[left++] = nums[right];
			}
		}
	}
} */


/*	public int removeElement(int[] nums, int val) {

		int left =0, right =0,count=0;

		while(right<nums.length) {

			if(nums[right]!=val) {

				nums[left++] = nums[right];
				right++;
				count++;
			}
			else
				right++;
		}
		return count;
	}
} */

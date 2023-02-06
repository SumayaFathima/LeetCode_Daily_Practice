package Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class 	S01_MoveZeroes {

    /*  Leetcode_283 :  https://leetcode.com/problems/move-zeroes/
    
    
    Given an integer array nums, move all 0's to the end of it while maintaining
    the relative order of the non-zero elements.    
    Note that you must do this in-place without making a copy of the array.
    
    Constraints:

	1 <= nums.length <= 104
	-2^31 <= nums[i] <= 2^31 - 1
	
	*/

	@Test
	public void example1() {
		
		int[] nums = {0,1,0,3,12};
		int[] output = {1,3,12,0,0};
		Assert.assertEquals(moveZeroes(nums), output);
	}
	
	@Test
	public void example2() {
		
		int[] nums = {1,0,1};
		int[] output = {1,1,0};
		Assert.assertEquals(moveZeroes(nums), output);
	}
	
	@Test
	public void example3() {
		
		int[] nums = {0};
		int[] output = {0};
		Assert.assertEquals(moveZeroes(nums), output);
	}
	
	@Test
	public void example4() {
		
		int[] nums = {0,0,5,0,0};
		int[] output = {5,0,0,0,0};
		Assert.assertEquals(moveZeroes(nums), output);
	}
		
	
	/*
	  Pseudo Code :	 
	  
	  1. Create pointers left = 0 and right = 0
	  2. Traverse till left<nums.length
	  3. If nums[left] != 0, then swap and increment both
	  4. Else increment left alone
	  6. Return nums
	 */
	
	 public static int[] moveZeroes(int[] nums) {
		 
		 int left=0, right=0;
			
			while(left<nums.length) {								
					
				if(nums[left] != 0) {
					
					int temp = nums[right];
					nums[right] = nums[left];
					nums[left] = temp;
					right++;
					left++;}
					
				else
					left++;
			}
			 return nums;
		 }
	}

	/* Bruteforce :

	 public static int[] moveZeroes(int[] nums) {

		 for(int i =0, j= 0; i<nums.length; i++) {

			 if(nums[i] != 0) {
				 int temp = nums[i];
				 nums[i]= nums[j];
				 nums[j] = temp;
				 j++;
			 }

		 }   return nums;
	 }
} */
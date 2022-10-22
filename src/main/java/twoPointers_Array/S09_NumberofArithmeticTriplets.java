package twoPointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S09_NumberofArithmeticTriplets {

	/* Leetcode_2367 :  https://leetcode.com/problems/number-of-arithmetic-triplets/
	
	You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. 
	A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:

			i < j < k,
			nums[j] - nums[i] == diff, and
			nums[k] - nums[j] == diff.
		Return the number of unique arithmetic triplets.
	*/
	
	@Test
	public void example1() {
		
		int nums[] = {0,1,4,6,7,10}; 
		int diff = 3;	
		int[] output = {2};
		Assert.assertEquals(arithmeticTriplets(nums,diff), output);
	}
	
	@Test
	public void example2() {
		
		int nums[] = {4,5,6,7,8,9}; 
		int diff = 2;	
		int[] output = {2};
		Assert.assertEquals(arithmeticTriplets(nums,diff), output);
	}
	
	@Test
	public void example3() {
		
		int nums[] = {4,50,100,200}; 
		int diff = 2;	
		int[] output = {0};
		Assert.assertEquals(arithmeticTriplets(nums,diff), output);
	}
	
	/* Pseudo code:
	 
	 	1. Initialize count=0; 
	 	2. Traverse through loop of i, j and k until nums[j] - nums[i] == diff && nums[k] - nums[j] == diff is satisfied
	 	3. store the count of occurrence and return the count
	 	
	*/
	
	 public int arithmeticTriplets(int[] nums, int diff) {
	
		 int count =0;
		 for(int i=0;i<nums.length;i++) {
		 
			 int j = i+1;
			 int k = nums.length-1;
			 
			 while(j<k) {		     

		          if((nums[j]-nums[i])!=diff)  
		        	  	j++;
		
		          else if((nums[k]-nums[j])!=diff) 
		        	   	k--;
		
		          else if ((nums[j]-nums[i]==diff) && (nums[k]-nums[j]==diff)) { 

		        	   	count++;
                        j++;
		        	   	k--;
		        	   		  }
		      }
		    } return count;
		 } 
		 
	  }

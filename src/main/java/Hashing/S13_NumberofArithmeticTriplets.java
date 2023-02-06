package Hashing;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class S13_NumberofArithmeticTriplets {

	/* Leetcode_2367 :  https://leetcode.com/problems/number-of-arithmetic-triplets/
	
		You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff.
		A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:

			i < j < k,
			nums[j] - nums[i] == diff, and
			nums[k] - nums[j] == diff.
		Return the number of unique arithmetic triplets.

		Constraints:

			3 <= nums.length <= 200
			0 <= nums[i] <= 200
			1 <= diff <= 50
			nums is strictly increasing.

	*/

	@Test
	public void example1() {

		int nums[] = {0, 1, 4, 6, 7, 10};
		int diff = 3;
		int output = 2;
		Assert.assertEquals(arithmeticTriplets(nums, diff), output);
	}

	@Test
	public void example2() {

		int nums[] = {4, 5, 6, 7, 8, 9};
		int diff = 2;
		int output = 2;
		Assert.assertEquals(arithmeticTriplets(nums, diff), output);
	}

	@Test
	public void example3() {

		int nums[] = {4, 50, 100, 200};
		int diff = 2;
		int output = 0;
		Assert.assertEquals(arithmeticTriplets(nums, diff), output);
	}

	@Test
	public void example4() {

		int nums[] = {0,0,0};
		int diff = 1;
		int output = 0;
		Assert.assertEquals(arithmeticTriplets(nums, diff), output);
	}

	/* Pseudo code:

		1. Declare a Hashmap of int and int
		2. Add the nums into map
		3. In another loop, check for the key in map with the array numbers that satisfies below condition
				nums[i] + diff) && map.containsKey(nums[i] + diff*2) and increment the count
		4. Return the count

	 */

	/* public int arithmeticTriplets(int[] nums, int diff) {

		int count = 0;
		HashMap<Integer,Integer> map = new HashMap();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0));
		}

		for (int i = 0; i < nums.length; i++) {

			if (map.containsKey(nums[i] + diff) && map.containsKey(nums[i] + diff*2)) {
				count++;
			}
		}
		return count;
	}
} */

	// Using for-each

	 public int arithmeticTriplets(int[] nums, int diff) {

		int count = 0;
		HashMap<Integer, Integer> map = new HashMap();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (map.containsKey(entry.getKey() + diff) && map.containsKey(entry.getKey() + diff*2)) {
				count++;
			}
		}
		return count;
	}
}
	
	/* Pseudo code:
	 
	 	1. Initialize count=0, j = i+1 and k = nums.length-1
	 	2. Traverse through loop of i, j and k until nums[j] - nums[i] == diff and then find nums[k] - nums[j] == diff
	 	3. store the count of occurrence if both the condition satisfies and iterate again
	 	4. Return the count
	 	
	*/

	/* public int arithmeticTriplets(int[] nums, int diff) {

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
} */
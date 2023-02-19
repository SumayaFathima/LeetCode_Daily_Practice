package Revision;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class S2367_NumberofArithmeticTriplets {

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
		1. Declare a Hashmap and all nums in map
		3. A loop to check if map contains nums[i] + diff and nums[i] + diff*2. if yes increment the count
		4. Return the count
	 */

	 public int arithmeticTriplets(int[] nums, int diff) {

		HashMap<Integer,Integer> map = new HashMap();
		 int count = 0;

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {

			if (map.containsKey(nums[i] + diff) && map.containsKey(nums[i] + diff*2)) {
				count++;
			}
		}
		return count;
	}
}
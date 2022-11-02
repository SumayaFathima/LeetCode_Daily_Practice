package Two_Pointers_Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S07_IntersectionOfTwoArrays {
	
	/* Leetcode_349 :  https://leetcode.com/problems/intersection-of-two-arrays/
	
	Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be
	unique and you may return the result in any order.
		
	  Constraints:

		1 <= nums1.length, nums2.length <= 1000
		0 <= nums1[i], nums2[i] <= 1000
	*/
	
	@Test
	public void example1() {
		int nums1[] = {1,2,2,1}; 
		int nums2[] = {2,2};	
		int[] output = {2};
		Assert.assertEquals(intersection(nums1,nums2), output);
	}
	
	@Test
	public void example2() {
		int nums1[] = {4,9,5}; 
		int nums2[] = {9,4,9,8,4};	
		int[] output = {4,9};
		Assert.assertEquals(intersection(nums1,nums2), output);
	}
	
	@Test
	public void example3() {
		int nums1[] = {5}; 
		int nums2[] = {6};	
		int[] output = {};
		Assert.assertEquals(intersection(nums1,nums2), output);
	}
	
	@Test
	public void example4() {
		int nums1[] = {8,8,8}; 
		int nums2[] = {8};	
		int[] output = {8};
		Assert.assertEquals(intersection(nums1,nums2), output);
	}
	
  /*
	Pseudocode :
	 
	 1. create pointers left =0, right = 0
	 2. Sort the two arrays and create an Hashset to get unique values
	 3. Traverse while left<nums1.length and right<nums2.length
	 4. If the numbers are equal, add to arrayList and increment both 
	 5. If nums1[left] is less than nums2[right] then increment left
	 5. If nums2[left] is less than nums1[left] then increment right
	 6. Convert set into output array and return the same	 
 */	
	
	public static int[] intersection(int[] nums1, int[] nums2) {

		int left =0, right = 0, arrindex=0;		
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);		
		
		Set<Integer> s = new HashSet();
		
		while(left<nums1.length && right < nums2.length) {
			
			if(nums1[left] ==  nums2[right]) {
				s.add(nums2[right++]);				
				left++;
			}	
			else if(nums1[left] < nums2[right]) {
				left++; }
			
			else 
				right++; }
		
		int[] arr = new int[s.size()];
        for(Integer a: s)   {
            arr[arrindex++]=a;  
        }
        
        return arr;
    }
}

/*	public static int[] intersection(int[] nums1, int[] nums2) {

			Arrays.sort(nums1);
			Arrays.sort(nums2);
			Set<Integer> s = new HashSet();

			int k = 0;

			for (int i = 0; i < nums1.length; i++) {
				for (int j = 0; j < nums2.length; j++) {
					if (nums1[i] == nums2[j]) {
						s.add(nums1[i]);
						nums2[j] = 0;
						break;
					}
				}
			}
			int[] arr = new int[s.size()];
			for(Integer a : s) {
				arr[k++] = a;
			}

        // for (int j = 0; j < s.size(); j++) {
        //     arr[j] = s.get(j);
        // }

			return arr;
		}
	} */
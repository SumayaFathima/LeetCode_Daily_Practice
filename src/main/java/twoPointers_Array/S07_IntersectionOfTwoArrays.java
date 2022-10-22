package twoPointers_Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S07_IntersectionOfTwoArrays {
	
	/* Leetcode_349 :  https://leetcode.com/problems/shortest-distance-to-a-character/
	
		Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length 
		and answer[i] is the distance from index i to the closest occurrence of character c in s.
		
		The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
		
	  Constraints:

		1 <= s.length <= 104
		s[i] and c are lowercase English letters.
		It is guaranteed that c occurs at least once in s.
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
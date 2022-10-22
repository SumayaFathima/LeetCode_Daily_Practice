package twoPointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

	public class S03_MergeSortedArray {
		
	/*  Leetcode_88 :  https://leetcode.com/problems/merge-sorted-array/
	 	   
	    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
	    and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
	    
	    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
	    The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
	    To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
	    and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
	    
	    Constraints:
	    
	    nums1.length == m + n
	    nums2.length == n
	    0 <= m, n <= 200
	    1 <= m + n <= 200
	    -10^9 <= nums1[i], nums2[j] <= 10^9
	*/
		
		
		@Test
	    public void example1(){
	        int[] nums1={1,2,3,0,0,0};
	        int m=3;
	        int[] nums2={2,5,6};
	        int n=3;
	        int[] output = {1,2,2,3,5,6};
	        Assert.assertEquals(merge(nums1,m,nums2,n), output);
	    }
		
	   @Test
	   public void example2(){
		    int[] nums1={0};
		    int m=0;
		    int[] nums2={1};
		    int n=1;
		    int[] output = {1};
		    Assert.assertEquals(merge(nums1,m,nums2,n), output);
		    }
		
	    @Test
	    public void example3(){
	        int[] nums1={1};
	        int m=1;
	        int[] nums2={};
	        int n=0;
	        int[] output = {1};
	        Assert.assertEquals(merge(nums1,m,nums2,n), output);
	    }
	    
	 /*Pseudo code :
		 
		 1. create two pointers left = m-1 and right = n-1 and newindex = nums1.length-1;
		 2. traverse while left >=0 or right>=0
		 3. left or right index which ever is greater, add to the newindex and decrement both
		 4. if right or left goes below 0, add value of other index and decrement both
		 5. if left<0, then the right index value to be added to the newindex and decrement both
		 6. return nums1
	 */
	    
	public int[] merge(int[] nums1, int m, int[] nums2, int n) {
		
		int left = m-1, right= n-1, newindex = nums1.length-1;
		
		while(left>=0 || right>=0) {
			
			if(right>=0 && left>=0) {
							
				if(nums1[left] <= nums2[right]) {
					nums1[newindex--] = nums2[right--];
				} 
				else {
					nums1[newindex--] = nums1[left--];
				}
			}	
			if(right<0) nums1[newindex--] = nums1[left--];
			
			else if(left < 0) nums1[newindex--] = nums2[right--];
				
	    } return nums1;
	}
}
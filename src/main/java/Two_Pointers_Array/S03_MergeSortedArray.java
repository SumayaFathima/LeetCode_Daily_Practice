package Two_Pointers_Array;

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
		 
		 1. Create two pointers left = m-1 and right = n-1 and newindex = m+n-1;
		 2. Traverse while p1 >=0 and p2>=0
		 3. If p1 > p2, add p1 to newindex and decrement both
		 4. Else add p2 to newindex and decrement both
		 5. Return nums1
	 */
	    
	public int[] merge(int[] nums1, int m, int[] nums2, int n) {
		
		int p1 = m-1, p2 = n-1, newindex = m+n-1;

		while(p2 >= 0){

			if(p1 >= 0 && nums1[p1] > nums2[p2]){
				nums1[newindex--] = nums1[p1--];
			}
			else
				nums1[newindex--] = nums2[p2--];

		} return nums1;
	}
	}


/* Bruteforce :

	public int[] merge(int[] nums1, int m, int[] nums2, int n) {

		for (int i = 0; i < n; i++, m++) {
		nums1[m] = nums2[i];
		}
		Arrays.sort(nums1);
		return nums1;
		}
		}
*/
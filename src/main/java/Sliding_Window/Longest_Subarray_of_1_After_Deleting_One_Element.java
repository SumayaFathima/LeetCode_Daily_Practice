package Sliding_Window;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Arrays;

public class    Longest_Subarray_of_1_After_Deleting_One_Element {

    /* Leetcode_1493 : https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

    Given a binary array nums, you should delete one element from it.
    Return the size of the longest non-empty subarray containing only 1's in the resulting array.
    Return 0 if there is no such subarray.

    Constraints:

    1 <= nums.length <= 10^5
    nums[i] is either 0 or 1.

   */

    @Test
    public void example1() {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int output = 4;
        Assert.assertEquals(longestSubarray(nums), output);
    }

    @Test
    public void example2() {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int output = 5;
        Assert.assertEquals(longestSubarray(nums), output);
    }

    @Test
    public void example3() {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0};
        int output = 5;
        Assert.assertEquals(longestSubarray(nums), output);
    }

    @Test
    public void example4() {
        int[] nums = {1,1,1,1,1,1,1,1,1};
        int output = 8;
        Assert.assertEquals(longestSubarray(nums), output);
    }

    @Test
    public void example5() {
        int[] nums = {0,0,0,0};
        int output = 0;
        Assert.assertEquals(longestSubarray(nums), output);
    }

      /* Pseudo code :

         1. Create 2 pointers left= 0, right=0
         2. Traverse while right<nums.length
         3. If right =0, increment zerocount and find max and increment right
         4. If zerocount >k and if left =0, then decrement zerocount and increment left. Find maxlen and right++
         5. Return maximum
       */
    public int longestSubarray(int[] nums) {

        int maximumlen = Integer.MIN_VALUE;
        int left= 0, right=0, zerocount =0, k=1;

        while(right<nums.length)
        {
            if (nums[right] == 0)
                zerocount++;

            while (zerocount > k) {
                if (nums[left] == 0)
                    zerocount--;
                left++;
            }

            maximumlen = Math.max(maximumlen, right - left);
            right++;
        }

        return maximumlen;
    }
}


    /* Pseudo code for Bruteforce:

   1. Consider 2 loops i and j
   2. Traverse i until i<nums.length. when the loop increments set the zero count to 0 to check upcoming window count
   3. Traverse while j<nums.length. if nums[j] = 0, then increment zerocount
   4. And if zerocount>k then break and increment len to find the length of the window and find the maximum length
   5. Iterate the loop until nums.length-i<maximum
   6. Return maximum

   */

/*   Bruteforce :

    private int longestSubarray(int[] nums) {


      int maximum =0, k=1;
      for(int i=0;i<nums.length;i++)
      {
          int zerocount=0;
          int len=0;
          for(int j=i;j<nums.length;j++)
          {
              if(nums[j]==0)
              {
                  zerocount++;
              }
              if(zerocount>k)
              {
                  break;
              }
              len++;
          }
          maximum=Math.max(len,maximum);
          if(nums.length-i<maximum)
          {
              break;
          }
      }
      return maximum;
  }
} */
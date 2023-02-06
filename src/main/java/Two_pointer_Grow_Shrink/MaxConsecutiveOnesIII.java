package Two_pointer_Grow_Shrink;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.LinkedList;

public class MaxConsecutiveOnesIII {

    /* Leetcode_1004 : https://leetcode.com/problems/max-consecutive-ones-iii

    Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip
    at most k 0's.

    Constraints:
        1 <= nums.length <= 10^5
        nums[i] is either 0 or 1.
        0 <= k <= nums.length
     */

    @Test
    public void example1() {

        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int output = 6;
        Assert.assertEquals(maxOnes(nums, k), output);
    }

    @Test
    public void example2() {

        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        int output = 10;
        Assert.assertEquals(maxOnes(nums, k), output);
    }

    @Test
    public void example3() {

        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0};
        int k = 0;
        int output = 3;
        Assert.assertEquals(maxOnes(nums, k), output);
    }

    @Test
    public void example4() {

        int[] nums = {1,1,1,1,1,1,1,1,1};
        int k = 3;
        int output = 9;
        Assert.assertEquals(maxOnes(nums, k), output);
    }

    @Test
    public void example5() {

        int[] nums = {1,1,1,1,1};
        int k = 2;
        int output = 5;
        Assert.assertEquals(maxOnes(nums, k), output);
    }

    public void example6() {

        int[] nums = {0,0,0,0};
        int k = 2;
        int output = 2;
        Assert.assertEquals(maxOnes(nums, k), output);
    }

    /* Pseudo code:

    1. Consider 2 loops i and j
    2. Traverse i until i<nums.length. when the loop increments set the zero count to 0 to check upcoming window count
    3. Traverse j j<nums.length. if nums[j] = 0, then increment zerocount
    4. And if zerocount>k then break and increment len to find the length of the window and find the maximum length
    5. Iterate the loop until nums.length-i<maximum
    6. Return maximum

     */

  private int maxOnes(int[] nums, int k) {

        int maximumlen = Integer.MIN_VALUE;
        int left= 0, right=0, zerocount =0;

        while(right<nums.length)
        {
            if (nums[right] == 0)
                zerocount++;

            while (zerocount > k) {
                if (nums[left] == 0)
                    zerocount--;
                left++;
            }

            maximumlen = Math.max(maximumlen, right - left + 1);
            right++;
        }

        return maximumlen;
    }
}

    /*   Bruteforce :

    private int maxOnes(int[] nums, int k) {


      int maximum =0;
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
package Class_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class S02_Count_Number_of_Nice_Subarrays {

    /* Leetcode_1248 : https://leetcode.com/problems/count-number-of-nice-subarrays/

        Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
        Return the number of nice sub-arrays.

        Constraints:

        1 <= nums.length <= 50000
        1 <= nums[i] <= 10^5
        1 <= k <= nums.length
    */

    @Test
    public void example1() {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        int output = 2;
        Assert.assertEquals(numberOfSubarrays(nums, k), output);
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 6};
        int k = 1;
        int output = 0;
        Assert.assertEquals(numberOfSubarrays(nums, k), output);
    }

    @Test
    public void example3() {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        int output = 16;
        Assert.assertEquals(numberOfSubarrays(nums, k), output);
    }

    /* Pseudo code :

        1. Create 2 pointers left =0, right=0 and variables oddcount =0, subarrayCount =0, totalcount =0
        2. Traverse while right< nums.length
        3. If nums is odd then oddcount++ and subarrayCount=0
        4. If oddcount==k then increment subarrayCount
        5. If left is odd then decrement oddcount and increment left
        6. Store the subarrayCount in totalcount
        7. Reset the subarrayCount to 0 until oddcount ==k
        8. Move right until right <nums.length
        9. Return totalcount

    */

    //Bruteforce :

  /*  public int numberOfSubarrays(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++)
        {
            int odd = 0;
            for (int j = i; j < nums.length; j++)
            {
                if (nums[j] % 2 != 0)
                    odd++;

                if (odd == k)
                    count++;
            }        }

        return count;
    }
} */

   // Approach 1 :

 /*   public int numberOfSubarrays(int[] nums, int k) {

        int left =0, right =0, oddcount =0, subarrayCount =0, totalcount =0;

        while (right < nums.length) {

            if(nums[right] %2 ==1) {
                oddcount++;
                subarrayCount=0;
            }

            while(oddcount ==k) {
                subarrayCount++;
                if(nums[left++] %2 ==1) oddcount--;
            }

            right++;
            totalcount += subarrayCount;
        }
        return totalcount;
    }
} */

  // Approach 2 :Prefix algorithm

    public int numberOfSubarrays(int[] nums, int k) {
        int sum =0, count=0;

        for(int i=0; i<nums.length; i++) {

            if(nums[i] %2 == 1)
                nums[i] = 1;
            else
                nums[i] =0;
        }

        HashMap<Integer, Integer> map = new HashMap<>() ;
        map.put(0,1);

        for(int j=0; j<nums.length; j++) {

            sum += nums[j];

            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum, 0) +1);
        }

        return count;
    }
}


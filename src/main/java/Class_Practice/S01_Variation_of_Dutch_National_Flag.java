package Class_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S01_Variation_of_Dutch_National_Flag {

    /* Leetcode : https://leetcode.com/discuss/interview-question/algorithms/124623/facebook-onsite-variation-of-dutch-national-flag-problem

    You have an unsorted array of integers and a function
    string getCategory(integer), which deterministically returns 1 of three possible strings: "low", "medium", or "high", depending on the input integer.
    You need to output an array with all the "low" numbers at the bottom, all the "medium" numbers in the middle, and all the "high" numbers at the top.
    This is basically a partial sort. Within each category, the order of the numbers does not matter.

    For example, you might be give the array [5,7,2,9,1,14,12,10,5,3].
    For input integers 1 - 3, getCategory(integer) returns "low", for 4 - 10 it returns "medium," and for 11 - 15 it returns "high".
    You could output an array (or modify the given array) that looks like this: [3,1,2,5,5,9,7,10,14,12]

     */

    @Test
    public void example1() {
        int[] nums = {5,7,2,9,1,14,12,10,5,3};
        //int[] output = {3,1,2,5,5,9,7,10,14,12};
        //Assert.assertEquals(Dutch_Flag(nums), output);
        System.out.print(Dutch_Flag(nums));  //2,1,3,9 7,5,5,10,12,14
    }

    @Test
    public void example2() {
        int[] nums = {555555555};
        //int[] output =
        System.out.print(Dutch_Flag(nums));
    }
    @Test
    public void example3() {
        int[] nums = {3,2,1};
        //int[] output =
        System.out.print(Dutch_Flag(nums));
    }

    /* Pseudo code :

       1. Create pointers low=0, high= nums.length()-1 , i=0;
       2. Traverse while(i<=high)
       3. if num is <=3 swap i and low
       4. if nums is >=11 swap i and high
       5. else i++;
       6. Return nums

    */

    public int[] Dutch_Flag(int[] nums){

        int low =0, high = nums.length-1;

        for(int i=0; i<nums.length; i++) {
            while(i<=high) {

                    if(nums[i] <= 3) {
                    int temp = nums[i];
                    nums[i] = nums[low];
                    nums[low] = temp;
                    low++;
                    i++;
                }

                else if(nums[i] >= 11) {

                    int temp = nums[i];
                    nums[i] = nums[high];
                    nums[high] = temp;
                    high--;
                }

                else  i++;
            }
        }  return nums;
    }
}

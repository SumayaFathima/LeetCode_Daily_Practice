package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S2161_Partition_Array_According_to_Given_Pivot {

    @Test
    public void example1() {

        int[] nums = {9,12,5,10,14,3,10};
        int pivot =10;
        int[] output = {9,5,3,10,10,12,14};
        Assert.assertEquals(pivotArray(nums, pivot), output);
    }

    public int[] pivotArray(int[] nums, int pivot) {


        int pos=0;
        for(int i=0; i<nums.length; i++) {

            if(nums[i] == pivot) {
                pos =i;
                break;
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > pivot) {
                int temp = nums[i];
                nums[i] = nums[pos+1];
                nums[pos+1] = temp;
            }
        }

        return nums;

    }
}

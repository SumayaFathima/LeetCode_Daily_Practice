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

    @Test
    public void example2() {

        int[] nums = {-3,4,3,2};
        int pivot = 2;
        int[] output = {-3,2,4,3};
        Assert.assertEquals(pivotArray(nums, pivot), output);
    }

    @Test
    public void example3() {

        int[] nums = {10,10,10};
        int pivot =10;
        int[] output = {10,10,10};
        Assert.assertEquals(pivotArray(nums, pivot), output);
    }

    /*
    Create a new array and 2 pointers  left =0 and right = nums.length-1
    Traverse a loop from 0 till length-1
    Check if elements < pivot then in new array and increment left
    Check from backward direction and add elements in new array if elements > pivot and decrement right
    A loop traversing while left <= right, add pivot in the array
    return new array
     */
    public int[] pivotArray(int[] nums, int pivot) {

        int [] arr = new int[nums.length];
        int left=0, right=nums.length-1;

        for(int i=0; i<nums.length; i++){
            if(nums[i]<pivot)
                arr[left++]=nums[i];

            if(nums[nums.length-i-1]>pivot){
                arr[right--]=nums[nums.length-i-1];
            }
        }
        while(left <= right){
            arr[left++]=pivot;
        }
        return arr;
    }
}
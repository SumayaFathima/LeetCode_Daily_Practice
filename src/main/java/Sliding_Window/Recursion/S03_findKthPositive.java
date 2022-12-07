package Sliding_Window.Recursion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S03_findKthPositive {

    // https://leetcode.com/problems/kth-missing-positive-number/description/
    @Test
    public void example1() {

        int[] arr = {2,3,4,7,11};
        int k = 5;
        int output =9;
        Assert.assertEquals(findKthPositive(arr,k), output);
    }


    public int findKthPositive(int[] arr, int k) {

        int index = 0;

        for(int i=1; i<arr[arr.length-1]; i++) {
            if(arr[index] != i) {
                k--;
                if(k==0) {
                    return i;
                }
            } else {
                index++;
            }
        }

        return arr[arr.length - 1] + k;
    }
}

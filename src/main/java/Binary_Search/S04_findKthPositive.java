package Binary_Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class S04_findKthPositive {

    // https://leetcode.com/problems/kth-missing-positive-number/description/
    @Test
    public void example1() {

        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        int output = 9;
        Assert.assertEquals(findKthPositive(arr, k), output);
    }

    @Test
    public void example2() {

        int[] arr = {1, 2, 3, 4};
        int k = 2;
        int output = 6;
        Assert.assertEquals(findKthPositive(arr, k), output);
    }

  /*  public int findKthPositive(int[] arr, int k) {

        int left = 1, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] - mid > k)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left + k;
    }
} */

    public int findKthPositive(int[] arr, int k) {
        int index= Arrays.binarySearch(arr, k);
        return -(index)+ (-1);
    }
}

    //Bruteforce :
  /*  public int findKthPositive(int[] arr, int k) {

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
} */

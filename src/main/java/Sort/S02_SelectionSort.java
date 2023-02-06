package Sort;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S02_SelectionSort {

    //Time Complexity -  O(n^2)

    @Test
    public void td1() {
        int[] arr = new int[]{6,8,3,1,5,4,7,2};
        int[] output = {1, 2, 3, 4, 5, 6, 7, 8};
        sort(arr);
        Assert.assertEquals(arr, output);
    }

    /*
    1. Traverse i from 0 to arr length-1
    2. Assign pivot to i index
    3. Compare pivot and j values. if j is lesser than pivot value then pivot = j
    4. once lowest value is dound, check if pivot and i index is not same
    5. if yes swap pivot and i
    6. return input array

     */

    public void sort(int[] arr) {

        int pivot=0, temp;

        for(int i=0; i<arr.length-1; i++) {
            pivot =i;
            for(int j=i+1; j< arr.length; j++) {
                if(arr[j] < arr[pivot])
                    pivot = j;
            }

            if(pivot != i) {
                temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = temp;
            }
        }
    }
}

package Sort;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S03_BubbleSort {

    //Time Complexity -  O(n^2)

    @Test
    public void td1() {
        int[] arr = new int[]{6,8,3,1,5,4,7,2};
        int[] output = {1, 2, 3, 4, 5, 6, 7, 8};
        sort(arr);
        Assert.assertEquals(arr, output);
    }

    /*
    1. Traverse i from 0 t arr.length-1
    2. Traverse j from 0 to arr.length-1-i
    3. if j value > j+1 value, swap j and j+1
    4. Return input array

     */
    public void sort(int[] arr) {

        int temp;
        for(int i=0; i< arr.length-1; i++) {
            for(int j=0; j<arr.length-1-i; j++) {

                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

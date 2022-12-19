package Sort;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S04_InsertionSort {

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
    2. compare adjacent values, if i is > i+1, swap i and i+1
    3. assign i to pivot and
    4. find the apt position in the left sub-array, by swapping pivot and pivot-1
    5. Do this while pivot > 0 && arr[pivot] < arr[ pivot-1]
    6. decrement pivot
    7. use helper method for swapping
    8. Return input array

     */
    void sort(int[] arr) {

        for( int i =0 ;i < arr.length-1;i++) {
            if(arr[i] > arr[i+1]) {
                swap(arr, i, i+1);
                int pivot = i;
                while(pivot > 0 && arr[pivot] < arr[ pivot-1]) {
                    //  if(arr[pivot] < arr[ pivot-1])
                    swap(arr, pivot, pivot-1);
                    pivot--;
                }
            }
        }
    }
    void swap(int[] arr, int x ,int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
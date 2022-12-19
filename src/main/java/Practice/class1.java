package Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class class1 {

    @Test
    public void example1() {

        int[] arr = {4,5,3,1,2};
        int[] output = {1,2,3,4,5};
        sort(arr);
        Assert.assertEquals(arr, output);
    }

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
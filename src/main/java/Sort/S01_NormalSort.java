package Sort;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class S01_NormalSort {

    @Test
    public void td1() {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        int[] output = {1, 2, 3, 4, 5, 6};
        sort(arr);
        Assert.assertEquals(arr, output);
    }

    public void sort(int[] arr) {

        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}

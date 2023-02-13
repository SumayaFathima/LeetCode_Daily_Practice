package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class S119_Pascal_Triangle_II {

    @Test
    public void example1() {
        int rowIndex = 3;
        int[] output = {1,3,3,1};
        Assert.assertEquals(getRow(rowIndex), output);
    }

    /*
    Pseudo code:

    Create an int array with rowindex+1 length
    Fill the array with 0
    First element of array should be 1
    Create a loop traversing from 1 til rowindex
    Another loop from having arr[j] + arr[j - 1] to the position
    Continue until condition fails
    Convert to list and return the list
     */
    public List<Integer> getRow(int rowIndex) {

        Integer[] arr = new Integer[rowIndex + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                arr[j] = arr[j] + arr[j - 1];
            }
        }

        List<Integer> list =  Arrays.asList(arr);

        return list;
    }
}
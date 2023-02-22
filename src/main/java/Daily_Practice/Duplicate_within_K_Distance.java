package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Duplicate_within_K_Distance {

    /*
    Given an unsorted array that may contain duplicates. Also given a number k which is smaller than the size of the array.
    Write a function that returns true if the array contains duplicates within k distance.
    */

    @Test
    public void example1() {
        int[] arr = {1, 2, 3, 4, 1, 2, 3, 4};
        int k=3;
        boolean output = false;
        Assert.assertEquals(Duplicates(arr, k), output);
    }

    @Test
    public void example2() {
        int[] arr = {1, 2, 3, 1, 4, 5};
        int k=3;
        boolean output = true;
        Assert.assertEquals(Duplicates(arr, k), output);
    }

    @Test
    public void example3() {
        int[] arr = {1,2};
        int k=1;
        boolean output = false;
        Assert.assertEquals(Duplicates(arr, k), output);
    }

    @Test
    public void example4() {
        int[] arr = {2,2};
        int k=1;
        boolean output = true;
        Assert.assertEquals(Duplicates(arr, k), output);
    }

    @Test
    public void example5() {
        int[] arr = {2, 2,4,4,4};
        int k=3;
        boolean output = true;
        Assert.assertEquals(Duplicates(arr, k), output);
    }

    /* Pseudo code :
    - Create a hashmap
    - Add first k values to map - if duplicate found return true
    - else take next k values and check the same by deleting the previous first element and add the current pointer element
    - return false by default

     */
    public boolean Duplicates(int[] arr, int k) {

        int pointer =0;
        HashMap<Integer, Integer> map = new HashMap();

        while(pointer <= k) {

            if(map.containsKey(arr[pointer]))  return true;
            else
                map.put(arr[pointer], 1);
            pointer++;
        }

        while(pointer < arr.length-k) {

            map.remove(arr[pointer-k-1]);
            if (map.containsKey(arr[pointer])) return true;
            else
                map.put(arr[pointer], 1);
            pointer++;
        }

        return false;
        }
}

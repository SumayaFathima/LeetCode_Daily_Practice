package HackerRank;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class Subset {


    //Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not.
    // Both the arrays are not in sorted order.
    // It may be assumed that elements in both arrays are distinct.

    @Test
    public void example1() {

        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};
        // String output = "arr2[] is a subset of arr1[]";
        subsetofsortedarray(arr1, arr2);
        //Assert.assertEquals(output);
    }

    public void subsetofsortedarray(int[] arr1, int[] arr2) {

        boolean subset = true;
        if (arr2.length > arr1.length) subset = false;

        HashSet<Integer> set = new HashSet();

        for (int i = 0; i < arr1.length; i++) {

            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {

            if (!set.contains(arr2[i])) {
                subset = false;
            }
        }

            if (subset)
                System.out.println("arr2[] is a subset of arr1[]");
            else
                System.out.println("arr2[] is not a subset of arr1[]");
    }
}

package Daily_Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Intersection_of_Three_Sorted_Arrays {

    @Test
    public void example1() {  //15
        int[] arr1 = {10, 12, 15, 16};
        int[] arr2 = {15, 16, 17};
        int[] arr3 = {1, 4, 5,6,7,8,9,10,11,12,13,14,15};
        System.out.println(arraysIntersection(arr1,arr2,arr3));
    }

    @Test
    public void example2() {  //{5}
        int[] arr1 = {5, 6, 6};
        int[] arr2 = {4, 5, 7};
        int[] arr3 = {1, 4, 5};
        System.out.println(arraysIntersection(arr1,arr2,arr3));
    }

    @Test
    public void example3() {  //{8,8}
        int[] arr1 = {8,8,8};
        int[] arr2 = {8,8,8};
        int[] arr3 = {8,8};
        System.out.println(arraysIntersection(arr1,arr2,arr3));
    }

    @Test
    public void example4() {  //{}
        int[] arr1 = {1,2,3};
        int[] arr2 = {4,5,6};
        int[] arr3 = {7,8,9};
        System.out.println(arraysIntersection(arr1,arr2,arr3));
    }

    @Test
    public void example5() {  //{}
        int[] arr1 = {1,2,3};
        int[] arr2 = {3,4,5,6};
        int[] arr3 = {5,6,7,8,9};
        System.out.println(arraysIntersection(arr1,arr2,arr3));
    }

    /*
    Pseudo code:
    - Create index values for all arrays
    - Traverse from 0 till min length of all arrays
    - if value of each element in first array == second array and second array == third array
    - if yes add to list and increment all index
    - if  array 1 value < array 2 value -> increment first array index alone
    - Also if array 2 <array 3 value -> increment second array index alone
    - else increment third array index
    - return list
     */
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

        List<Integer> list = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                list.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j])
                i++;

            else if (arr2[j] < arr3[k])
                j++;

            else
                k++;
        }

        return list;
    }
}

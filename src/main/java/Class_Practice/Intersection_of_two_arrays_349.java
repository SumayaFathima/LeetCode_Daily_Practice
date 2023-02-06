package Class_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Intersection_of_two_arrays_349 {

    @Test
    public void example1() {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] output = {2};
        Assert.assertEquals(test(nums1, nums2), output);
    }

    @Test
    public void example2() {

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] output = {9, 4};
        Assert.assertEquals(test(nums1, nums2), output);
    }

    /*
    1. put nums1 in map with occurence
    2. take nums2 and check in map. Add the value to set and decrement its frequency
    3. convert set to int array
    4. return array

     */
    public int[] test(int[] nums1, int[] nums2) {

        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();
        for (int i : nums1) {
            s1.add(i);
        }
        for (int i : nums2) {
            s2.add(i);
        }
        s1.retainAll(s2);
        int[] arr = new int[s1.size()];
        int j = 0;
        for (int i : s1) {
            arr[j] = i;
            j++;
        }
        return arr;
    }
}
package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;

public class S349_Intersection_of_Two_Arrays {

    @Test
    public void example1() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] output = {2};
        Assert.assertEquals(intersection(nums1, nums2), output);
    }
    @Test
    public void example2() {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] output = {4,9};
        Assert.assertEquals(intersection(nums1, nums2), output);
    }
    @Test
    public void example3() {
        int[] nums1 = {1};
        int[] nums2 = {1};
        int[] output = {1};
        Assert.assertEquals(intersection(nums1, nums2), output);
    }
    @Test
    public void example4() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        int[] output = {};
        Assert.assertEquals(intersection(nums1, nums2), output);
    }

    /*
        - Create a set and sort 2 arrays
        - Create 2 pointers p1 and p2
        - Traverse while p1 < nums1.length && p2<nums2.length
        - if nums1 and nums 2 has same value, add it to set and increment both
        - if nums1 < nums2, then increment nums1 else nums2
        - Create a new aray with set size and add each element to array
        - return array
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        int index = 0;
        HashSet<Integer> set = new HashSet<>();

        int p1 =0, p2 =0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(p1 < nums1.length && p2<nums2.length) {
            if(nums1[p1] == nums2[p2])  {
                set.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1] < nums2[p2])  p1++;
            else p2++;
        }

        int[] arr = new int[set.size()];
        for (Integer i: set) {
            arr[index++] = i;
        }
        return arr;
    }
}
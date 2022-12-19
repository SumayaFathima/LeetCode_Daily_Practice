package HackerRank;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Two_pairs_are_Symmetric {

    /*  Two pairs (a, b) and (c, d) are said to be symmetric if c is equal to b and a is equal to d.
             For example, (10, 20) and (20, 10) are symmetric.
             Given an array of pairs find all symmetric pairs in it.
             It may be assumed that the first elements of all pairs are distinct.
     */

    @Test
    public void example1() {

        int[][] arr = {{11, 20}, {30, 40}, {5, 10}, {40, 30},{10, 5}};
        int[][] output = {{30, 40}, {5, 10}};
        Assert.assertEquals(twopairsSymmetric(arr), output);
    }

    @Test
    public void example2() {

        int[][] arr = {{11, 20}, {30, 40}};
        int[][] output = {};
        Assert.assertEquals(twopairsSymmetric(arr), output);
    }

    @Test
    public void example3() {

        int[][] arr = {{11, 20}, {20, -11}};
        int[][] output = {};
        Assert.assertEquals(twopairsSymmetric(arr), output);
    }

    /*
        1. Create a new array
        2. Take each values from given array
        3. and check if map has i value in mapvalue and j value in mapkey
        4. if present add the map values in a new array and increment i
        5. else add the values in map
        6. Return new array
     */
    public int[][] twopairsSymmetric(int arr[][]) {

        HashMap<Integer, Integer> map = new HashMap();
        ArrayList<Integer> list = new ArrayList();

        int[][] res = new int[arr.length][arr.length];
        int i =0;
        for(int[] fr : arr) {
            if(map.containsValue(fr[0]) && map.containsKey(fr[1])) {
                res[i][0]=fr[1];
                res[i][1]=fr[0];
                i++;
            }
            else
                map.put(fr[0], fr[1]);
        }
        return res;
    }
}

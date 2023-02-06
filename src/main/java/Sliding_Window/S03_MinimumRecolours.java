package Sliding_Window;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class S03_MinimumRecolours {

    /* Leetcode_2379 : https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/

    You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B',
    representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.
    You are also given an integer k, which is the desired number of consecutive black blocks.
    In one operation, you can recolor a white block such that it becomes a black block.

    Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.

    Constraints:
        n == blocks.length
        1 <= n <= 100
        blocks[i] is either 'W' or 'B'.
        1 <= k <= n
    */

    @Test
    public void example1() {

        String blocks = "WBBWWBBWBW";
        int k = 7;
        int output = 3;
        Assert.assertEquals(minimumRecolors(blocks, k), output);
    }

    @Test
    public void example2() {

        String blocks = "WWW";
        int k = 4;
        int output = 0;
        Assert.assertEquals(minimumRecolors(blocks, k), output);
    }

    @Test
    public void example3() {

        String blocks = "W";
        int k = 1;
        int output = 1;
        Assert.assertEquals(minimumRecolors(blocks, k), output);
    }

    @Test
    public void example4() {

        String blocks = "B";
        int k = 1;
        int output = 0;
        Assert.assertEquals(minimumRecolors(blocks, k), output);
    }

    /*  Pseudo Code :

       1. Create pointer =0, and count=0;
       2. Traverse till the length of k in the first window and calculate the count only the string has W
       3. Store the count in minimum
       4. Traverse to the next window by deleting end value of the previous window(if it is W, decrement the count)
       5. and add the first value of the next window (if it has W, increment the count)
       6. Compare count and minimum value and store the minimum value in minimum
       7. Iterate the loop while pointer < input.length
       8. Return the minimum value
    */

    public int minimumRecolors(String blocks, int k) {

        int minimum = Integer.MAX_VALUE;
        int pointer=0, count=0;

        if(blocks.length() < k)  return 0;
        if(blocks.length()==1 && blocks.charAt(pointer) == 'W') return 1;
        if(blocks.length()==1 && blocks.charAt(pointer) != 'W') return 0;

        while(pointer<k) {
            if(blocks.charAt(pointer++) == 'W')
                count++;
        }
        minimum = count;

        while(pointer<blocks.length()) {

            if(blocks.charAt(pointer) == 'W')
                count ++;
            if(blocks.charAt(pointer-k) == 'W')
                count--;

            minimum = Math.min(minimum, count);
            pointer++;
        }
        return minimum;
    }
}

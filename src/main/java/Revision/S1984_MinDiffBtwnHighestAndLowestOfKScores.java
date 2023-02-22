package Revision;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Arrays;


public class S1984_MinDiffBtwnHighestAndLowestOfKScores {


    @Test
    public void example1() {

        int[] input = {9, 4, 1, 7};
        int k = 2;
        int output = 2;
        Assert.assertEquals(minimumDifferenceHandL(input, k), output);
    }

    @Test
    public void example2() {

        int[] input = {9, 4, 1, 7, 6};
        int k = 3;
        int output = 1;
        Assert.assertEquals(minimumDifferenceHandL(input, k), output);
    }

    @Test
    public void example3() {

        int[] input = {90};
        int k = 1;
        int output = 0;
        Assert.assertEquals(minimumDifferenceHandL(input, k), output);
    }


    /*  Pseudo Code :

       1. Create pointer =0, and diff=0 and sort the array in descending order
       2. Traverse till the length of k in the first window and calculate the diff
       3. Store the diff in minimum
       4. Traverse while pointer <input.length, subtract the pointer with pointer+1 and store in diff
       5. Compare diff and minimum value and store the minimum value in minimum
       6. Iterate the loop while pointer < input.length
       7. Return the minimum value
    */

    public int minimumDifferenceHandL(int[] input, int k) {

        int minimum = Integer.MAX_VALUE;
        int pointer=input.length-1, diff =0;

        if(k<=1) return 0;

        Arrays.sort(input);

        while(pointer>0) {
            diff = input[pointer] - input[pointer-1];
            pointer--;
            break;
        }
        minimum = diff;
        while(pointer>0 ) {
            diff = input[pointer] - input[pointer-1];
            minimum = Math.min(minimum, diff);
            pointer--;
        };

        return minimum;
    }
}
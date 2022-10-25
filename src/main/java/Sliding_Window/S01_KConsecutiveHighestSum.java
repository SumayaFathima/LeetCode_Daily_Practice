package Sliding_Window;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class S01_KConsecutiveHighestSum  {

    /* Given an array of integers and a number k.
	   Return the highest sum of any k consecutive elements in the array

	   Target = k
     */

    @Test
    public void example1() {

        int[] input = {1,5,2,3,7,1};
        int k =3;
        int output = 12;
        Assert.assertEquals(maximumSum(input, k), output);
    }

    @Test
    public void example2() {
        int[] input = {1,2,3};
        int k = 4;
        int output = 0;
        Assert.assertEquals(maximumSum(input,k), output);
    }

    @Test
    public void example3() {
        int[] input = {0,0,0};
        int k = 3;
        int output = 0;
        Assert.assertEquals(maximumSum(input,k), output);
    }

    /* Pseudo Code :

	   1. Create pointer =0, and sum=0;
	   2. Traverse till the length of k in the first window and calculate the sum
	   3. Store the sum in maximum
	   4. Traverse to the next window by deleting end value of the previous window and add the first value of the next window in the sum
	   5. Compare sum and maximum value and store the maximum value in maximum
	   6. Iterate the loop while pointer < input.length
	  7. Return the maximum value
    */
    public int maximumSum(int[] input, int  k) {

        if(input.length < k) return 0;

        int maximum = Integer.MIN_VALUE;
        int pointer =0, sum=0;

        while(pointer< k) {
            sum += input[pointer++];
        }
        maximum = sum;

        while(pointer< input.length) {
            sum += input[pointer] - input[pointer - k];
            maximum = Math.max(maximum, sum);
            pointer++;
        }
        return maximum;
    }
}
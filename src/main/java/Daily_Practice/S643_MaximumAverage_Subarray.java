package Daily_Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class S643_MaximumAverage_Subarray {

    @Test
    public void example1() {

        int[] input = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double output = 12.75000;
        Assert.assertEquals(maximumAverage(input, k), output);
    }

    @Test
    public void example2() {
        int[] input = {1,1,1,1};
        int k = 4;
        double output = 1.0;
        Assert.assertEquals(maximumAverage(input, k), output);
    }

    @Test
    public void example3() {
        int[] input = {5};
        int k = 1;
        double output = 5.00000;
        Assert.assertEquals(maximumAverage(input, k), output);
    }

    /*  Pseudo Code :

       1. Create pointer =0, and sum=0;
       2. Traverse till the length of k in the first window and calculate the sum
       3. Store the sum in maximum
       4. Traverse to the next window by deleting end value of the previous window and add the first value of the next window in the sum
       5. Compare sum and maximum value and store the maximum value in maximum
       6. Return the maximum value/k in double
    */
    public double maximumAverage(int[] input, int k) {

        int maximum = Integer.MIN_VALUE;
        int pointer =0 , avg =0;

        while(pointer<k) {
            avg += input[pointer++];
        }
        maximum = avg;

        while(pointer<input.length) {
            avg += input[pointer] - input[pointer-k];
            maximum = Math.max(maximum, avg);
            pointer++;
        }
        return (double)maximum/k;
   }
}
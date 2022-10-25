package Two_pointer_Grow_Shrink;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class S01_MinimumSizeSubarraySum {

    @Test
    public void example1() {

        int[] input = {2,3,1,2,4,3};
        int k = 7;
        int output = 2;
        Assert.assertEquals(minimumSizeSum(input, k), output);
    }
    @Test
    public void example2() {

        int[] input = {1,4,4};
        int k = 4;
        int output = 1;
        Assert.assertEquals(minimumSizeSum(input, k), output);
    }
    @Test
    public void example3() {

        int[] input = {1,1,1,1,1,1};
        int k = 11;
        int output = 0;
        Assert.assertEquals(minimumSizeSum(input, k), output);
    }

    /* Pseudo code :

    1. Create two pointers grow and shrink at same place
    2. Traverse while left<input.length, if sum < k then right++ and add the value to the sum
    3. if sum >=k then left --, and subtract its value from the sum and calculate the index distance (right-left)
    4. if the sum <k again, then repeat step 2
    5. Iterate until condition breaks
    6. Return the distance
     */
    private int minimumSizeSum(int[] input, int k) {

        int distance = Integer.MAX_VALUE;
        int left =0, right =0, sum=0;

        while(left<input.length) {

            if(sum<k && right<input.length )
                sum += input[right++];

            else if (sum >=k) {
                sum -= input[left];
                distance = Math.min(distance, right -left);
                left++;
            }
            else if (distance == Integer.MAX_VALUE) return 0;
            else break;
        }
        return distance;
    }
}

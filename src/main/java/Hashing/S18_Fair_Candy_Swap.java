package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class S18_Fair_Candy_Swap {

    @Test
    public void example1() {

        int[] aliceSizes = {1, 1};
        int[] bobSizes = {2, 2};
        int[] output = {1, 2};
        Assert.assertEquals(fairCandySwap(aliceSizes, bobSizes), output);
    }

    @Test
    public void example2() {

        int[] aliceSizes = {1, 2};
        int[] bobSizes = {2, 3};
        int[] output = {1, 2};
        Assert.assertEquals(fairCandySwap(aliceSizes, bobSizes), output);
    }

    @Test
    public void example3() {

        int[] aliceSizes = {2};
        int[] bobSizes = {1, 3};
        int[] output = {2,3};
        Assert.assertEquals(fairCandySwap(aliceSizes, bobSizes), output);
    }

    @Test
    public void example4() {

        int[] aliceSizes = {20,30,10};
        int[] bobSizes = {20,10,10};
        int[] output = {20,10};
        Assert.assertEquals(fairCandySwap(aliceSizes, bobSizes), output);
    }

    @Test
    public void example5() {

        int[] aliceSizes = {49,999};
        int[] bobSizes = {950};
        int[] output = {999,950};
        Assert.assertEquals(fairCandySwap(aliceSizes, bobSizes), output);
    }

    @Test
    public void example6() {

        int[] aliceSizes = {50};
        int[] bobSizes = {5,5,5,5,5,5,5,5,5,5,5,5,5,5,120};
        int[] output = {50,120};
        Assert.assertEquals(fairCandySwap(aliceSizes, bobSizes), output);
    }

    @Test
    public void example7() {

        int[] aliceSizes = {1,2,5};
        int[] bobSizes = {2,4};
        int[] output = {1,2};
        Assert.assertEquals(fairCandySwap(aliceSizes, bobSizes), output);
    }

    /* Pseudo code :

        1. Find the initial sum for alice and bob
        2. Find n by adding the sums and divide by 2
        3. Get the sum by swapping values of alice and bob
        4. Check if the sum is equal to n
        5. if yes return the index value of alice and bob which is swapped
        6. Else continue until it finds the right match
     */

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int InitialaliceSum = 0, InitialbobSum = 0, tempaliceSum = 0;

        for (int i = 0; i < aliceSizes.length; i++) {
            InitialaliceSum += aliceSizes[i];
        }

        for (int i = 0; i < bobSizes.length; i++) {
            InitialbobSum += bobSizes[i];
        }

        int n = (InitialaliceSum + InitialbobSum) / 2;


        for (int i = 0; i < aliceSizes.length; i++) {

            for (int j = 0; j < bobSizes.length; j++) {

                tempaliceSum = InitialaliceSum - aliceSizes[i] + bobSizes[j];

                if (tempaliceSum == n) {
                    return new int[]{aliceSizes[i],bobSizes[j]};
                }
            }
        }
        return null;
    }
}

package Assignments;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashSet;
import java.util.Set;

public class S888_Fair_Candy_Swap {

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

        int[] aliceSizes = {50};
        int[] bobSizes = {5,5,5,5,5,5,5,5,5,5,5,5,5,5,120};
        int[] output = {50,120};
        Assert.assertEquals(fairCandySwap(aliceSizes, bobSizes), output);
    }
    @Test
    public void example5() {

        int[] aliceSizes = {1,2,5};
        int[] bobSizes = {2,4};
        int[] output = {1,2};
        Assert.assertEquals(fairCandySwap(aliceSizes, bobSizes), output);
    }

    /* Pseudo code :

        - Find the initial sum for alice and bob and bob values in set
        - Find the diff of both sum and divide by 2 to transfer
        - Traverse each value of alice and check if alice - diff is in set
        - if yes then return alice, alice -diff
        - return null by default
    */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        Set<Integer>set=new HashSet<>();

        int alicesum =0, bobsum=0;

        for(int alice : aliceSizes) {
            alicesum += alice;
        }

        for(int bob : bobSizes){
            set.add(bob);
            bobsum += bob;
        }

        int diff = (alicesum  - bobsum)/2;

        for(int al : aliceSizes) {

            if(set.contains(al - diff))
                return new int[]{al , al - diff};
        }

        return null;
    }
}

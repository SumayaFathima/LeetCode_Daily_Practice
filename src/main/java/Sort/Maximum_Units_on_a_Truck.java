package Sort;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Maximum_Units_on_a_Truck {

    //Leetcode_1710 : https://leetcode.com/problems/maximum-units-on-a-truck/

    @Test
    public void example1() {

        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        int output = 8;
        Assert.assertEquals(maximumUnits(boxTypes, truckSize), output);
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (int[] a, int[] b) -> (b[1] - a[1]));
        int pointer = 0, sum = 0, res = 0;

        for (int[] fr : boxTypes) {
            //sum += boxTypes[0];

            if (sum < truckSize) {
                res += fr[0] * fr[1];
            } else if (sum > truckSize) {
                int value = sum - truckSize;
                res += value * fr[1];
            } else
                res = fr[0] * fr[1];

        }
        return res;
    }
}

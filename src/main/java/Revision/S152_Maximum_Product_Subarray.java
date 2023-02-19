package Revision;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class S152_Maximum_Product_Subarray {

    @Test
    public void example1() {

        int[] nums = {2, 3, -2, 4};
        int output = 6;
        Assert.assertEquals(maximumProduct(nums), output);
    }

    @Test
    public void example2() {

        int[] nums = {-2,0,-1};
        int output = 0;
        Assert.assertEquals(maximumProduct(nums), output);
    }

    @Test
    public void example3() {

        int[] nums = {-10};
        int output = -10;
        Assert.assertEquals(maximumProduct(nums), output);
    }

    @Test
    public void example4() {

        int[] nums = {-1,-1,-1};
        int output = 1;
        Assert.assertEquals(maximumProduct(nums), output);
    }

/* Pseudo code :

1. Assign first element in array to  maxprod and prod variable to 1
2. Forward traversal from 0 to nums.length
3. Multiply each element to prod
4. if prod is > maxprod then maxprod will be prod
5. Reset prod to 1 if prod goes 0
6. Assign back prod to 1 and continue the same steps from reverse traversal
7. Return the maxprod
 */


    private int maximumProduct(int[] nums) {

        int prod = 1;
        int maxProd = nums[0];
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            if (prod > maxProd) maxProd = prod;
            if (prod == 0) prod = 1;
        }
        prod = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            prod *= nums[j];
            if (prod > maxProd) maxProd = prod;
            if (prod == 0) prod = 1;
        }
        return maxProd;
    }
}
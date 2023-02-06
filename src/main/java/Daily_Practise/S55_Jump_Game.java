package Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class S55_Jump_Game {

    @Test
    public void example1() {

        int[] nums = {2,3,1,1,4};
        boolean output = true;
        Assert.assertEquals(canJump(nums), output);
    }

    @Test
    public void example2() {

        int[] nums = {3,2,1,0,4};
        boolean output = false;
        Assert.assertEquals(canJump(nums), output);
    }

    @Test
    public void example3() {

        int[] nums = {2,5,0,0};
        boolean output = true;
        Assert.assertEquals(canJump(nums), output);
    }

    @Test
    public void example4() {

        int[] nums = {5};
        boolean output = true;
        Assert.assertEquals(canJump(nums), output);
    }

    @Test
    public void example5() {

        int[] nums = {0};
        boolean output = true;
        Assert.assertEquals(canJump(nums), output);
    }

/*
Pseudo code :
1. Consider pivot =0
2. Traverse from 0 till pivot
3. Compare max between pivot and index + value of index and assign to pivot
4. If pivot equals/crosses last element in the array then return true
5. Return  false
 */
    public boolean canJump(int[] nums) {

            int pivot =0;
            for(int i =0;i<=pivot;i++) {
                pivot = Math.max(pivot, i + nums[i]);
                if (pivot >= nums.length - 1) return true;
            }
        return false;
    }
}
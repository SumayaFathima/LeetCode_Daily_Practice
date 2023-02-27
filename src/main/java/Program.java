import org.testng.Assert;
import org.testng.annotations.Test;

public class Program {

    @Test
    public void example1() {
        int[] nums = {1,0,0,0,1};
        int k = 2;
        boolean output = false;
        Assert.assertEquals(Prog(nums, k), output);
    }

    @Test
    public void example2() {
        int[] nums = {1,0,0,0,1};
        int k = 1;
        boolean output = true;
        Assert.assertEquals(Prog(nums, k), output);
    }

    @Test
    public void example3() {
        int[] nums = {1,0,0,0,1};
        int k = 3;
        boolean output = false;
        Assert.assertEquals(Prog(nums, k), output);
    }

    @Test
    public void example4() {
        int[] nums = {0,0,0,0};
        int k = 2;
        boolean output = false;
        Assert.assertEquals(Prog(nums, k), output);
    }

    public boolean Prog(int[] nums, int k) {

        if(nums.length <= 2) return false;

        int pointer =0, count =0;

        while(pointer < k) {

            for(int i =1; i<nums.length-1; i++) {

                if(nums[i] ==0 && nums[i-1]== 0 && nums[i+1] ==0) {
                    nums[i] = 1;
                    count++;
                }
            }
            pointer++;
        }

        if(count == k) return true;

        return false;
    }
}

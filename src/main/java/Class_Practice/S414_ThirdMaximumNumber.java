package Class_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class S414_ThirdMaximumNumber {


    @Test
    public void example1() {
        int[] nums = {3,2,1};
        int output = 1;
        Assert.assertEquals(thirdMax(nums), output);
    }

    public int thirdMax(int[] nums) {
    Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
    }

        if (set.size() >= 3) {
            set.remove(Collections.max(set));
            set.remove(Collections.max(set));
    }
        return Collections.max(set);
}
}

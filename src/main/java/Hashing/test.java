
package Hashing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test {


    @Test
    public void example1() {

        String[] s = {"abcabcbb"};
        int output = 3;
        Assert.assertEquals(testing(s), output);
    }

    public int testing(String[] s) {

        if(s.length ==0) return 0;
        if(s.length ==1) return 1;

        int maximum = Integer.MIN_VALUE;

        int left =0, right = 1;

        while(left <s.length) {

            if(s[left] != s[right]) {

                int length = right -left+1;
                maximum = Math.max(maximum, length);
            }

            left++;
            right++;
        }

        return maximum;

    }

}
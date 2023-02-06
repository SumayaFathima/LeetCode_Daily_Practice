package Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S09_IsPalindrome {

    @Test
    public void example1() {
        String s = "abc";
        boolean output = false;
        Assert.assertEquals(isPalindrome(s), output);
    }

    @Test
    public void example2() {
        String s = "radar";
        boolean output = true;
        Assert.assertEquals(isPalindrome(s), output);
    }

    @Test
    public void example3() {
        String s = "s";
        boolean output = true;
        Assert.assertEquals(isPalindrome(s), output);
    }

    /* Pseudo code :

    1. Create 2 pointers
    2. Traverse while left<right>
    3. Check for the condition if left and right doesn't have same values, return false
    4. Return true by default
 */
    private boolean isPalindrome(String s) {

        int left = 0, right = s.length()-1 ;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}

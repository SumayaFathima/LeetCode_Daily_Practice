package Expand_From_Center;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S01_IsPalindrome {

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

    @Test
    public void example4() {
        String s = "baba";
        boolean output = false;
        Assert.assertEquals(isPalindrome(s), output);
    }

    /* Pseudo code :

        1. Create 2 pointers
        2. Traverse while left>=0
        3. Check for the condition if left and right doesn't have same values, return false
        4. Return true by default
     */

    private boolean isPalindrome(String s) {

        int left = s.length()/2 - s.length()%2, right = s.length()/2 + s.length() %2;
        if(left == right) left--;

        while(left>=0) {
            if(s.charAt(left) != s.charAt(right)) return false;
            else
                left--;
                right++;
        }
        return true;
    }
}

   /*  Bruteforce :

        private boolean isPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length()-1; j > 0; j--) {

                if (s.charAt(i) != s.charAt(j)) return false;
                i++;
            }
        }
        return true;
    }
} */


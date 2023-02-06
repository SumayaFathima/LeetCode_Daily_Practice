package Expand_From_Center;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidPalindromeII {

    /* Leetcode_680 : https://leetcode.com/problems/valid-palindrome-ii

        Given a string s, return true if the s can be palindrome after deleting at most one character from it.

        Constraints:

            1 <= s.length <= 10^5
            s consists of lowercase English letters.

     */

    @Test
    public void example1() {
        String s = "aba";
        boolean output = true;
        Assert.assertEquals(validPalindrome(s), output);
    }

    @Test
    public void example2() {
        String s = "abca";
        boolean output = true;
        Assert.assertEquals(validPalindrome(s), output);
    }

    @Test
    public void example3() {
        String s = "abc";
        boolean output = false;
        Assert.assertEquals(validPalindrome(s), output);
    }

    @Test
    public void example4() {
        String s = "mnoppnm";
        boolean output = true;
        Assert.assertEquals(validPalindrome(s), output);
    }

    @Test
    public void example5() {
        String s = "mnoopnm";
        boolean output = true;
        Assert.assertEquals(validPalindrome(s), output);
    }



    /* Pseudo code:
    1. Create a method for palindrome
    2. In another method, create 2 pointers int left = 0, right = s.length() - 1;
    3. if left and right value is same, increment left and decrement right
    4. else we need to ignore either left or right to check if one of them gives out a palindrome
    5. Return true by default

     */

   private boolean validPalindrome(String s) {

        int left = s.length()/2 - s.length()%2, right = s.length()/2 + s.length() %2;
        if(left == right) left--;

        while(left>=0) {

            if(s.charAt(left)==s.charAt(right)) {
                left--;
                right++;
            }
            else
                return isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1) || isPalindrome(s, left-1, right) || isPalindrome(s, left, right+1);
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left>=0) {
            if(s.charAt(left--) != s.charAt(right++)){
                return false;
            }
        }
        return true;
    }
}
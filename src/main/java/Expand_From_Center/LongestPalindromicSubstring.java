package Expand_From_Center;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class LongestPalindromicSubstring {

    /* Leetcode_5 : https://leetcode.com/problems/longest-palindromic-substring/

        Given a string s, return the longest palindromic substring in s.
        A string is called a palindrome string if the reverse of that string is the same as the original string.

        Constraints:
            1 <= s.length <= 1000
            s consist of only digits and English letters.
     */

    @Test
    public void example1() {

        String s = "babad";
        String output = "bab";
        Assert.assertEquals(longestPalindrome(s), output);
    }

    @Test
    public void example2() {

        String s = "cbbd";
        String output = "bb";
        Assert.assertEquals(longestPalindrome(s), output);
    }

    @Test
    public void example3() {
        String s = "abc";
        String output = "a";
        Assert.assertEquals(longestPalindrome(s), output);
    }

    @Test
    public void example4() {
        String s = "mmmmmmmmm";
        String output = "mmmmmmmmm";
        Assert.assertEquals(longestPalindrome(s), output);
    }

    @Test
    public void example5() {
        String s = "148889234255557";
        String output = "5555";
        Assert.assertEquals(longestPalindrome(s), output);
    }

    @Test
    public void example6() {
        String s = "aeiou";
        String output = "a";
        Assert.assertEquals(longestPalindrome(s), output);
    }

    @Test
    public void example7() {
        String s = "a";
        String output = "a";
        Assert.assertEquals(longestPalindrome(s), output);
    }


    /* Pseudo code:

    1. Create a palindrome method where it checks if a method is a palindrome or not
    2. Consider 2 loops i and j
    3. Check for j-i > maxlen, then take the substring and check in palindrome method
    4. if it returns true then check the length of the substring with the maxlen value
    5. If length of the substring > maxlen then maxlen = l and its respective index substring should be saved in str
    8. Return str - the maximum length palindrome substring

    */

 //  Bruteforce:

        private String longestPalindrome(String s) {

        if (s.length() == 1) return s;
        int maxlen = 0;
        String str = "";

        int len = s.length();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {

                if (j - i > maxlen) {

                    String substr = s.substring(i, j);
                    if (isPalindrome(substr)) {

                        int sublen = substr.length();

                        if (sublen >= maxlen) {
                            maxlen = sublen;
                            str = substr;
                        }
                    }
                }
            }
        }
        return str;
    }

    public boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            else
                start++;
            end--;
        }
        return true;
    }
}

 /*  public int start, end;

    public String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {

            palindrome(s, i, i);
            palindrome(s, i, i + 1);
        }

        return s.substring(start, start + end);
    }

     public void palindrome(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (end < right - left - 1) {
            start = left + 1;
            end = right - left - 1;
        }
    }
} */



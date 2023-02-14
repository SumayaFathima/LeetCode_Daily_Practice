package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class S409_Longest_Palindrome {

    @Test
    public void example1() {
        String s ="abccccdd";
        int output = 7;
        Assert.assertEquals(longestPalindrome(s), output);
    }

    @Test
    public void example2() {
        String s ="m";
        int output = 1;
        Assert.assertEquals(longestPalindrome(s), output);
    }

    @Test
    public void example3() {
        String s ="AaBb";
        int output = 1;
        Assert.assertEquals(longestPalindrome(s), output);
    }

    @Test
    public void example4() {
        String s ="aabbccd";
        int output = 7;
        Assert.assertEquals(longestPalindrome(s), output);
    }

    /*
    - Create a hashset
    - Traverse through element of s
    - if set contains, increment length by 2 and remove from set
    - else add in set
    - if set size >0 then return length+1
    - else return length by default

     */
    public int longestPalindrome(String s) {

    Set<Character> set = new HashSet<>();
    int length = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                length += 2;
                set.remove(c);
            }
            else set.add(c);
         }

        if(set.size() > 0)
            return length+1;

        return  length;
    }
}


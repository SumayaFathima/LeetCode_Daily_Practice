package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S1332_Remove_Palindromic_Subsequences {

    @Test
    public void example1() {
        String s = "ababa";
        int output =1;
        Assert.assertEquals(removePalindromeSub(s), output);
    }
    @Test
    public void example2() {
        String s = "abb";
        int output =2;
        Assert.assertEquals(removePalindromeSub(s), output);
    }
    @Test
    public void example3() {
        String s = "baabb";
        int output = 2;
        Assert.assertEquals(removePalindromeSub(s), output);
    }
    @Test
    public void example4() {
        String s = "b";
        int output =1;
        Assert.assertEquals(removePalindromeSub(s), output);
    }

    /*
        - Create 2 pointers left and right
        - Traverse while left < right
        - if it is not a palindrome then return 2
        - else increment left and decrement right and return 1
     */
    public int removePalindromeSub(String s) {

        int left =0, right =s.length()-1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return 2;
            else {
                left++;
                right--;
            }
        }

        return 1;
    }
}

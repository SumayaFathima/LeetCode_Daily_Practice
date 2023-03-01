package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S2108_Find_First_Palindromic_String_in_the_Array {

    @Test
    public void example1() {
        String[] words = {"abc","car","ada","racecar","cool"};
        String output = "ada";
        Assert.assertEquals(firstPalindrome(words), output);
    }

    @Test
    public void example2() {
        String[] words = {"abc","car","tag"};
        String output = "";
        Assert.assertEquals(firstPalindrome(words), output);
    }

    @Test
    public void example3() {
        String[] words = {"dad"};
        String output = "dad";
        Assert.assertEquals(firstPalindrome(words), output);
    }

    @Test
    public void example4() {
        String[] words = {"car","bat","tag","ring","malayalam"};
        String output = "malayalam";
        Assert.assertEquals(firstPalindrome(words), output);
    }

    @Test
    public void example5() {
        String[] words = {"s","b","c"};
        String output = "s";
        Assert.assertEquals(firstPalindrome(words), output);
    }

    /*
    - Create a palindrome method to check if the given string is palindrome or not
    - Traverse each word in string array and check if the palindrome method gives true
    - if yes return that string
    - else traverse all elements and no palindrome found return empty string
     */
    public String firstPalindrome(String[] words) {

        String res = "";

        for(String word : words) {

            if(palindrome(word)) return word;

        }

        return res;
    }

    public boolean palindrome (String word) {

        int left =0, right = word.length()-1;

        while(left <=right) {
            if(word.charAt(left) != word.charAt(right))  return false;

            else {
                left++;
                right --;
            }
        }
        return true;
    }
}


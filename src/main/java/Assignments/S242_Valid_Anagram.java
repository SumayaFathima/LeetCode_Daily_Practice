package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S242_Valid_Anagram {

    @Test
    public void example1() {
        String s = "anagram";
        String t = "nagaram";
        boolean output = true;
        Assert.assertEquals(isAnagram(s, t), output);
    }
    @Test
    public void example2() {
        String s = "rat";
        String t = "car";
        boolean output = false;
        Assert.assertEquals(isAnagram(s, t), output);
    }
    @Test
    public void example3() {
        String s = "a";
        String t = "b";
        boolean output = false;
        Assert.assertEquals(isAnagram(s, t), output);
    }
    @Test
    public void example4() {
        String s = "dd";
        String t = "ddd";
        boolean output = false;
        Assert.assertEquals(isAnagram(s, t), output);
    }

    /*  Pseudo code :
        - Create an ascii array
        - Add all elements of string s and increment
        - Traverse each element of t and chekc if the value is <= 0, if yes return false
        - else decrement the count
        - return true by default
     */

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())  return false;

        int[] arr = new int[26];

        for(Character sr : s.toCharArray()) {
            arr[sr - 'a']++;
        }

        for(Character tr : t.toCharArray()) {
            if(arr[tr - 'a'] <=0) return false;
            else
                arr[tr - 'a']--;
        }
        return true;
    }
}
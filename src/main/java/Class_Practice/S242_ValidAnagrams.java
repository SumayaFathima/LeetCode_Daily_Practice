package Class_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S242_ValidAnagrams {

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

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())  return false;

        int[] arr = new int[26];

        for(Character st : s.toCharArray()) {
            arr[st - 'a']++;
        }

        for(Character st : t.toCharArray()) {

            if(arr[st - 'a'] <= 0) return false;
            else
                arr[st - 'a']--;
        }

        return true;
    }
}

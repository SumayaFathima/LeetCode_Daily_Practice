package Hashing;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class WordPattern {

    /* Leetcode:290 - https://leetcode.com/problems/word-pattern/

    Given a pattern and a string s, find if s follows the same pattern.

    Here follow means a full match, such that there is a bijection between a letter in
    pattern and a non-empty word in s.

    */

    @Test
    public void example1() {
        String pattern = "abba";
        String s = "dog cat cat fish";
        boolean output = true;
        Assert.assertEquals(wordPattern(pattern,s), output);

    }

    public boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> map = new HashMap();
        String[] ch = s.split(" ");
        if(pattern.length() != ch.length) return false;

        for(int i=0; i<pattern.length(); i++) {

            if(map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(ch[i])) {
                return false;
            }

            else if(!map.containsKey(pattern.charAt(i)) && map.containsValue(ch[i])) {
                return false;
            }

            else
                map.put(pattern.charAt(i), ch[i]);
        }
        return true;
    }
}
package Hashing;

import jdk.internal.org.objectweb.asm.Handle;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S04_Isomorphic_Strings {

    /* Leetcode_205 : https://leetcode.com/problems/isomorphic-strings/

         Given two strings s and t, determine if they are isomorphic.
         Two strings s and t are isomorphic if the characters in s can be replaced to get t.
         All occurrences of a character must be replaced with another character while preserving the order of characters.
         No two characters may map to the same character, but a character may map to itself.

         Constraints:

            1 <= s.length <= 5 * 10^4
            t.length == s.length
            s and t consist of any valid ascii character.
    */

    @Test
    public void example1() {

        String s = "egg";
        String t = "add";
        boolean output = true;
        Assert.assertEquals(isomorphicStrings(s, t), output);
    }

    @Test
    public void example2() {
    String s = "fooo";
    String t = "assd";
    boolean output = false;
    Assert.assertEquals(isomorphicStrings(s, t), output);
}

    @Test
    public void example3() {
        String s = "paper";
        String t = "title";
        boolean output = true;
        Assert.assertEquals(isomorphicStrings(s, t), output);

    }
    @Test
    public void example4() {
        String s = "leet@!";
        String t = "122345";
        boolean output = true;
        Assert.assertEquals(isomorphicStrings(s, t), output);
    }

    @Test
    public void example5() {
        String s = "&#abac12&";
        String t = "favovurite";
        boolean output = false;
        Assert.assertEquals(isomorphicStrings(s, t), output);
    }


    /* Pseudo code:

        1. Check if s is in map, if yes then check it is same mapping or not
        2. If s is not in map, check t is already mapped or not
        3. If both is not in map, put in map

     */
    public boolean isomorphicStrings(String s, String t) {

        HashMap<Character,Character> map = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;

            } else if (map.containsValue(t.charAt(i)))
                return false;

            else map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}
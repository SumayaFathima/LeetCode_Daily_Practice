package Class_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class S01_First_Unique_Character_in_a_String {

    /* Leetcode_387 : https://leetcode.com/problems/first-unique-character-in-a-string/

    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

    Constraints:
        1 <= s.length <= 105
        s consists of only lowercase English letters.

    */


    @Test
    public void example1() {
        String s = "leetclode";
        int output = 3;
        Assert.assertEquals(firstUniqueCharacter(s), output);
    }

    @Test
    public void example2() {
        String s = "loveleetcode";
        int output = 2;
        Assert.assertEquals(firstUniqueCharacter(s), output);
    }

    @Test
    public void example3() {
        String s = "aabb";
        int output = -1;
        Assert.assertEquals(firstUniqueCharacter(s), output);
    }


    /* Pseudo code :

        1. Declare a hashmap
        2. Add all the numbers in map with the frequency count
        3. A loop of the given string that checks the frequency count in map
        4. If it is equal to 1, then return the string
     */

    public int firstUniqueCharacter(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {

                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else

                map.put(s.charAt(i), 1);
        }

        for (int i = 0; i < s.length(); i++) {

            if (map.get(s.charAt(i)) == 1) {

                return i;

            }

        }return -1;
    }
}
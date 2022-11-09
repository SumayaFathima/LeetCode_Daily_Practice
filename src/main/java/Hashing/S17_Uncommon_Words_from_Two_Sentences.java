package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S17_Uncommon_Words_from_Two_Sentences {

    /* Leetcode_884 : https://leetcode.com/problems/uncommon-words-from-two-sentences/

        A sentence is a string of single-space separated words where each word consists only of lowercase letters.
        A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
        Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

        Constraints:

            1 <= s1.length, s2.length <= 200
            s1 and s2 consist of lowercase English letters and spaces.
            s1 and s2 do not have leading or trailing spaces.
            All the words in s1 and s2 are separated by a single space.
   */

    @Test
    public void example1() {

        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        String[] output = {"sweet","sour"};
        Assert.assertEquals(uncommonFromSentences(s1,s2), output);
    }

    @Test
    public void example2() {

        String s1 = "apple apple";
        String s2 = "banana";
        String[] output = {"banana"};
        Assert.assertEquals(uncommonFromSentences(s1,s2), output);
    }

    @Test
    public void example3() {

        String s1 = "banana";
        String s2 = "apple apple mango";
        String[] output = {"banana","mango"};
        Assert.assertEquals(uncommonFromSentences(s1,s2), output);
    }

    @Test
    public void example4() {

        String s1 = "a";
        String s2 = "b c";
        String[] output = {"a","b", "c"};
        Assert.assertEquals(uncommonFromSentences(s1,s2), output);
    }

    @Test
    public void example5() {

        String s1 = "a";
        String s2 = "a";
        String[] output = {};
        Assert.assertEquals(uncommonFromSentences(s1,s2), output);
    }

    /* Pseudo code :

    `   1. Declare a hashmap of String and Integer
        2. Split the String with space and store in String array
        3. Put each word of string in map with occurrence for both s1 and s2
        4. With keyset, take the key which has occurrence of 1 and store in list
        5. Create a string array with size of list
        6. Convert to array and store the values in result
        7. Return the result
     */
    public String[] uncommonFromSentences(String s1, String s2) {

        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<String>();

        String[] split1 = s1.split(" ");
        String[] split2 = s2.split(" ");

        for(String str1 : split1) {
            map.put(str1, map.getOrDefault(str1,0)+1);
        }

        for(String str2 : split2) {
            map.put(str2, map.getOrDefault(str2,0)+1);
        }

        for(String key : map.keySet()){
            if(map.get(key) == 1)
               list.add(key);
        }

        String[] result = new String[list.size()];
        list.toArray(result);

        return result;
    }
}

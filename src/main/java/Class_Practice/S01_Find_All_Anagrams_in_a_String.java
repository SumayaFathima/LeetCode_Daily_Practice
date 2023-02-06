package Class_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class S01_Find_All_Anagrams_in_a_String {

    /* Leetcode_438 : https://leetcode.com/problems/find-all-anagrams-in-a-string/

        Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer
        in any order.
        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
        the original letters exactly once.

        Constraints:

            1 <= s.length, p.length <= 3 * 10^4
            s and p consist of lowercase English letters.
    */

    @Test
    public void example1() {
        String s = "cbaebabacd";  //0,6
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    @Test
    public void example2() {
        String s = "cbaebabacd";  //0,1,2
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    /* Pseudo code:

        1. Create an Array List to return list of integer
        2. Traverse while i<s.length()- p.length() +1
        3. Take a substring from i till i+p.length()
        4. Compare the substring with given p with the helper method
        5. if true add in list and continue until the condition fails
        6. Return the list
    */
    private boolean isAnagram (String str, String p) {

        int[] sarray = new int[26];
        int[] parray = new int[26];

        for(char sh :str.toCharArray())
            sarray[sh-'a']++;

        for(char ph :p.toCharArray())
            parray[ph-'a']++;

        if(Arrays.equals(sarray,parray)) {
            return true;
        }

        else    return false;
    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<s.length()- p.length() +1; i++) {

            String str = s.substring(i, i+p.length());

            if(isAnagram(str,p)) {
                list.add(i);
            }
        }
        return list;
    }
}

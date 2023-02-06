package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

    /* Leetcode_383 : https://leetcode.com/problems/ransom-note/

        Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from
        magazine and false otherwise.

        Each letter in magazine can only be used once in ransomNote.

    */

public class ransom_String {

    @Test
    public void example1() {

        String  ransomNote = "a";
        String magazine = "b";
        boolean output = false;
        Assert.assertEquals(canConstruct(ransomNote,magazine),output);
    }


    public boolean canConstruct(String ransomNote, String magazine) {

    /*    HashMap<Character,Integer> map = new HashMap();

        for(char s : magazine.toCharArray()) {

            if(map.containsKey(s))
                map.put(s, map.get(s) +1);
            else
                map.put(s,1);
        }

        for(char ch : ransomNote.toCharArray()) {

            if(map.containsKey(ch) && map.get(ch) >0) {
                map.put(ch, map.get(ch) -1);
            }
            else {
                return false;
            }

        }
        return true;

    }
} */
        int[] alph = new int[26];

        for(int i=0; i<magazine.length(); i++) {

            alph[magazine.charAt(i) - 'a']++;

        }

        for(int i=0; i<ransomNote.length(); i++) {

            alph[magazine.charAt(i) - 'a']--;

        }

        for(int i : alph) {

            if(i<0) return false;
        }
        return true;

    }
}

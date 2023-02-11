package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class S383_RansomNote {

    @Test
    public void example1() {
        String ransomNote = "a";
        String magazine = "b";
        boolean output = false;
        Assert.assertEquals(canConstruct(ransomNote, magazine), output);
    }

    @Test
    public void example2() {
        String ransomNote = "aa";
        String magazine = "ab";
        boolean output = false;
        Assert.assertEquals(canConstruct(ransomNote, magazine), output);
    }

    @Test
    public void example3() {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean output = true;
        Assert.assertEquals(canConstruct(ransomNote, magazine), output);
    }

    /*
    1. Add magazine to map with occurance
    2. Traverse each element  from 0 till ransomNote length
    3. check if it is in map. if not return false
    4. else reduce the frequency
     */
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map = new HashMap();

        for(Character fr : magazine.toCharArray()) {

            if(map.containsKey(fr)) {
                map.put(fr, map.getOrDefault(fr, 0) + 1);
            }
            else
                map.put(fr, 1);
        }

        for(Character fr : ransomNote.toCharArray()) {

            if(map.containsKey(fr) && map.get(fr) >= 1) {
                map.put(fr, map.getOrDefault(fr, 0) - 1);
            }
            else
                return false;
        }

        return true;

    }
}
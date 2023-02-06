package Class_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class    S01_Longest_Substring_Without_Repeating_Characters {

    @Test
    public void example1() {
        String s = "abcabcbb";
        int output = 3;
        Assert.assertEquals(lengthOfLongestSubstring(s), output);
    }

    @Test
    public void example2() {
        String s = "bbbbb";
        int output = 1;
        Assert.assertEquals(lengthOfLongestSubstring(s), output);
    }
    @Test
    public void example3() {
        String s = "pwwkew";
        int output = 3;
        Assert.assertEquals(lengthOfLongestSubstring(s), output);
    }
    @Test
    public void example4() {
        String s = " ";
        int output = 1;
        Assert.assertEquals(lengthOfLongestSubstring(s), output);
    }

    @Test
    public void example5() {
        String s = "%@!####^";
        int output = 4;
        Assert.assertEquals(lengthOfLongestSubstring(s), output);
    }

    @Test
    public void example6() {
        String s = "123454";
        int output = 5;
        Assert.assertEquals(lengthOfLongestSubstring(s), output);
    }

    @Test
    public void example7() {
        String s = "5555555";
        int output = 1;
        Assert.assertEquals(lengthOfLongestSubstring(s), output);
    }

    @Test
    public void example8() {
        String s = "aeiou";
        int output = 5;
        Assert.assertEquals(lengthOfLongestSubstring(s), output);
    }

    /* Pseudo code:

        1. Declare a map to store character and integer
        2. Add the elements in map by right++ until it is unique and compare the map size with maximum
        3. If the element is already present in map
        4. Compare map size with the maximum value and clear the map then right = left++;
        5. Iterate until the condition satisfies
        6. Return maximum
     */
    public int lengthOfLongestSubstring(String s) {

        if(s.length() ==0) return 0;
        if(s.length() == 1) return 1;

        int maximum = 0;

        Map<Character, Integer> map = new HashMap<>();

        int left =0, right = left;

            while(left<s.length() && right<s.length()) {

                if (map.containsKey(s.charAt(right))) {
                      maximum = Math.max(maximum, map.size());
                      map.clear();
                      right = left++;
                }
                else {
                    map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                    maximum = Math.max(maximum, map.size());
                    right++;
                }
            }  return maximum;
        }
    }

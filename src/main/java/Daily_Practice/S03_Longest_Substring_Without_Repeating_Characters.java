package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class S03_Longest_Substring_Without_Repeating_Characters {
    @Test
    public void example1() {
        String s = "abcbbcbb";
        int output = 3;
        Assert.assertEquals(lengthOfLongestSubstring(s), output);
    }

    @Test
    public void example2() {
        String s = "5555555";
        int output = 1;
        Assert.assertEquals(lengthOfLongestSubstring(s), output);
    }

    @Test
    public void example3() {
        String s = "aeiou";
        int output = 5;
        Assert.assertEquals(lengthOfLongestSubstring(s), output);
    }

    /*
    1. Create two pointers left =0, right =0
    2. Move right pointer and add in set until it is unique and find length
    3. Once duplicate is found, move left and remove from set
    4. return length

     */

    public int lengthOfLongestSubstring(String s) {

            int left =0, right =0, max=0;
            HashSet<Character> set = new HashSet<>();

            while(right < s.length()) {

                if(set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
                else {
                    set.add(s.charAt(right));
                    max = Math.max(max, set.size());
                    right++;
                }
            }
            return max;
        }
    }
package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.*;

public class S15_BuddyStrings {

    /* Leetcode_859 : https://leetcode.com/problems/buddy-strings/

        Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise,
        return false.
        Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters
        at s[i] and s[j].

        For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

        Constraints:

            1 <= s.length, goal.length <= 2 * 104
            s and goal consist of lowercase letters.
     */

    @Test
    public void example1() {

        String s = "ab";
        String goal = "ba";
        boolean output = true;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    @Test
    public void example2() {

        String s = "ab";
        String goal = "ab";
        boolean output = false;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    @Test
    public void example3() {

        String s = "aa";
        String goal = "aa";
        boolean output = true;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    @Test
    public void example4() {

        String s = "ab";
        String goal = "abbba";
        boolean output = false;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    @Test
    public void example5() {

        String s = "saas";
        String goal = "saas";
        boolean output = true;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    @Test
    public void example6() {

        String s = "abcd";
        String goal = "abcd";
        boolean output = false;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    @Test
    public void example7() {

        String s = "abcdef";
        String goal = "fedcba";
        boolean output = false;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }


    @Test
    public void example8() {

        String s = "ssssssrt";
        String goal = "sssssstr";
        boolean output = true;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    @Test
    public void example9() {

        String s = "tsrrrrrr";
        String goal = "strrrrrr";
        boolean output = true;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    /* Pseudocode :

        1. Declare a map and create two pointers left =0, right =0
        2. If s and goal are equal
		       * Add s in set if not present
		       * if already present then return true (As those letters can be swapped and can make s and goal equal)
        3. If s and goal are not equal :
		       * Create array list and convert both strings into character array
	           * Traverse while left < s.length()
		       * Check each letters of s with goal
		       * if it is same then just left++ and right++
		       * if it is different then add the index of s in a list
		       * when list size becomes 2, swap the s indexes and check if it matches goal
		       * if yes return true else false
        4. Return false by default
     */
    public boolean buddyStrings(String s, String goal) {

        if(s.length() != goal.length()) return false;
        int left =0, right =0;

        Set set = new HashSet();

        if(s.equals(goal)) {

            for (int i = 0; i < s.length(); i++) {
                if(set.contains(s.charAt(i)))
                    return true;
                else
                    set.add(s.charAt(i));
            }
        }

        ArrayList<Integer> list = new ArrayList();

        while(left < s.length()) {

            char[] sch = s.toCharArray();
            char[] gch = goal.toCharArray();

            if (s.charAt(left) != goal.charAt(right)) {
                list.add(left);

                if (list.size() == 2) {

                    char temp = sch[list.get(0)];
                    sch[list.get(0)] = sch[list.get(1)];
                    sch[list.get(1)] = temp;

                    if (Arrays.equals(sch, gch)) {
                        return true;
                    } else return false;
                }
            }
            left++;
            right++;

        }    return false;
    }
}

package Homeworks;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.*;

public class BuddyStrings {

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
    public void example6() {

        String s = "saas";
        String goal = "saas";
        boolean output = true;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    @Test
    public void example7() {

        String s = "abcd";
        String goal = "abcd";
        boolean output = false;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    @Test
    public void example8() {

        String s = "abcdef";
        String goal = "fedcba";
        boolean output = false;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }


    @Test
    public void example9() {

        String s = "ssssssrt";
        String goal = "sssssstr";
        boolean output = true;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    @Test
    public void example10() {

        String s = "tsrrrrrr";
        String goal = "strrrrrr";
        boolean output = true;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    /* Pseudocode :

        1. Declare a map and create two pointers left =0, right =0
        2. If s and goal are equal
		       * Add s in map with occurrence
		       * with entryset check if any Keyvalue is > 1
		       * if yes then return true (As those letters can be swapped and make s and goal equal)
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

        Map<Object, Integer> map = new HashMap<>();

        if(s.equals(goal)) {

            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }

            for (Map.Entry<Object, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1)
                    return true;
            }
        }

        while(left < s.length()) {

            ArrayList<Integer> list = new ArrayList();
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

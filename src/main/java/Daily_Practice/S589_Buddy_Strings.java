package Daily_Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class S589_Buddy_Strings {

    @Test
    public void example1() {
        String s = "ab";
        String goal = "abbba";
        boolean output = false;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    @Test
    public void example2() {
        String s = "saas";
        String goal = "saas";
        boolean output = true;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    @Test
    public void example3() {
        String s = "abcd";
        String goal = "abcd";
        boolean output = false;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    @Test
    public void example4() {
        String s = "ssssssrt";
        String goal = "sssssstr";
        boolean output = true;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    @Test
    public void example5() {
        String s = "tsrrrrrr";
        String goal = "strrrrrr";
        boolean output = true;
        Assert.assertEquals(buddyStrings(s, goal), output);
    }

    /* Pseudocode :

      - Declare a map and create two pointers left =0, right =0
      - If s and goal are equal then add s in set if not present
	  - If already present in set then return true
      - If s and goal are not equal then create array list and convert both strings into character array
	  - Traverse while left < s.length() and check each letters of s with goal
	  - if it is same then left++ and right++ else add the index of s in a list
	  - when list size becomes 2, swap the s indexes
	  - check if array both matches, if yes return true else false
      - return false by default
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
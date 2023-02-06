package HackerRank;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class CountingRepeatingSequence {

    /* In a given string, count the no of times  any character is repeated in sequence. Some rules to take care of.

            - Even if a repeating sequence contains two or more occurrences, it should be treated as a single repeat
            - if a character occurs in separate repeating sequences, then they should be counted separately


     */

    @Test
    public void example1() {

        String s = "abbbc";
        int output = 3;
        Assert.assertEquals(countingseq(s), output);
    }

    @Test
    public void example2() {

        String s = "a";
        int output = 1;
        Assert.assertEquals(countingseq(s), output);
    }

    @Test
    public void example3() {

        String s = "abbbaacc";
        int output = 4;
        Assert.assertEquals(countingseq(s), output);
    }

    @Test
    public void example4() {

        String s = "mmmmm";
        int output = 1;
        Assert.assertEquals(countingseq(s), output);
    }

    /*
    1. Traverse from 0 to string length
    2. Declare stack
    3. if the stack is empty, put in stack and increment count
    4. if the stack is non empty, peek and check if the values are same
    5. if yes - do nothing, if no - push in stack and increment stack

     */

    public int countingseq(String s) {

        int count= 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {

            if(!stack.isEmpty()) {
                if (stack.peek() != s.charAt(i)) {
                    stack.push(s.charAt(i));
                    count++;
                }
            }
            else {
                stack.push(s.charAt(i));
                count++;
            }
        }
            return count;
    }

}

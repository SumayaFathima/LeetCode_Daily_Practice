package Revision;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class S20_Valid_Paranthesis {

    @Test
    public void example1() {
        String s = "()";
        boolean output = true;
        Assert.assertEquals(isValid(s), output);
    }

    @Test
    public void example2() {
        String s = "()[]{}";
        boolean output = true;
        Assert.assertEquals(isValid(s), output);
    }

    @Test
    public void example3() {
        String s = "(]";
        boolean output = false;
        Assert.assertEquals(isValid(s), output);
    }

     /* Pseudo code :

        1. Create a stack
        2. if the character of string is '(' or '{' or '[', then add in stack
        3. else if the character is ')' then check if the stack is empty - if yes return false
        4. else check the last element of stack is the open braces of ')' - if yes then remove that character else return false
        5. if the pair matches - remove the element from the list. so that other pairs can be checked
        6. Once all iterations are done, then check the size of the stack
        7. if 0, then return true else false
     */

    public boolean isValid(String s) {

        if(s.length() == 1) return false;

        Stack<Character> stack = new Stack();

        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {

                if(stack.size() == 0) return false;
                else {
                    if ((stack.peek() == '(' && s.charAt(i) == ')') || (stack.peek() == '{' && s.charAt(i) == '}') ||
                            (stack.peek() == '[' && s.charAt(i) == ']'))
                        stack.pop();
                    else return false;
                }
            }
            else  stack.push(s.charAt(i));
        }

        if(stack.size() ==0) return true;
        else return false;
    }
}


package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Stack;

public class S05_Valid_Parentheses {

    // Leetcode_20 : https://leetcode.com/problems/valid-parentheses/
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

    @Test
    public void example4() {
        String s = "{[}}";
        boolean output = false;
        Assert.assertEquals(isValid(s), output);
    }

    @Test
    public void example5() {
        String s = "{()}()";
        boolean output = true;
        Assert.assertEquals(isValid(s), output);
    }

    /* Pseudo code :

        1. Craete a linked list
        2. A loop traversing till i<s.length
        3. if the character of string is '(' or '{' or '[', then add in list
        4. else if the character is ')' then check if the list is empty - if yes return false
        5. else check the last element of list is the open braces of ')' - if yes then remove that character else return false
        6. if the pair matches - remove the element from the list. so that other pairs can be checked
        7. Once all iterations are done, then check the size of the list
        8. if 0, then return true else false
     */

  /*   public boolean isValid(String s) {

         if(s.length()%2 == 1) return false;

        LinkedList list = new LinkedList();

        for(int i=0; i<s.length(); i++) {

            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {

                if (list.isEmpty()) return false;
                else {
                    if ((list.getLast().equals('(') && s.charAt(i) == ')') ||
                            (list.getLast().equals('{') && s.charAt(i) == '}') ||
                            (list.getLast().equals('[') && s.charAt(i) == ']'))
                        list.removeLast();
                    else
                        return false;
                }
            }

            else list.add(s.charAt(i));
        }

        if(list.size() ==0) return true;
        else return false;
    }
} */

    public boolean isValid(String s) {

        if(s.length()%2 == 1) return false;

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

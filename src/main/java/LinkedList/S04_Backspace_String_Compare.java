package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Stack;

public class S04_Backspace_String_Compare {

    @Test
    public void example1() {
        String s = "ab#c";
        String t = "ad#c";
        boolean output = true;
        Assert.assertEquals(backspaceCompare(s, t), output);
    }

    @Test
    public void example2() {
        String s = "ab##";
        String t = "c#d#";
        boolean output = true;
        Assert.assertEquals(backspaceCompare(s, t), output);
    }

    @Test
    public void example3() {
        String s = "a#c";
        String t = "b";
        boolean output = false;
        Assert.assertEquals(backspaceCompare(s, t), output);
    }

    @Test
    public void example4() {
        String s = "#";
        String t = "a";
        boolean output = false;
        Assert.assertEquals(backspaceCompare(s, t), output);
    }

    @Test
    public void example5() {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        boolean output = true;
        Assert.assertEquals(backspaceCompare(s, t), output);
    }

    @Test
    public void example6() {
        String s = "xywrrmp";
        String t = "xywrrmu#p";
        boolean output = true;
        Assert.assertEquals(backspaceCompare(s, t), output);
    }

    /* Pseudo code :

       1. Create a helper method to remove the character after # and return in the linkedlist
       2. To do so, create a linked list
       3. Convert the input to character Array and check if the character = #
       4. if yes and list is not empty, then remove last character from the list
       5. if not equal then add in list
       6. Return list to the actual method
       7. The backspaceCompare method compares both lists and returns boolean value
     */

    /* public boolean backspaceCompare(String s, String t) {
        return(backSpace(s).equals(backSpace(t)));
    }

    private LinkedList<Character> backSpace(String input) {

        LinkedList<Character> list = new LinkedList<>();

        for(Character ch : input.toCharArray()) {
            if(ch == '#') {
                if(!list.isEmpty())
                list.removeLast();
            }
            else
                list.add(ch);
        }
        return list;
    }
} */

    public boolean backspaceCompare(String s, String t) {

        return (backSpace(s).equals(backSpace(t)));
    }
    private Stack<Character> backSpace(String input) {

        Stack<Character> stack = new Stack<>();

        for (Character ch : input.toCharArray()) {

            if (ch == '#') {
                if(!stack.isEmpty())
                    stack.pop();
            }
            else  stack.push(ch);
        }
        return stack;
    }
}
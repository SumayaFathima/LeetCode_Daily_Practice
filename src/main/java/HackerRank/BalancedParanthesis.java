package HackerRank;

import java.util.Stack;

public class BalancedParanthesis {

    // https://www.hackerrank.com/challenges/balanced-brackets/problem

    public static String isBalanced(String s) {

        Stack<Character> stack = new Stack();
        String yes = "YES";
        String no =  "NO";

        for(int i=0; i<s.length(); i++) {

            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {

                stack.push(s.charAt(i));
            }

            else if(!stack.isEmpty() && (s.charAt(i) == '}' && stack.peek() == '{' ||
                    s.charAt(i) == ')' && stack.peek() == '(' ||
                    s.charAt(i) == ']' && stack.peek() == '[')) {
                stack.pop();
            }
            else return no;
        }

        if(stack.isEmpty())
            return yes;
        else return no;
    }

}
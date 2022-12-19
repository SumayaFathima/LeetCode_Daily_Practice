package HackerRank;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class No_Pairs_Allowed {

    @Test
    public void example1() {

        String[] words = {"add", "boook", "break"};
        int[] output = {1,1,0};
        Assert.assertEquals(nopairs(words), output);
    }

    @Test
    public void example2() {

        String[] words = {"boooooook", "sssss"};
        int[] output = {3,2};
        Assert.assertEquals(nopairs(words), output);
    }

    @Test
    public void example3() {

        String[] words = {"nothing"};
        int[] output = {0};
        Assert.assertEquals(nopairs(words), output);
    }

    /*
        1. Take each string from the string array
        2. Make count =0
        3. Traverse form 0 to word length
        4. if stack peek is equal to character then pop and increment count
        5. else add in stack
        6. once the word traversal is done, add count in list and clear stack
        7. Do for all strings and return list

     */

    public List<Integer> nopairs(String[] words) {

        int count=0;
        Stack<Character>  stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(String word : words) {
            count =0;
            for(int i=0; i<word.length(); i++) {

                if(!stack.isEmpty() && stack.peek() == word.charAt(i)) {
                    stack.pop();
                    count++;
                }
                else
                    stack.push(word.charAt(i));
            }
            stack.clear();
            list.add(count);
        }
        return list;
    }
}

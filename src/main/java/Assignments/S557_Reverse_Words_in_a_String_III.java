package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S557_Reverse_Words_in_a_String_III {

    @Test
    public void example1() {
        String s = "Let's take LeetCode contest";
        String output = "s'teL ekat edoCteeL tsetnoc";
        Assert.assertEquals(reverseWords(s), output);
    }

    @Test
    public void example2() {
        String s = "God Ding";
        String output = "doG gniD";
        Assert.assertEquals(reverseWords(s), output);
    }

    @Test
    public void example3() {
        String s = "A";
        String output = "A";
        Assert.assertEquals(reverseWords(s), output);
    }

    @Test
    public void example4() {
        String s = "ab";
        String output = "ba";
        Assert.assertEquals(reverseWords(s), output);
    }

    /*
    - Split the string wrt to white spaces
    - Take each string and convert to char array
    - create 2 pointers at both end and reverse the string and add it to a result string with white space
    - trim the result string and return the same
     */

    public String reverseWords(String s) {

        String res = "";
        String[] words = s.split(" ");

        for(String word : words) {

            char[] ch = word.toCharArray();
            int left =0, right = ch.length-1;

            while(left < right) {
                char temp = ch[left];
                ch[left++] = ch[right];
                ch[right--] = temp;
            }

            res+= new String(ch) +  " ";
        }


        return res.trim();

    }
}

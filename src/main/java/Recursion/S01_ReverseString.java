package Recursion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S01_ReverseString {

    //Leetcode_344 : https://leetcode.com/problems/reverse-string/
    @Test
    public void example1() {

        char[] s = {'h','e','l','l','o'};
        char[] output = {'o','l','l','e','h'};
        reverseString(s);
        Assert.assertEquals(s,output);
    }

    public void reverseString(char[] s) {

        int left =0;
        recursion(s, left);

    }
    void recursion(char[] s, int left) {

        if(left >= s.length/2){
            return;
        }

         char temp = s[left];
         s[left] = s[s.length-1-left];
         s[s.length-1-left] = temp;
         
        recursion(s, left+1);
}


}

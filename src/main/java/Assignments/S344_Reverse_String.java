package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S344_Reverse_String {

    @Test
    public void example1() {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
    }
    @Test
    public void example2() {
        char[] s = {'h', 'e'};
        reverseString(s);
    }

    @Test
    public void example3() {
        char[] s = {'H'};
        reverseString(s);
    }

    @Test
    public void example4() {
        char[] s = {'A', 'b', 'C'};
        reverseString(s);
    }

    /*
      - Create 2 pointers left and right
      - Traverse while left < right and swap left and right
      - increment left and decrement right
     */
    public void reverseString(char[] s) {

        int left =0, right = s.length-1;

        while(left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
        System.out.println(s);
    }
}


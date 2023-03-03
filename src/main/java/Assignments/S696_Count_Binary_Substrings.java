package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S696_Count_Binary_Substrings {

    @Test
    public void example1() {
        String s = "00110011";
        int output =6;
        Assert.assertEquals(countBinarySubstrings(s), output);
    }
    @Test
    public void example2() {
        String s = "10101";
        int output = 4;
        Assert.assertEquals(countBinarySubstrings(s), output);
    }

    @Test
    public void example3() {
        String s = "0000";
        int output = 0;
        Assert.assertEquals(countBinarySubstrings(s), output);
    }

    @Test
    public void example4() {
        String s = "1";
        int output =0;
        Assert.assertEquals(countBinarySubstrings(s), output);
    }

    @Test
    public void example5() {
        String s = "111000";
        int output = 2;
        Assert.assertEquals(countBinarySubstrings(s), output);
    }

    /*
        -

     */
    public int countBinarySubstrings(String s) {

        int pointer = 1, count =0, zerocount =0, onecount =0;
        char[] ch = s.toCharArray();

        if(ch[0] == '0') zerocount++;
        else onecount++;

        while(pointer < ch.length) {

            if(ch[pointer] == '0')
                zerocount++;
            if(ch[pointer] == '1')
                onecount++;

            if((zerocount == onecount) || ch[pointer-1] != ch[pointer]) count++;

            pointer++;

        }
        return count;
    }
}
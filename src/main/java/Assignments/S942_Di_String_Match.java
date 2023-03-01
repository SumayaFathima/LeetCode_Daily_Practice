package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S942_Di_String_Match {

    @Test
    public void example1() {
        String s = "IDID";
        int[] output = {0,4,1,3,2};
        Assert.assertEquals(diStringMatch(s), output);
    }
    @Test
    public void example2(){
        String s = "III";
        int[] output = {0,1,2,3};
        Assert.assertEquals(diStringMatch(s), output);
    }
    @Test
    public void example3() {
        String s = "DDI";
        int[] output = {3,2,0,1};
        Assert.assertEquals(diStringMatch(s), output);
    }
    @Test
    public void example4() {
        String s = "I";
        int[] output = {0,1};
        Assert.assertEquals(diStringMatch(s), output);
    }
    @Test
    public void example5() {
        String s = "D";
        int[] output = {1,0};
        Assert.assertEquals(diStringMatch(s), output);
    }
    /*
        - Create an array with string length+1 length
        - Create 2 pointers ival as 0 and dval as string length
        - Traverse from 0 till string length
        - if character is I then add ival in new array and increment ival
        - if character is D then add dval in new array and decrement dval
        - side wise increment new array
        - if last element is reached then add ival to the new array
        - return new array

     */
    public int[] diStringMatch(String s) {

        int index =0;
        int[] arr = new int[s.length()+1];

        int ival =0, dval = s.length();

        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == 'I') {
                arr[index++] = ival;
                ival++;
            }

            else if(s.charAt(i) == 'D') {
                arr[index++] = dval;
                dval--;
            }

            if(i == s.length()-1)
                arr[index++] = ival;
        }
        return arr;
    }
}
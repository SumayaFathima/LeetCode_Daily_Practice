package Assessment;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Reverse_string_using_Recursion {

    @Test
    public void example1() {

        String s = "hello";
        String output = "olleh";
        reverseString(s);
        //Assert.assertEquals(s,output);
    }

    public void reverseString(String s) {

        System.out.println(recursion(s));

    }
  /*  public void recursion(char[] s, int left) {

        if(left >= s.length/2){
            return;
        }

        char temp = s[left];
        s[left] = s[s.length-1-left];
        s[s.length-1-left] = temp;

        recursion(s, left+1);
    }
} */

    public String recursion(String str) {

        if(str.length() ==0 ) return "";

        return str.charAt(str.length()-1) +  recursion(str.substring(0, str.length()-1));


    }
}


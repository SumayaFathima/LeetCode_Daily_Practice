package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class S1763_Longest_Nice_Substring {
    @Test
    public void example1() {
        String s ="YazaAay";
        String output = "aAa";
        Assert.assertEquals(longestNiceSubstring(s), output);
    }

    @Test
    public void example2() {
        String s ="Ss";
        String output = "Ss";
        Assert.assertEquals(longestNiceSubstring(s), output);
    }

    @Test
    public void example3() {
        String s ="R";
        String output = " ";
        Assert.assertEquals(longestNiceSubstring(s), output);
    }

    /*
    - Create a hashset
    - Add all elements in set
    - Traverse each element until element has both lower and uppercase in set
    - if yes then skip
    - else do recursive cal with the substring of 0 to i index. store that in sub1
    - Do another recursive cal with begin index as i+1
    - if the sub1 string  length >= sub 2 length return sub1 else return sub2
    - return s by default
    */
    public String longestNiceSubstring(String s) {
        if(s.length() ==1)  return "";

        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<s.length();i++){
            hs.add(s.charAt(i));
        }

        for(int i=0;i<s.length();i++){
            if(hs.contains(Character.toLowerCase(s.charAt(i))) && hs.contains(Character.toUpperCase(s.charAt(i))))
                continue;

            String sub1=longestNiceSubstring(s.substring(0,i));
            String sub2=longestNiceSubstring(s.substring(i+1));

            if(sub1.length()>=sub2.length())
                return sub1;
            else return sub2;
        }
        return s;
    }
}
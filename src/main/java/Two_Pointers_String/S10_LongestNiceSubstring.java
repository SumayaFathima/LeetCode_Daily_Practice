package Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class S10_LongestNiceSubstring {

    @Test   //check for empty string
    public void example1() {
        String s = "YazaAay";
        String output = "aAa";
        Assert.assertEquals(longestNice(s), output);
    }

       public String longestNice(String s) {
           int size = s.length();
           if (size < 2) {
               return "";
           }
           HashSet<Character> record = new HashSet<>();
           for (char c: s.toCharArray()) {
               record.add(c);
           }
           for (int i = 0; i < size; i++) {
               char c = s.charAt(i);
               if (record.contains(Character.toUpperCase(c)) && record.contains(Character.toLowerCase(c))) {
                   continue;
               }
               String s1 = longestNice(s.substring(0, i));
               String s2 = longestNice(s.substring(i + 1, size));
               return s1.length() >= s2.length() ? s1 : s2;
           }

           return s;
       }
}
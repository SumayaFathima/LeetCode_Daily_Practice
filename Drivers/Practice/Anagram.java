package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Anagram {


    @Test
    public void example1() {

        String s = "tea";
        String p = "steak";
        int output = 2;
        Assert.assertEquals(anagram(s, p), output);
    }

    @Test
    public void example2() {

        String s = "t";
        String p = "t";
        int output = 0;
        Assert.assertEquals(anagram(s, p), output);
    }

    @Test
    public void example3() {

        String s = "tt";
        String p = "t";
        int output = 1;
        Assert.assertEquals(anagram(s, p), output);
    }

    /* Pseudo code :

    1. If both string length are equal, check if it is anagram, if yes return 0 else return sum of strings length
    2. With both length, make lesser length string as s1 and other as s2 and k as length of s1
    3. traverse while s2 < s2.length()-k
    4. take k length sub string from s2 and check if it is equal to s1
    5. if yes return s2 length - substr length , else l2++
    6. retunn sum of strings length means nothing matches

    */


    public int anagram(String s, String p) {

        if(s.length() == p.length()) {
            if(check(s, p) == true) {
                return 0;
            }
            else return s.length()+p.length();

        }
        int l1 = 0, l2 = 0, k = 0, count = s.length()+p.length();
        String s1 = "", s2 = "", str = "";

        if (s.length() > p.length()) {
            s1 = p;
            s2 = s;
        } else {
            s1 = s;
            s2 = p;
        }

        k = s1.length();
        while (l2 <= s2.length()-k) {

            str = s2.substring(l2, k + l2);

            if(check(str, s1) == true) {
                return (s2.length() - str.length());
            }
            else
                l2++;
        }
        return count;
    }

    private boolean check(String str, String s1) {

        if(str.equals(s1)) {
            return true;
        }
        else return false;
    }
}


//
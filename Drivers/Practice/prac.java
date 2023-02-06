package Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashSet;

public class prac {

    @Test
    public void example1() {

        String text = "hello world";
        String brokenLetters = "ad";
        int output = 1;
        Assert.assertEquals(canBeTypedWords(text, brokenLetters), output);
    }

    public int canBeTypedWords(String text, String brokenLetters) {

        int count=0, res=0;
        HashSet<Character> set = new HashSet();
        for(int i =0; i<brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }

        String[] words = text.split(" ");
        count =0;

        for(int i=0; i<words.length; i++) {

            char[] ch = words[i].toCharArray();

            for(int j=0; j<ch.length; j++) {

                if(set.contains(ch[j])) {
                    count=0;
                    break;
                }
                else count =1;
            }
            if(count==1) res++;
        }
        return res;
    }
}

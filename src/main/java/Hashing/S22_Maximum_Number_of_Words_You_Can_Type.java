package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.*;

class S22_Maximum_Number_of_Words_You_Can_Type {

    /* Leetcode_1935 : https://leetcode.com/problems/maximum-number-of-words-you-can-type/description/

        There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.
        Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of
        all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.

        Constraints:

            1 <= text.length <= 10^4
            0 <= brokenLetters.length <= 26
            text consists of words separated by a single space without any leading or trailing spaces.
            Each word only consists of lowercase English letters.
            brokenLetters consists of distinct lowercase English letters.
     */

    @Test
    public void example1() {

        String text = "hello world";
        String brokenLetters = "ad";
        int output = 1;
        Assert.assertEquals(canBeTypedWords(text, brokenLetters), output);
    }

    @Test
    public void example2() {

        String text = "leet code";
        String brokenLetters = "lt";
        int output = 1;
        Assert.assertEquals(canBeTypedWords(text, brokenLetters), output);
    }

    @Test
    public void example3() {

        String text = "leet code";
        String brokenLetters = "e";
        int output = 0;
        Assert.assertEquals(canBeTypedWords(text, brokenLetters), output);
    }

    /* Pseudo code :

        1. Declare map of Character and Integer
        2. Add the broken letters to map
        3. Split the given string with space
        4. With each word, compare if the map characters is present in that string
        5. If not count =0 and break, else count =1
        6. if count ==1, add to list
        7. Return the list size

    */

    public int canBeTypedWords(String text, String brokenLetters) {

        Map<Character,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<brokenLetters.length();i++)
            map.put(brokenLetters.charAt(i),i+1);

        String[] str=text.split(" ");
        int count=0;

        for(int i=0;i<str.length;i++) {
            char[] ch=str[i].toCharArray();
            for(int j=0;j<ch.length;j++){
                if(map.containsKey(ch[j])){
                    count=0;
                    break;
                }
                else count=1;
            }
            if(count==1)
                list.add(1);
        }

        return list.size();
    }
}


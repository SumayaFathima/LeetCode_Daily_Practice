package Revision;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class S500_Keyboard_Row {

    @Test
    public void example1() {
        String[] words = {"Hello","Alaska","Dad","Peace"};
        String[] output = new String[]{"Alaska", "Dad"};
        Assert.assertEquals(findWords(words), output);
    }
    @Test
    public void example2() {

        String[] words = {"omk"};
        String[] output = {};
        Assert.assertEquals(findWords(words), output);
    }

    @Test
    public void example3() {

        String[] words = {"adsdf","sfd"};
        String[] output = {"adsdf","sfd"};
        Assert.assertEquals(findWords(words), output);
    }

    @Test
    public void example4() {

        String[] words = {"A", "b", "C", "d"};
        String[] output = {"A", "b", "C", "d"};
        Assert.assertEquals(findWords(words), output);
    }

    /* Pseudo code :

    1. Create an ArrayList to store the result string
    2. A loop passing each string from string array
    3. Within that loop check if that string occurs in which row and take the count
    4. The row count which matches the length of the string, add that string in list
    5. Reset the counts to 0 to start the iteration with the next string
    6. Convert the list to string array and return the same

 */
    public String[] findWords(String[] words) {

        String row1 = "qwertyuiopQWERTYUIOP";
        String row2 = "asdfghjklASDFGHJKL";
        String row3 = "zxcvbnmZXCVBNM";
        int count1 =0, count2=0, count3=0;

        ArrayList<String> list = new ArrayList<>();

        for(String word : words) {
            count1 =0;count2=0; count3=0;

            for(int i=0; i<word.length(); i++) {

                if(row1.contains(String.valueOf(word.charAt(i)))) count1++;
                if(row2.contains(String.valueOf(word.charAt(i)))) count2++;
                if(row3.contains(String.valueOf(word.charAt(i)))) count3++;
            }

            if(count1 == word.length() || count2 == word.length() || count3 == word.length())
                list.add(word);
        }
        String[] res = new String[list.size()];
        list.toArray(res);

        return res;
    }
}

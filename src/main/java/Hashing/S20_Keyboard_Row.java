package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class S20_Keyboard_Row {

    /* Leetcode_500 : https://leetcode.com/problems/keyboard-row/description/

        Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of
        American keyboard like the image below.

        In the American keyboard:

            the first row consists of the characters "qwertyuiop",
            the second row consists of the characters "asdfghjkl", and
            the third row consists of the characters "zxcvbnm".

        Constraints:

            1 <= words.length <= 20
            1 <= words[i].length <= 100
            words[i] consists of English letters (both lowercase and uppercase).
    */

    @Test
    public void example1() {

        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] output = {"Alaska", "Dad"};
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

    @Test
    public void example5() {

        String[] words = {"A"};
        String[] output = {"A"};
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

        ArrayList list = new ArrayList<>();

        String row1 = "QWERTYUIOPqwertyuiop";
        String row2 = "ASDFGHJKLasdfghjkl";
        String row3 = "ZXCVBNMzxcvbnm";

        int count1 = 0, count2 = 0, count3 = 0;

        for (int i = 0; i < words.length; i++) {

            String currword = words[i];
            count1 =0; count2 =0; count3=0;

            for (int j = 0; j < currword.length(); j++) {

                if (row1.contains(String.valueOf(currword.charAt(j)))) {
                    count1++;
                }
                else if (row2.contains(String.valueOf(currword.charAt(j)))) {
                    count2++;
                }
                else if (row3.contains(String.valueOf(currword.charAt(j)))) {
                    count3++;
                }
            }

            if (count1 == currword.length() || count2 == currword.length() || count3 == currword.length()) {
                    list.add(currword);
            }
        }
                String[] result = new String[list.size()];
                list.toArray(result);
        return result;
    }
}

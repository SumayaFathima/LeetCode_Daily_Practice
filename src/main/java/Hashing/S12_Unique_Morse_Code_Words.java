package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class S12_Unique_Morse_Code_Words {

    /* Leetcode_804 : https://leetcode.com/problems/unique-morse-code-words/description/

    International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:

        'a' maps to ".-",
        'b' maps to "-...",
        'c' maps to "-.-.", and so on.
        For convenience, the full table for the 26 letters of the English alphabet is given below:

        [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...",
        "-","..-","...-",".--","-..-","-.--","--.."]

        Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

        For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call
        such a concatenation the transformation of a word.
        Return the number of different transformations among all words we have.

        Constraints:

            1 <= words.length <= 100
            1 <= words[i].length <= 12
            words[i] consists of lowercase English letters.
     */

    @Test
    public void example1() {

        String[] words = {"gin", "zen", "gig", "msg"};
        int output = 2;
        Assert.assertEquals(uniqueMorseRepresentations(words), output);
    }

    @Test
    public void example2() {

        String[] words = {"a"};
        int output = 1;
        Assert.assertEquals(uniqueMorseRepresentations(words), output);
    }

    @Test
    public void example3() {

        String[] words = {"a", "a", "a", "a", "a", "a", "a", "a", "a", "a"};
        int output = 1;
        Assert.assertEquals(uniqueMorseRepresentations(words), output);
    }


    /* Pseudo code :

        1. Store the morse code in a string array
        2. Declare a hashmap and add alphabets and morce code
        3. Declare a hashset
        4. Iterate the loop with the first word from words array
        5. Traverse until the word length and take the morce code from map with the help of key value
        6. Concat the codes of the current word and add to set
        7. Iterate the loop until words. length
        8. Return the size of the set
    */

    public int uniqueMorseRepresentations(String[] words) {

        String[] arr = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashMap map = new HashMap<>();

        for (int i = 97; i <= 122; i++) {
            map.put((char) i, arr[i - 'a']);
        }

        Set set = new HashSet();
        for (int i = 0; i < words.length; i++) {
            String s = "";
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                    s += map.get(word.charAt(j));
            }
            set.add(s);
        }
        return set.size();
    }
}

// Using hashset :

  /*  public int uniqueMorseRepresentations(String[] words) {

        String[] arr = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet set = new HashSet();

        for (int i = 0; i < words.length; i++) {
            String s = "";
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                s += arr[word.charAt(j) - 'a'];
            }
            set.add(s);
        }
        return set.size();
    }
} */

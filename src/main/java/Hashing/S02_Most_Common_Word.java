package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S02_Most_Common_Word {

    /* Leetcode_819 :  https://leetcode.com/problems/most-common-word/description/

          Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned.
          It is guaranteed there is at least one word that is not banned, and that the answer is unique.
          The words in paragraph are case-insensitive and the answer should be returned in lowercase.

          Constraints:

            1 <= paragraph.length <= 1000
            paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
            0 <= banned.length <= 100
            1 <= banned[i].length <= 10
            banned[i] consists of only lowercase English letters.
     */

    @Test
    public void example1() {

        String paragraph = "Bob hit&& a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String output = "ball";
        Assert.assertEquals(mostCommonWord(paragraph,banned), output);
    }

    @Test
    public void example2() {

        String paragraph = "a.";
        String[] banned = {};
        String output = "a";
        Assert.assertEquals(mostCommonWord(paragraph,banned), output);
    }

    @Test
    public void example3() {

        String paragraph = "mmm nnn oo";
        String[] banned = {"o"};
        String output = "mmm";
        Assert.assertEquals(mostCommonWord(paragraph,banned), output);
    }

    @Test
    public void example4() {

        String paragraph = "a.";
        String[] banned = {};
        String output = "a";
        Assert.assertEquals(mostCommonWord(paragraph,banned), output);
    }

    /* Pseudo code:

    1. Convert the string into lower case and replace all special characters by space and split the words by space
    2. Create a set and place banned word in hashset
    3. Add the words in map which are not in set
    4. Get the count of the occurrence
    5. Place the max count word in str and return the same

   */

    public String mostCommonWord(String paragraph, String[] banned) {

        int max=0;
        String str="";

        String[] para = paragraph.toLowerCase().replaceAll("[^a-z]+"," ").split(" ");
        Map<String,Integer> map = new HashMap<String,Integer>();


        Set set = new HashSet();
        for(String setword:banned){
            set.add(setword);
        }

        for(String word: para){
            if(!set.contains(word)){
                map.put(word,map.getOrDefault(word,0)+1);

                if(map.get(word)>max){
                    max=map.get(word);
                    str = word;
                }
            }
        }   return str;
    }
}

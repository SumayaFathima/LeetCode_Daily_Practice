package Assignments;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class S1768_Merge_Strings_Alternately {

    @Test
    public void example1() {
        String word1 = "abc";
        String word2 = "pqr";
        String output = "apbqcr";
        Assert.assertEquals(mergeAlternately(word1, word2), output);
    }

    @Test
    public void example2() {
        String word1 = "ab";
        String word2 = "pqrs";
        String output = "apbqrs";
        Assert.assertEquals(mergeAlternately(word1, word2), output);
    }

    @Test
    public void example3() {
        String word1 = "abcd";
        String word2 = "pq";
        String output = "apbqcd";
        Assert.assertEquals(mergeAlternately(word1, word2), output);
    }

    @Test
    public void example4() {
        String word1 = "a";
        String word2 = "b";
        String output = "ab";
        Assert.assertEquals(mergeAlternately(word1, word2), output);
    }

    /*
    - Create 2 points p1 and p2
    - Create an empty string to add the result
    - Traverse while p1 <word1 length or p2 < word2 length
    - Add both to res until condition satisfies
    - return result
     */
    public String mergeAlternately(String word1, String word2) {

            int p1 =0, p2 =0;
            String res = "";

            while(p1<word1.length() || p2 < word2.length()) {

                if (p1 < word1.length()) {
                    res += word1.charAt(p1++);
                }

                if (p2 < word2.length()) {
                    res += word2.charAt(p2++);
                }
            }

            return res;
        }
    }
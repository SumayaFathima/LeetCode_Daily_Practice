package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;

public class S10_Substrings_of_Size_Three_with_Distinct_Characters {

    /* Leetcode_1876 : https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

        A string is good if there are no repeated characters.
        Given a string s, return the number of good substrings of length three in s.
        Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
        A substring is a contiguous sequence of characters in a string.

        Constraints:

            1 <= s.length <= 100
            s consists of lowercase English letters.
     */

    @Test
    public void example1() {

        String s = "xyzzaz";
        int output = 1;
        Assert.assertEquals(substringsofSizeThree(s), output);
    }

    @Test
    public void example2() {

        String s = "aababcabc";
        int output = 4;
        Assert.assertEquals(substringsofSizeThree(s), output);
    }

    @Test
    public void example3() {

        String s = "aaa";
        int output = 0;
        Assert.assertEquals(substringsofSizeThree(s), output);
    }


    @Test
    public void example4() {

        String s = "a";
        int output = 0;
        Assert.assertEquals(substringsofSizeThree(s), output);
    }

    @Test
    public void example5() {

        String s = "ma";
        int output = 0;
        Assert.assertEquals(substringsofSizeThree(s), output);
    }

    @Test
    public void example6() {

        String s = "mno";
        int output = 1;
        Assert.assertEquals(substringsofSizeThree(s), output);
    }

    /* Pseudo code:

        1. Initialize i=0 and k=2 (for window size)
        2. Travers while k <s.length()
        3. Declare an hashmap to store character and integer
        4. Traverse while j<=k and add in map
        5. If character is already present in map, increase the frequency value
        6. Check if the size of map = 3 --> to check if the characters are distinct and add the count
        7. Increment i and k to move to the next window characters
        8. Return count
     */
    public int substringsofSizeThree(String s) {

        if (s.length() <= 2) return 0;

        int  i=0, k = 2, count = 0;

        while (k < s.length()) {

            HashMap<Character, Integer> map = new HashMap<>();

                for (int j = i; j <= k; j++) {
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                }

                if (map.size() == 3) {
                    count++;
                }
                i++;
                k++;
            }
        return count;
    }
}


    // Bruteforce :

   /* public int substringsofSizeThree(String s) {

        if(s.length() <=2) return 0;

        int count=0;

        for(int i=0; i<s.length()-2; i++) {

                if(s.charAt(i) != s.charAt(i+1) && s.charAt(i) != s.charAt(i+2) && s.charAt(i+1) != s.charAt(i+2))
                    count++;
        }
      return count;
    }
}
*/



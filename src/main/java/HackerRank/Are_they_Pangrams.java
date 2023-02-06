package HackerRank;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Are_they_Pangrams {

    @Test
    public void example1() {

        String[] pangram = {"pack my box with five dozen liquor jugs", "this is not a pangram"};
        int[] output = {1,0};
        Assert.assertEquals(pangrams(pangram), output);
    }

    /* Pseudocode:

        1. Create a new array with string array length
        2. Create a boolean array
        3. take each string and remove spaces
        4. Traverse from 0 to string length
        5. Find the character index add true in array for respective characters
        6. Then check if the array has false - if yes add 0 in new array else 1
        7. fill the array with all false values and start with next strings
        8. Return new array
     */
    public int[] pangrams(String[] pangram) {

        int[] result = new int[pangram.length];
        boolean[] bol = new boolean[26];
        int index =0;

        for(String s : pangram) {
            String str = s.replaceAll(" ", "");
            Arrays.fill(bol,Boolean.FALSE);
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                    bol[str.charAt(i) - 'a'] = true;
            }

            if (Arrays.asList(bol).contains(false))
                result[index++] = 0;
            else
                result[index++] = 1;
        }
        return result;
    }
}
package HackerRank;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Circular_Printer {

    @Test
    public void example1() {

        String s = "BZA";
        long output = 4;
        Assert.assertEquals(getTime(s), output);
    }

    @Test
    public void example2() {

        String s = "AMA";
        long output = 24;
        Assert.assertEquals(getTime(s), output);
    }

    @Test
    public void example3() {

        String s = "A";
        long output = 0;
        Assert.assertEquals(getTime(s), output);
    }

    /*
    1. Given pointer =0
    2. Traverse form 0 to word length
    3. Find the character index
    4. Then find the clockwise distance from pointer till the index
    5. FInd anticlockwise distance from pointer till the index
    6. Find the min of both and add in sum
    7. Return sum

     */
    public static long getTime(String word)
    {
        long sum = 0;
        int pointer = 0;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'A';

            int a = Math.abs(pointer - index);
            int b = 26 - Math.abs(pointer - index);
            sum += Math.min(a, b);
            pointer = index;
        }
        return sum;
    }

}

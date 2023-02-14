package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S19_Roman_to_Integer {

    /* Leetcode_13 : https://leetcode.com/problems/roman-to-integer/description/

        Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
        Symbol        Value
          I             1
          V             5
          X             10
          L             50
          C             100
          D             500
          M             1000

     For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II.
     The number 27 is written as XXVII, which is XX + V + II.

     Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
     Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
     The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
        Given a roman numeral, convert it to an integer.

     */

    @Test
    public void example1() {

        String s = "MCMXCIV";
        int output = 1994;
        Assert.assertEquals(romanToInt(s), output);
    }

    @Test
    public void example2() {

        String s = "III";
        int output = 3;
        Assert.assertEquals(romanToInt(s), output);
    }

    @Test
    public void example3() {

        String s = "LVIII";
        int output = 58;
        Assert.assertEquals(romanToInt(s), output);
    }

    @Test
    public void example4() {

        String s = "MDCLXVI";
        int output = 1666;
        Assert.assertEquals(romanToInt(s), output);
    }

    @Test
    public void example5() {

        String s = "MMMDCCCCLXXXXVIIII";
        int output = 3999;
        Assert.assertEquals(romanToInt(s), output);
    }

    @Test
    public void example6() {

        String s = "I";
        int output = 1;
        Assert.assertEquals(romanToInt(s), output);
    }

    /* Pseudo code :

        1. Declare map and add all Roman Symbols and its values
        2. Create an array list to add result values
        3. Traverse while i<s.length()
        4. Condition if i < s.length()-1 and ith and i+1 value is present then sum = sum - ith value
        5. Else sum + ith value
        6. Return sum

     */
    public int romanToInt(String s) { //MMMDCCCCLXXXXVIIII

        Map<Character, Integer> map = new HashMap();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {

            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
            {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }
}
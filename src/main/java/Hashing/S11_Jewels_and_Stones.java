package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class S11_Jewels_and_Stones {

    /* Leetcode_771 : https://leetcode.com/problems/jewels-and-stones/description/

    You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
    Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
    Letters are case sensitive, so "a" is considered a different type of stone from "A".

    Constraints:

        1 <= jewels.length, stones.length <= 50
        jewels and stones consist of only English letters.
        All the characters of jewels are unique.

   */

    @Test
    public void example1() {

        String jewels = "aA";
        String stones = "aAAbbbb";
        int output = 3;
        Assert.assertEquals(numJewelsInStones(jewels, stones), output);
    }

    @Test
    public void example2() {

        String jewels = "z";
        String stones = "ZZ";
        int output = 0;
        Assert.assertEquals(numJewelsInStones(jewels, stones), output);
    }

    @Test
    public void example3() {

        String jewels = "abcdefg";
        String stones = "a";
        int output = 1;
        Assert.assertEquals(numJewelsInStones(jewels, stones), output);
    }

    @Test
    public void example4() {

        String jewels = "m";
        String stones = "m";
        int output = 1;
        Assert.assertEquals(numJewelsInStones(jewels, stones), output);
    }

    /* Pseudo code :

        1. Declare an hashmap to store character and integer
        2. Add the characters to map with the frequency value
        3. Check if map contains jewels character and add the frequency value to count
        4. Return the count
     */

     public int numJewelsInStones(String jewels, String stones) {

         int i=0, count = 0;
         Set set = new HashSet();

         while(i < jewels.length()) {
             set.add(jewels.charAt(i++));
         }

         i=0;
         while(i < stones.length()) {
             if (set.contains(stones.charAt(i))) {
                 count++;
             } i++;
         }
         return count;
     }
}

  /*  public int numJewelsInStones(String jewels, String stones) {

        int count =0;

        HashMap<Character, Integer> map = new HashMap<>();

        while(i < stones.length()) {
            map.put(stones.charAt(i), map.getOrDefault(stones.charAt(i++), 0) + 1);
        }

        i=0;
        while(i<jewels.length()) {
            if (map.containsKey(jewels.charAt(i))) {
                count += map.get(jewels.charAt(i));
            } i++;
        } return count;
    }
} */

//Bruteforce :

   /* public int numJewelsInStones(String jewels, String stones) {

        int count=0;

        for(int i=0; i<jewels.length(); i++) {

            for(int j=0; j<stones.length(); j++) {

                if(jewels.charAt(i) == stones.charAt(j))
                    count++;
            }
        }  return count;
    }
} */




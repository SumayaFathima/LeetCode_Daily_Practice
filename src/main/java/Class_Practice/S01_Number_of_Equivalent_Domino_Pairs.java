package Class_Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S01_Number_of_Equivalent_Domino_Pairs {

    /* Leetcode_1128 : https://leetcode.com/problems/number-of-equivalent-domino-pairs/

        Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either
        (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

        Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

        Constraints:

            1 <= dominoes.length <= 4 * 10^4
            dominoes[i].length == 2
            1 <= dominoes[i][j] <= 9
   */

    @Test
    public void example1() {

        int[][] dominoes  = {{1,2},{2,1},{3,4},{5,6}};
        int output = 1;
        Assert.assertEquals(numEquivDominoPairs(dominoes), output);
    }

    @Test
    public void example2() {

        int[][] dominoes  = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        int output = 3;
        Assert.assertEquals(numEquivDominoPairs(dominoes), output);
    }

    @Test
    public void example3() {

        int[][] dominoes  = {{1,2}};
        int output = 0;
        Assert.assertEquals(numEquivDominoPairs(dominoes), output);
    }

    @Test
    public void example4() {

        int[][] dominoes  = {{1,2},{5,6}};
        int output = 0;
        Assert.assertEquals(numEquivDominoPairs(dominoes), output);
    }

    @Test
    public void example5() {

        int[][] dominoes  = {{0,0},{0,0}};
        int output = 1;
        Assert.assertEquals(numEquivDominoPairs(dominoes), output);
    }

    /* Pseudo code :

        1. Initialize count =0 and result =0;
        2. Declare hashmap to store String and Integer
        3. A loop having each domino sorted and converted as string and place in map with the frequency value
        4. An entry set to take the mapvalue where count >1
        5. if count is >1, calculate each entry with count*(count-1)/2 formula
        6. store the count in result
        7. Return the result

    */

    public int numEquivDominoPairs(int[][] dominoes) {

        int count = 0, result =0;
        Map<String, Integer> map = new HashMap<>();

        for(int[] fr : dominoes) {
            Arrays.sort(fr);
            String mapkey = fr[0] + " " + fr[1];
            map.put( mapkey, map.getOrDefault( mapkey , 0)+1);
            }

            for(Map.Entry<String, Integer> entry : map.entrySet()) {

                if(entry.getValue() >1) {

                    count = entry.getValue();
                    count = count*(count-1)/2;
                    result += count;
                }
            } return result;
        }
    }


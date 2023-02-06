package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class S16_Find_the_Town_Judge {

        /* Leetcode_997 : https://leetcode.com/problems/find-the-town-judge/description/

           In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
           If the town judge exists, then:
                 *  The town judge trusts nobody.
                 *  Everybody (except for the town judge) trusts the town judge.
                 *  There is exactly one person that satisfies properties 1 and 2.

           You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person
           labeled bi.
           Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.


            Constraints:

                1 <= n <= 1000
                0 <= trust.length <= 104
                trust[i].length == 2
                All the pairs of trust are unique.
                ai != bi
                1 <= ai, bi <= n
         */

    @Test
    public void example1() {

        int[][] trust  = {{1,3} , {2,3} , {3,1}};
        int n=3;
        int output = -1;
        Assert.assertEquals(findJudge(n, trust), output);
    }

    @Test
    public void example2() {

        int[][] trust  = {{1,3} , {2,3}};
        int n=3;
        int output = 3;
        Assert.assertEquals(findJudge(n, trust), output);
    }

    @Test
    public void example3() {

        int[][] trust  = {};
        int n=1;
        int output = 1;
        Assert.assertEquals(findJudge(n, trust), output);
    }

    @Test
    public void example4() {

        int[][] trust  = {{2,1}};
        int n=2;
        int output = 1;
        Assert.assertEquals(findJudge(n, trust), output);
    }

    @Test
    public void example5() {

        int[][] trust  = {{1,2}};
        int n=2;
        int output = 2;
        Assert.assertEquals(findJudge(n, trust), output);
    }

    @Test
    public void example6() {

        int[][] trust  = {};
        int n=2;
        int output = -1;
        Assert.assertEquals(findJudge(n, trust), output);
    }

        /* Pseudo code :

            1. Declare a hashmap to add trust values
            2. Add each trust[0] in map with the value of -1 to calculate if Town judge is present
            3. Add each trust[1] in map with the value of 1
            4. With Keyset, get the key which has n-1 to be the town judge
            5. If no town judge return -1
         */

    public int findJudge(int n, int[][] trust) {

        if(trust.length ==0 && n==1) return n;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] fr : trust) {
            map.put(fr[0], map.getOrDefault(fr[0], 0) - 1);
            map.put(fr[1], map.getOrDefault(fr[1], 0) + 1);
        }

        for(Integer key : map.keySet()){
            if(map.get(key) == n-1)
                return key;
        }
        return -1;
    }
}
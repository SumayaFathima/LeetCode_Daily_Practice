package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class S575_Distribute_Candies {

    @Test
    public void example1() {
        int[] candyType = {1,1,2,2,3,3};
        int output = 3;
        Assert.assertEquals(distributeCandies(candyType), output);
    }

    @Test
    public void example2() {
        int[] candyType = {1,1,2,3};
        int output = 2;
        Assert.assertEquals(distributeCandies(candyType), output);
    }

    @Test
    public void example3() {
        int[] candyType = {6,6,6,6};
        int output = 1;
        Assert.assertEquals(distributeCandies(candyType), output);
    }

    /*  Pseudo code:
     - Create a hashmap and add all elements with teh frequency count
     - if the map size >= array length/2 then return array length/2
     - return map size by default
     */
    public int distributeCandies(int[] candyType) {

        int n = (candyType.length)/2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int candy : candyType) {
            if(map.containsKey(candy)) {
                map.put(candy, map.getOrDefault(candy, 0) +1);
            }
            else
                map.put(candy,1);
        }

        if(map.size() >= n) return n;

        return map.size();
    }
}

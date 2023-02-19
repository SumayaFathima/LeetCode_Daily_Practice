package Daily_Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class S2103_Rings_and_Rods {

    @Test
    public void example1() {
        String rings = "B0B6G0R6R0R6G9";
        int output =1;
        Assert.assertEquals(countPoints(rings), output);
    }

    @Test
    public void example2() {
        String rings = "B0R0G0R9R0B0G0";
        int output =1;
        Assert.assertEquals(countPoints(rings), output);
    }

    @Test
    public void example3() {
        String rings = "G4";
        int output =0;
        Assert.assertEquals(countPoints(rings), output);
    }

    /*
    1. Create a hashmap with Character and set<Character>
    2. Traverse from 1 till string length
    3. if map does not contains key, then put the key in map and add hashset in value
    4. then get mapkey and add the previous value
    5. Get all map values and check if the set size ==3, if yes increment count
    6. return count

     */
    public int countPoints(String rings) {

        int count =0;

        HashMap<Character, Set<Character>> map = new HashMap<>();

        for(int i=1; i<rings.length(); i++) {

            if(!map.containsKey(rings.charAt(i))) {
                map.put(rings.charAt(i), new HashSet<Character>());
            }
            map.get(rings.charAt(i)).add(rings.charAt(i-1)) ;
            i++;
        }

        for(Set<Character> set : map.values()) {
            if(set.size() ==3)
                count++;
        }

        return count;
    }
}

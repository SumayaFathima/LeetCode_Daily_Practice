package Hashing;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;


public class S05_Destination_City {

    @Test
    public void example1() {
        List<List<String>> paths = new ArrayList<List<String>>();
        paths.add(new ArrayList(Arrays.asList("London","New York")));
        paths.add(new ArrayList(Arrays.asList("New York","Lima")));
        paths.add(new ArrayList(Arrays.asList("Lima","Sao Paulo")));
        Assert.assertEquals(destinationCity(paths), "Sao Paulo");
    }

    @Test
    public void example2() {
        List<List<String>> paths = new ArrayList<List<String>>();
        paths.add(new ArrayList(Arrays.asList("B","C")));
        paths.add(new ArrayList(Arrays.asList("D","B")));
        paths.add(new ArrayList(Arrays.asList("C","A")));
        Assert.assertEquals(destinationCity(paths), "A");
    }

    @Test
    public void example3() {
        List<List<String>> paths = new ArrayList<List<String>>();
        paths.add(new ArrayList(Arrays.asList("A","Z")));
        Assert.assertEquals(destinationCity(paths), "Z");
    }

    @Test
    public void example4() {
        List<List<String>> paths = new ArrayList<List<String>>();
        paths.add(new ArrayList(Arrays.asList("AB","AC")));
        paths.add(new ArrayList(Arrays.asList("DC","AB")));
        Assert.assertEquals(destinationCity(paths), "AC");
    }

    /* Pseudo code:

        1. Add the list of strings to map
        2. Take the destination cities from list and store in a string
        3. Compare with the key in map(start city) if that dest city is present
        4. If it is not present then return the dest city

    */

     public String destinationCity(List<List<String>> paths) {

        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : paths) {
            map.put(list.get(0), list.get(1));
        }

        String destcity = paths.get(0).get(1);
        while (map.containsKey(destcity)) {
            destcity = map.get(destcity);
        }
        return destcity;
    }
}


package Hashing;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;


public class Destination_City {

    @Test
    public void example1() {
        String[][] paths = {{"London", "New York"}, {"New York", "Lima"}, {"Lima", "Sao Paulo"}};
        List<List<String>> list = new ArrayList<>();

        for (String[] s : paths) {
            list.add(List.of(s));
        }
        Assert.assertEquals(destinationCity(list), "Sao Paulo");
    }


    public String destinationCity(List<List<String>> paths) {


    }
}


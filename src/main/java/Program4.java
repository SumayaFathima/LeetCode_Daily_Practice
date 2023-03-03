import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Program4 {

    @Test
    public void example() {
        String str = "Great responsibility";
        test(str);
    }

    public void test(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(Character ch : str.toCharArray()) {

            if(map.containsKey(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) +1);
            }
            else
                map.put(ch, 1);
        }

        for(Character ch : map.keySet()) {
            if (map.get(ch) > 1)
                System.out.println(ch + " - " + map.get(ch));
        }
    }
}

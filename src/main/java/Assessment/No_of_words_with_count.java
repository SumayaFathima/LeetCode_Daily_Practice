package Assessment;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class No_of_words_with_count {

    @Test
    public void example1() {

        String str = "My name is abc my father name is bcd my mother name is xyz";
        String output = "My -2 my -2 is-3 abc-1 father -1 mother -1 name -3 bcd -1 xyz -1";
        Assert.assertEquals(count(str), output);
    }

    public String count(String str) {

        HashMap<String, Integer> map = new HashMap<>();

        String[] split = str.split(" ");
        for(String s : split) {

            if(map.containsKey(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            else
                map.put(s, 1);
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()) {

            System.out.print(entry.getKey()+ "-" + entry.getValue() + " ");
        }

        return str;
    }
}

package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class ransom_ListofStrings {

    @Test
    public void example1() {

       // List<String> magazine = {{"two"}, {"times"}, {"three"}, {"is"}, {"not"}, {"four"}};
       // List<String> note = {"two", "times", "two", "is", "four"};
        String output = "yes";
       // Assert.assertEquals(checkMagazine(magazine, note), output);
    }

    public void checkMagazine(List<String> magazine, List<String> note) {

        boolean present = true;
        if (magazine.size() < note.size())
            present = false;

        HashMap<String, Integer> map = new HashMap();


        for (String word : magazine) {

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else
                map.put(word, 1);
        }

        for (String singlenote : note) {
            if (map.containsKey(singlenote) && map.get(singlenote) > 0) {
                map.put(singlenote, map.get(singlenote) - 1);
            } else
                present = false;
        }
        if (present)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

/*
 boolean present = true;
        for(String n : note) {
            if (magazine.contains(n)) {
                magazine.remove(n);
            } else {
                present = false;
                break;
            }
        }
       if (present) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
 */



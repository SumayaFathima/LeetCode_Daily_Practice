package Assessment;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Permutations_in_a_String {

    @Test
    public void example1() {

        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean output = true;
        Assert.assertEquals(isAnagram(s1, s2), output);
    }

    private boolean isAnagram (String s1, String s2) {

        StringBuilder input1 = new StringBuilder();
        input1.append(s1);
        input1.reverse();
        String ss = input1.toString();

        if(s2.contains(ss)) return true;

        return false;
    }
}


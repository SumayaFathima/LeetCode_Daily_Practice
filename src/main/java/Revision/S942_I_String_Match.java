package Revision;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S942_I_String_Match {

    @Test
    public void example1() {
        String s = "IDID";
        int[] output = {0,4,1,3,2};
        Assert.assertEquals(diStringMatch(s), output);
    }

    public int[] diStringMatch(String s) {

        int highest = s.length();
        int lowest = 0;

        int[] tr = new int[s.length()+1];

        if (s.charAt(0) == 'D') {
            tr[0] = highest--;
        } else {
            tr[0] = lowest++;
        }

        for (int i=1;i<tr.length-1;i++) {

            if (s.charAt(i) == 'I') {

                tr[i] = lowest++;

            } else if (s.charAt(i) == 'D') {

                tr[i] = highest--;
            }
        }

        tr[tr.length-1] = lowest;

        return tr;

    }
}

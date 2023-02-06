package HackerRank;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class PanAndGstinVal {

    /* It is compulsory to provide your PAN while registering for a GSTIN in fact, your GSTIN is intrinsically linked
        to your PAN as below

        Format of GSTIN :

            22 AAAAA0000A 1 Z 5

            22 - State code
            PAN - AAAAA0000A
            1 - Entity number of the same PAN holder in a state
            Z - Alphabet '2' by default
            5 - Check sum digit

     */

    @Test
    public void example1() {

        String pan = "AAAAA0000A";
        String gstin = "22AAAAA0000A1Z3";
        boolean output = true;
        Assert.assertEquals(validation(pan, gstin), output);
    }

    @Test
    public void example2() {

        String pan = "AAAAA0000A1Z5";
        String gstin = "22AAAAa0000A1Z5";
        boolean output = false;
        Assert.assertEquals(validation(pan, gstin), output);
    }

    @Test
    public void example3() {

        String pan = "AAAAA0000A";
        String gstin = "21MAAAA0000A123";
        boolean output = false;
        Assert.assertEquals(validation(pan, gstin), output);
    }

    /*
        1. Traverse from gstin 2 to length-4 index
        2. check if pan and gstin are same
        3. if yes increment index of pan else return false
        4. Return true by default

     */
    /* public boolean validation(String pan, String gstin) {

       int index =0;
        for(int i =2; i<= gstin.length()-4; i++) {

            if (pan.charAt(index) != gstin.charAt(i)) return false;
            else
                index++;
        }
        return true;
    }
} */

        public boolean validation(String pan, String gstin) {

            if(gstin.contains(pan)) {
                return true;
            }
        return false;
    }
}
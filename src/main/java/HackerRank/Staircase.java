package HackerRank;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class Staircase {

    @Test
    public void example1() {

        int n=6;
        staircase(n);
        //boolean output = true;
        //Assert.assertEquals(staircase(n), output);
    }

    public static void staircase(int n) {

        int level = n-1;
        for(int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for(int k = 0; k < level; k++) {
                s.append(" ");
            }
            for(int k = 0; k < n - level; k ++){
                s.append("#");
            }
            level -= 1;
            System.out.println(s.toString());
        }
    }
}
/*
     #
    ##
   ###
  ####
 #####
######
 */

    /*    for (int i = n; i >= 1; i--) {

            int a = 1;
            while (a <= n - i + 1) {
                System.out.println("#");
                a++;
            }
        }
    }
}
 #
 ##
 ###
 ####
 #####
 ######
 */

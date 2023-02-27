package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No_Carry_System {

    /*
    You are given two positive numbers n and m. You have to find a simple addition of both numbers but with a given
    condition that there is not any carry system in this addition. That is no carry is added at higher MSBs.
    */

    @Test
    public void example1() {
        int m = 456;
        int n = 854;
        int output = 200;
        Assert.assertEquals(Program(m, n), output);
    }

    public int Program(int m, int n) {

        int add;

        add = (m % 10) + (n % 10);


        return 0;
    }
}
package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Simple_Max_Difference {

    @Test
    public void example1() {

        int[] px = {7, 1, 2, 5};
        int output = 4;
        Assert.assertEquals(maxDifference(px), output);
    }

    @Test
    public void example2() {

        int[] px = {-1, -2, -5, -8};
        int output = -1;
        Assert.assertEquals(maxDifference(px), output);
    }

    @Test
    public void example3() {

        int[] px = {7};
        int output = 7;
        Assert.assertEquals(maxDifference(px), output);
    }

    @Test
    public void example4() {

        int[] px = {-10};
        int output = -1;
        Assert.assertEquals(maxDifference(px), output);
    }

    /*
    1. Initialize maximum as -1
    2. Traverse from right
    3. if i > j value then find max with maximuma nd diff of i and j
    4. return maximum

     */

  /*  public static int maxDifference(int[] px) {

        if(px.length ==1 && px[0] >=0) return px[0];
        if(px.length ==1 && px[0] < 0) return -1;

        int maximum = -1;

        for(int i= px.length-1; i >0; i--) {

            for(int j=i-1; j>=0; j--) {

                if(px[i] > px[j]) {
                    maximum = Math.max(maximum, px[i]- px[j]);
                }
            }
        return maximum;
    }
} */

    /*
        1. Declare stack
        2. push first index value to stack
        3. Traverse from 1 till length
        4. if stack is not empty and the peek value is less than px[i]
        5. find max of maximum and diff of px[i] and peek value
        6. else push in stack
        7. Return maximum
     */
    public static int maxDifference(int[] px) {

        if(px.length ==1 && px[0] >=0) return px[0];
        if(px.length ==1 && px[0] < 0) return -1;

        int maximum = -1;

        Stack<Integer> stack = new Stack();
        stack.push(px[0]);

        for(int i=1; i<px.length; i++) {

            if(!stack.isEmpty() && stack.peek() < px[i]) {

                maximum = Math.max(maximum, px[i]- stack.peek() );
            }
            else
                stack.push(px[i]);
        }
        return maximum;
    }
}


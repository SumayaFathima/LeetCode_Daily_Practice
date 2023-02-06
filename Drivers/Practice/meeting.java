package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class meeting {

    @Test
    public void example1() {

        int[][] input = {{0,30},{5,10},{15,20}};
        boolean output = false;
        Assert.assertEquals(meeting(input), output);
    }

    @Test
    public void example2() {

        int[][] input = {{7,10},{2,4}};
        boolean output = true;
        Assert.assertEquals(meeting(input), output);
    }

    @Test
    public void example3() {

        int[][] input = {{0,30}};
        boolean output = true;
        Assert.assertEquals(meeting(input), output);
    }

    @Test
    public void example4() {

        int[][] input = {{1,2},{2,3}};
        boolean output = false;
        Assert.assertEquals(meeting(input), output);
    }

    @Test
    public void example5() {

        int[][] input = {{1,10},{11,20},{30,40},{12,32}};
        boolean output = false;
        Assert.assertEquals(meeting(input), output);
    }

    public boolean meeting(int[][] input) {

        Arrays.sort(input, (a, b) -> a[0] - b[0]);

        HashMap<Integer, Integer> map = new HashMap();

        for(int[] s : input) {

            if(!map.isEmpty()) {

                if(map.get(1) < s[0] && s[0] < s[1]) {
                    map.put(s[0], s[1]);
                }
                else return false;
            }
	        else {
                map.put(s[0], map.getOrDefault(s[0], s[1]));
            }
        }

	return true;
    }
}

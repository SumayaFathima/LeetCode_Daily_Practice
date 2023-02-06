package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

public class sortpeople {
    @Test
    public void example1() {

        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        String[] output = {"Mary", "Emma", "John"};
        Assert.assertEquals(sortPeople(names, heights), output);
    }

  /*  public String[] sortPeople(String[] names, int[] heights) {

        String[] res =new String[names.length];
        int newarr =0;
        HashMap<Integer, String> map = new HashMap();

        for(int i=0; i<heights.length; i++) {

            map.put(heights[i],names[i]);
        }

        Arrays.sort(heights);
        for(int i=names.length-1; i>=0; i--) {
                res[newarr] = map.get(heights[i]);
                newarr++;
        }
        return res;
    }
} */

    public String[] sortPeople(String[] names, int[] heights) {

        int[] heightnew = new int[heights.length];
        int[] namesnew = new int[names.length];



        return names;
    }
}

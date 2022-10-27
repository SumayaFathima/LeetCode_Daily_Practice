import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Testing {

    @Test
    public void example1() {
        int[] g = {1,2,3};
        int[] s = {3,4,5};
        int output = 3;
        Assert.assertEquals(findContentChildren(g, s), output);
    }

    @Test
    public void example2() {
        int[] g = {1};
        int[] s = {3,4,5};
        int output = 1;
        Assert.assertEquals(findContentChildren(g, s), output);
    }

    @Test
    public void example3() {
        int[] g = {1,2,3};
        int[] s = {3};
        int output = 1;
        Assert.assertEquals(findContentChildren(g, s), output);
    }

    @Test
    public void example5(){
        int[] g={1};
        int[] s={};
        int output = 0;
        Assert.assertEquals(findContentChildren(g, s), output);
    }

/* Pseudo Code :

    1. Check if array is empty or not, if yes return 0
    2. Create two pointers left = 0 and right=0
    3. Traversal array to each element to match s[j] >= g[i]
    4. If s[j] >= g[i], we can assign the cookie and the child will be content, increment left and right
    5. Else increment left and move to next cookie
    6. Return the content cookie count */

    public static int findContentChildren(int[] g, int[] s) {

        if (g.length < 1 && s.length < 1) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0;
        for (int i = 0; i < s.length; i++) {
                j=i;
                if (j < g.length && g[j] <= s[i]) {
                    g[j] = s[i];
                    j++;
                }
            }

        return j;
    }
}
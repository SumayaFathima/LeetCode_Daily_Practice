package Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;

public class isomorphi {

    @Test
    public void example1() {

        String s = "egg";
        String t = "add";
        boolean output = true;
        Assert.assertEquals(isomorphicstring(s, t), output);
    }

    @Test
    public void example2() {

        String s = "s";
        String t = "d";
        boolean output = true;
        Assert.assertEquals(isomorphicstring(s, t), output);
    }

    @Test
    public void example3() {

        String s = "&7890!";
        String t = "abcdef";
        boolean output = true;
        Assert.assertEquals(isomorphicstring(s, t), output);
    }

    @Test
    public void example4() {

        String s = "**&()#";
        String t = "123416";
        boolean output = false;
        Assert.assertEquals(isomorphicstring(s, t), output);
    }

    /* Pseudo code :

        1. Declare map
        2. Check if s value is present in map
        3. if it is present then check it is mapped to t else return false
        4. Also check for other map value if it has t value - if yes return false
        5. if both fails, add s and t in map
        6. Return true

    */
    public boolean isomorphicstring(String s, String t) {

        HashMap<Character,Character> map = new HashMap();

        for(int i=0; i<s.length(); i++) {

            if(map.containsKey(s.charAt(i))) {

                if(map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }

            else if(map.containsValue(t.charAt(i)))
            return false;

	        else
            map.put(s.charAt(i), t.charAt(i));

        } return true;
    }
}


/* Mistakes :
1. Added an elseif which was incomplete
2. Added return statement
3. false spelling was wrong
 */
package Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class Find_the_Difference {

    @Test
    public void example1() {

        String s = "egg";
        String t = "add";
        boolean output = true;
        Assert.assertEquals(findTheDifference(s, t), output);
    }

    public char findTheDifference(String s, String t) {

        int[] arr = new int[26];

        for(int i=0; i<s.length(); i++) {

            arr[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<t.length(); i++) {

            arr[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return (char)(i + 'a');
        }

        return 'a';
}
}

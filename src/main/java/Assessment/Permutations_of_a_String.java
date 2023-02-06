package Assessment;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Permutations_of_a_String {

    @Test
    public void example1() {

        String str = "Grek";
        String[] output = {"rekg regk rgek rgek gerk gekr grke egrk gerk kgre gkre grke"};
        Assert.assertEquals(permute(str), output);
    }

    static void permutations(String s, String answer) {
        if (s.length() == 0) {
            System.out.println(answer + "  ");
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String ros = s.substring(0, i) +
                    s.substring(i + 1);

            permutations(ros, answer + ch);
        }
    }

    public String[] permute(String str) {

        String s = "Grek";
        String answer = "";

        System.out.print("\nAll possible strings are : ");
        permutations(s, answer);

        return new String[0];
    }
}

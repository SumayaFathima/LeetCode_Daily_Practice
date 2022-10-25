package BruteForce;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S01_MaximumNoOfVowels {

        /* Given a string s and a number k, find the maximum number of vowels in substring of size k. */

        @Test
        public void example1() {
                String s = "workaattech";
                int k = 3;
                int output = 2;
                Assert.assertEquals(maximumVowels(s, k), output);
        }

        @Test
        public void example2() {
                String s = "wwwww";
                int k = 3;
                int output = 0;
                Assert.assertEquals(maximumVowels(s, k), output);
        }

        @Test
        public void example3() {
                String s = "i";
                int k = 1;
                int output = 1;
                Assert.assertEquals(maximumVowels(s, k), output);
        }

    /*  Pseudo Code :

          *** Create a method of vowels to compare***
       1. Create 2 loops to traverse till s.length-1;
       2. Traverse first loop until the length of the string and second loop for k elements
       3. Calculate the count only if the string has vowels and store the count in maximum
       4. Compare count and maximum value and store the maximum value in maximum
       5. Iterate the loop till s.length-1;
       6. Return the maximum value
    */


        public int maximumVowels(String s, int k) {

                int maximum = Integer.MIN_VALUE;

                if(s.length()==1 && isVowel(s.charAt(0))) return 1;
                if(s.length()==1 && !isVowel(s.charAt(0))) return 0;

                int count = 0;
                for (int i = 0; i < s.length()-1; i++) {
                        count = 0;
                        for (int j = i; j< i+k-1; j++) {
                                if (isVowel(s.charAt(j))) count++;
                        }
                        maximum =  Math.max(maximum, count);
                }
                return maximum;
        }
        private boolean isVowel(char ch) {
                return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
        }
}
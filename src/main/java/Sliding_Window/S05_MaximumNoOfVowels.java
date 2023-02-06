package Sliding_Window;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S05_MaximumNoOfVowels {

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
       1. Create pointer =0, and count=0;
       2. Traverse till the length of k in the first window and calculate the count only the string has vowels
       3. Store the count in maximum
       4. Traverse to the next window by deleting end value of the previous window(if it is vowel, decrement the count)
       5. and add the first value of the next window (if it has vowel, increment the count)
       6. Compare count and maximum value and store the maximum value in maximum
       7. Iterate the loop while pointer < input.length
       8. Return the maximum value
    */

    public int maximumVowels(String s, int k) {

        int maximum = Integer.MIN_VALUE;
        int pointer =0, count=0;

        while(pointer<k) {
            if(isVowel(s.charAt(pointer))) count++;
            pointer++;
        }
        maximum = count;

        while(pointer<s.length()) {

            if(isVowel(s.charAt(pointer))) count++;
            if(isVowel(s.charAt(pointer-k))) count--;

            maximum =  Math.max(maximum, count);
            pointer++;
        }
        return maximum;
    }

    public boolean isVowel(char ch) {

        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }
}

 /* Bruteforce :
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
} */
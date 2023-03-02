package Assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class S821_Shortest_Distance_to_a_Character {
    @Test
    public void example1() {
        String s = "loveleetcode";
        char c = 'e';
        int[] output = {3,2,1,0,1,0,0,1,2,2,1,0};
        Assert.assertEquals(shortestToChar(s,c), output);
    }

    @Test
    public void example2() {
        String s = "aaba";
        char c = 'b';
        int[] output = {2,1,0,1};
        Assert.assertEquals(shortestToChar(s,c), output);
    }

    @Test
    public void example3() {
        String s = "m";
        char c = 'm';
        int[] output = {0};
        Assert.assertEquals(shortestToChar(s, c), output);
    }
    /*
        - Create 2 pointers left and right
        - Create a new array with string length and fill with max value
        - First traverse from 0 till end
            - when right finds the character, find distance between right and left and place in array
        - Then traverse from end till 0
            - when right finds the character, find min distance between diff of right and left and current array value
        - return array
     */
    public int[] shortestToChar(String s, char c) {

        int left =0, right =0;

        int[] arr = new int[s.length()];
        Arrays.fill(arr, Integer.MAX_VALUE);

        while(right < s.length()) {

            if(s.charAt(right) == c) {
                while(left <= right) {
                    arr[left] = right-left;
                    left++;
                }
            }
            right++;
        }

        left = s.length()-1;
        right = s.length()-1;

        while(right >= 0) {

            if(s.charAt(right) == c) {
                while(left >= right) {
                    arr[left] = Math.min((left -right), arr[left]);
                    left--;
                }
            }
            right--;
        }
        return arr;
    }
}
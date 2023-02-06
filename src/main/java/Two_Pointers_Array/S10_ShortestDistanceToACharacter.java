package twoPointers_Array;

import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S10_ShortestDistanceToACharacter {

	/* Leetcode_821 :  https://leetcode.com/problems/shortest-distance-to-a-character/

		Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length
		and answer[i] is the distance from index i to the closest occurrence of character c in s.

		The distance between two indices i and j is abs(i - j), where abs is the absolute value function.

	  Constraints:

		1 <= s.length <= 10^4
		s[i] and c are lowercase English letters.
		It is guaranteed that c occurs at least once in s.
	*/
	
	@Test
	public void example1() {
		String s = "loveleetcode";
		char c = 'e';
		int[] output = {3,2,1,0,1,0,0,1,2,2,1,0};
		Assert.assertEquals(shortestDistance(s,c), output);
	}
	
	@Test
	public void example2() {
		String s = "aaba";
		char c = 'b';
		int[] output = {2,1,0,1};
		Assert.assertEquals(shortestDistance(s,c), output);
	}
	
	 @Test
	 public void example3() {
	    String s = "m";
	    char c = 'm';
	    int[] output = {0};
	    Assert.assertEquals(shortestDistance(s, c), output);
	}
	 
	/* Pseudo Code :

	 	1. Create two pointers left = 0, right=0;
	 	2. Create an array for storing the result
	 	3. Fill the array with Integer.MAX_VALUE
	 	4. Traverse while right<length of the array
	 	5. When right matches the character, check for left<=right else increment right
	 	6. Then update left by index (right-left) and increment left
	 	7. Now traverse from right so left and right should be length-1
	 	8. Traverse while right>=0 and repeat until left and right pointers meet
	 	9. Update the values into output array only when the difference if left-right is less than current array value
	 	10.Return the output array
	*/ 

	public int[] shortestDistance(String s, char c) {

		int length = s.length();
		int[] arr = new int[length];
		Arrays.fill(arr, Integer.MAX_VALUE);

		int left = 0, right=0;

		while(right<length) {
			if(s.charAt(right) == c) {
				while(left<=right) {
					arr[left] = right-left;
					left++;
				}
			}
			right++;
		}
		left = right = length-1;
		
		while(right>=0) {
			if(s.charAt(right) == c) {
				while(left>=right) {

					arr[left] = Math.min((left-right), arr[left]);
					left--;
				}
			}
			right--;
		}
		
		return arr;
	}
}
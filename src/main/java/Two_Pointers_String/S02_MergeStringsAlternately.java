package Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S02_MergeStringsAlternately {
	
	/* Leetcode__1768 : https://leetcode.com/problems/merge-strings-alternately/
	 	
	 	You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
	 	If a string is longer than the other, append the additional letters onto the end of the merged string.
	 	
		Return the merged string.
		
		Constraints:

			1 <= word1.length, word2.length <= 100
			word1 and word2 consist of lowercase English letters.
	*/	

		@Test
		public void example1() {
			String word1 = "abc";
			String word2 = "pqr";
			String output = "apbqcr";
			Assert.assertEquals(mergeAlternately(word1,word2), output);
		}
		
		@Test
		public void example2() {
			String word1 = "ab";
			String word2 = "pqrs";
			String output = "apbqrs";
			Assert.assertEquals(mergeAlternately(word1,word2), output);
		}
		
		@Test
		public void example4() {
			String word1 = "abcd";
			String word2 = "pq";
			String output = "apbqcd";
			Assert.assertEquals(mergeAlternately(word1,word2), output);
		}
		
		@Test
		public void example5() {
			String word1 = "mno";
			String word2 = "a";
			String output = "mano";
			Assert.assertEquals(mergeAlternately(word1,word2), output);
		}

	/*Pseudo code:
 
   		1. Create 2 pointers left=0, right=0
   		2. Create a String Builder
   		3. Traverse while left < strlen1 or right < strlen2
   		4. If left < strlen1 then, append current character from word1 and increment left
   		5. If right < strlen2 then, append current character from word2 and increment right
   		6. Return built string
   
   */
 
	public String mergeAlternately(String word1, String word2) {
		
		int left=0, right=0;
		
		StringBuilder sb = new StringBuilder();
		
		
				while(left < word1.length() || right < word2.length()) {
					
					if(left < word1.length()) {
						sb.append(word1.charAt(left++));						
					}
					
					if(right < word2.length()) {
						sb.append(word2.charAt(right++));					
				}
					
				}	return sb.toString();	
	}
}
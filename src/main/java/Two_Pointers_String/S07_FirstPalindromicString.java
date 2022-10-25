package Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S07_FirstPalindromicString {

	/* Leetcode_2108 : https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
	 
	 	 Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".
		 A string is palindromic if it reads the same forward and backward.
		 
	  Constraints:

		1 <= words.length <= 100
		1 <= words[i].length <= 100
		words[i] consists only of lowercase English letters.
    */
	
	@Test
	public void example1() {		
		String words[] = {"abc","car","ada","racecar","cool"};
		String output = "ada";
		Assert.assertEquals(firstPalindrome(words), output);
	}
	
	@Test
	public void example2() {
		String words[] = {"notapalindrome","racecar"};
		String output = "racecar";
		Assert.assertEquals(firstPalindrome(words), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String words[] = {"ding","dong","bell"};
		String output = "";
		Assert.assertEquals(firstPalindrome(words), output);
	}
	
	@Test
	public void example4() {
		String words[] = {"racecar","ada","level"};
		String output = "racecar";
		Assert.assertEquals(firstPalindrome(words), output);
	}
	
	/*
	  Pseudocode :
	 
	   1. Traverse every word through the array
	   2. Create pointers left=0 and right=words[i].length()-1
	   3. If values in left and right are not equal, break
	   4. else increment left and decrement right and continue to check the values
	   5. If left>=right return words[i]
	 */	
	
	public String firstPalindrome(String[] words) {
		
		
		for(int i=0; i<words.length; i++) {
			
			if(words[i].length()==1) return words[i];
			
			int left =0, right = words[i].length()-1;
			
			while(left<right) {
				
				if(words[i].charAt(left) != words[i].charAt(right)) 
					break;
				
				else if(words[i].charAt(left) == words[i].charAt(right)) 		
	            	left++;
	            	right--;
	            	
	            if(left>=right) return words[i];
			}	
		} return " ";
	}  
}
	
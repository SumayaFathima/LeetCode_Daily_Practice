package Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S03_ReverseOnlyLetters {
	
	/*  Leetcode_917 : https://leetcode.com/problems/reverse-only-letters/
	
	    Given a string s, reverse the string according to the following rules:

		All the characters that are not English letters remain in the same position.
		All the English letters (lowercase or uppercase) should be reversed.
		Return s after reversing it.
		
		Constraints:

			1 <= s.length <= 100
	 		s consists of characters with ASCII values in the range [33, 122].
			s does not contain '\"' or '\\'.
	*/

	@Test
	public void example1() {
		String s = "ab-cd";
		String output = "dc-ba";
		Assert.assertEquals(reverseLetters(s), output);
	}
	
	@Test
	public void example2() {
		String s = "a-bC-dEf-ghIj";
		String output = "j-Ih-gfE-dCba";
		Assert.assertEquals(reverseLetters(s), output);
	}
	
	@Test
	public void example3() {
		String s = "Test1ng-Leet=code-Q!";
		String output = "Qedo1ct-eeLg=ntse-T!";
		Assert.assertEquals(reverseLetters(s), output);
	}
	
	@Test
	public void example4() {		
		String s = "mno54pk";
		String output = "kpo54nm";
		Assert.assertEquals(reverseLetters(s), output);
	}
	
	@Test
	public void example5() {		
		String s = "-165";
		String output = "-165";
		Assert.assertEquals(reverseLetters(s), output);
	}

	/*
	 
	 Pseudo code :
	 
	 1. Create two pointers
	 2. Traverse while left < right
	 3. check if left and right has alphabetic characters
	 4. If yes swap and increment left and decrement right
	 5. If it is alphabetic characters then increment left and decrement right until it finds alphabetic characters
	 6. Return the value of character array
	*/
	
	public String reverseLetters(String s) {
		
		int left=0,right=s.length()-1; 
		
        char[] ch = s.toCharArray();  
    
        while(left<right) {   
        	       	
            if(Character.isAlphabetic(ch[left]) && Character.isAlphabetic(ch[right])){  
                char temp = ch[left];   
                ch[left++] = ch[right];  
                ch[right--] = temp;   
            } 
            else if(!Character.isAlphabetic(ch[left])) left++;  
               else right--;   
            }        
        
        return String.valueOf(ch);   
	}
}
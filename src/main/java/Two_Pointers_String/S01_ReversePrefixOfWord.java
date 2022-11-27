package Two_Pointers_String;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S01_ReversePrefixOfWord {
		
	/* Leetcode_2000 :  https://leetcode.com/problems/reverse-prefix-of-word/
	 	
	 	Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and 
	 	ends at the index of the first occurrence of ch (inclusive). 
	 	If the character ch does not exist in word, do nothing.

	 	Return the resulting string.
	 	
	 	Constraints:

		  1 <= word.length <= 250
		  word consists of lowercase English letters.
	      ch is a lowercase English letter.
	 */
	
	@Test   //check for empty string
	public void example1() {
		String word = "abcdefds";		
		char ch = 'd';
		String output = "dcbaefds";	
		Assert.assertEquals(reversePrefix(word,ch), output);
	}
	
	@Test
	public void example2() {
		String word = "abcd";		
		char ch = 'g';
		String output = "abcd";	
		Assert.assertEquals(reversePrefix(word,ch), output);
	}
	
	@Test
	public void example3() {
		String word = "sabc";		
		char ch = 's';
		String output = "sabc";	
		Assert.assertEquals(reversePrefix(word,ch), output);
	}

	
	@Test
	public void example4() {
		String word = "xyxzxe";		
		char ch = 'z';
		String output = "zxyxxe";	
		Assert.assertEquals(reversePrefix(word,ch), output);
	}
	
	@Test
	public void example5() {
		String word = "abcd";		
		char ch = ' ';
		String output = "abcd";	
		Assert.assertEquals(reversePrefix(word,ch), output);
	}

  /* Pseudo Code 
	 
	   1. Convert given word into charArray
	   2. Create pointers left=0, right=0, index=0 Using a pointer, find the first index where ch occurs
	   3. If length  is more than the array length or not matching found return word
	   4. Find first occurrence of ch in the array to find the index value
	   5. Assign index to left and traverse if right < left
       6. Then swap and increment and  return the character array as string

  */	
		
	public String reversePrefix(String word, char ch) {
		
		
		char[] charr = word.toCharArray();
		int left =0, right =0, index =0;
		char temp ='0';
		
		if(left>=charr.length && charr[left] != ch) return word; 
		
		while(left<charr.length) {  
			if(charr[left] == ch) {
				index = left;
				break; }
			
			else left++;
		}		
		
		left = index;
		while(right<left){  
            temp = charr[right];
            charr[right++] = charr[left];
            charr[left--] = temp;
        }
		
		return String.valueOf(charr);
	}
}


  /* public String reversePrefix(String word, char ch) {

		char[] s = word.toCharArray();

		int left =0, right =0;

		while(left<s.length && right<s.length) {

			if(s[right] == ch) {
				while(left<=right) {

					char temp = s[right];
					s[right--] = s[left];
					s[left++] = temp;
				}
				break;
			}
			else
				right++;
		}
		return String.valueOf(s);

	}
} */


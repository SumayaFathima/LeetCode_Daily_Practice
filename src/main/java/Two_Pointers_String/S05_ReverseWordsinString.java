package Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S05_ReverseWordsinString { 
	
	/* Leetcode_557 :  https://leetcode.com/problems/reverse-words-in-a-string-iii/
 	
 	Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 	
 	Constraints:

		1 <= s.length <= 5 * 10^4
		s contains printable ASCII characters.
		s does not contain any leading or trailing spaces.
		There is at least one word in s.
		All the words in s are separated by a single space.
	*/
	
	@Test
	public void example1() {
		String s = "Let's take LeetCode contest";
		String output = "s'teL ekat edoCteeL tsetnoc";
		Assert.assertEquals(reverseWords(s), output);
	}
	
	@Test
	public void example2() {
		String s = "God Ding";
		String output = "doG gniD";
		Assert.assertEquals(reverseWords(s), output);
	}
	
	@Test
	public void example3(){
	    String s="*&God(^ $save@# %the#@ )%king^@";
	    String output ="^(doG&* #@evas$ @#eht% @^gnik%)";
	    Assert.assertEquals(reverseWords(s), output);
	}
	
	@Test
	public void example5(){
	    String s="m  N";
	    String output ="m N";
	    Assert.assertEquals(reverseWords(s), output);
	}

	/* Pseudo code :
	 
		1. Split the string 
		2. Traverse while i< split.length
		3. Iterate every word and convert the word to character array
		4. Create two pointers left =0 and right = word.length()-1	
		5. Traverse while left < right, swap and increment left and decrement right
		6. Concat the reverse word in a string with single space and trim 
		7. Return the new string
	 */
	public String reverseWords(String s) {
		
		String[] split = s.split(" ");
		String endResult = " ";
		
		for(int i=0; i< split.length; i++) {
			
			String word = split[i];
			char[] ch = word.toCharArray();
			
			int left =0, right = word.length()-1;		
	
		while(left<right) {
							
				char temp = ch[right];
				ch[right] = ch[left];
			    ch[left] = temp;
			    left++;
			    right--;
			}				
		endResult = endResult += new String(ch) + " ";
	}		
		return endResult.trim();
	}
}
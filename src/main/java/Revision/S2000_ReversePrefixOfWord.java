package Revision;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S2000_ReversePrefixOfWord {

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
	 
	   - Convert given word into charArray
	   - Create pointers left=0, right=0
	   - find the first index where ch occurs else right++
	   - once found, traverse while left<= right and swap all nos and break
	   - Convert the char[] to string and return the same

  */
    public String reversePrefix(String word, char ch) {

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
}


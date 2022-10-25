package Two_Pointers_String;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S06_ReverseVowels {

	 /* Leetcode_345 : leetcode.com/problems/reverse-vowels-of-a-string/
	  
			Given a string s, reverse only all the vowels in the string and return it.
			The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
			
		Constraints:
			1 <= s.length <= 3 * 10^5
			s consist of printable ASCII characters
	 */
	
	@Test
	public void example1() {		
		String s ="hello";
		String output = "holle";
		Assert.assertEquals(reverseVowels(s), output);
	}
	
	@Test
	public void example2(){
		String s="leetcode";
		String output = "leotcede";
		Assert.assertEquals(reverseVowels(s), output);
	}

	@Test
		public void example3(){
		String s="s";
		String output = "s";
		Assert.assertEquals(reverseVowels(s), output);
	}
	
	@Test
	public void example4() {
		
		String s ="LEet cOde";
		String output = "LeOt cedE";
		Assert.assertEquals(reverseVowels(s), output);
	}
	
	/*
	   Pseudo code:

		  1. Create Set of Integers and add all the values in the set
		  2. Convert the string to character array
	      3. Create two pointers left = 0, right = ch.length - 1;
		  4. Traverse while left<right 
		  5. If both the end values matches with vowel then swap and increment both
	      6. if left doesn't matches with vowel, increment left
		  7. if right doesn't matches with vowel, increment right	
		  8. Return the value of character array
	 */
	  
	 public String reverseVowels(String s) {
		
		    if (s == null) return s;
		    
		    Set<Object> set = new HashSet<Object>(); 
		    {
		        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
		        set.add('A'); set.add('E'); set.add('I'); set.add('O'); set.add('U');
		    };
		    
		    char[] ch = s.toCharArray();
		    int left = 0, right = ch.length - 1;

		    	while (left < right) {		    	
			    	
			        if (left < right && !set.contains(ch[left])) left++;
			        else if (left < right && !set.contains(ch[right])) right--;
			        else if (left < right && set.contains(ch[right])) {
			            char tmp = ch[left];
			            ch[left] = ch[right];
			            ch[right] = tmp;
			            left++;
			            right--;
			        }
			    }
			    return String.valueOf(ch);
			}
	}
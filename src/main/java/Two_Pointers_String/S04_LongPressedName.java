package Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S04_LongPressedName {

	/*  Leetcode_925 : https://leetcode.com/problems/long-pressed-name/
	 
	    Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, 
	    and the character will be typed 1 or more times.   
	    
		You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none)
		being long pressed.
		
	 */
	
	
	@Test
	public void example1() {
		String name = "alex";
		String typed = "aaleex";
		Assert.assertEquals(islongpressedName(name, typed), true);
	}

	@Test
	public void example2() {
		String name = "saeed";
		String typed = "ssaaedd";
		Assert.assertEquals(islongpressedName(name, typed), false);
	}

	@Test
	public void example3() {
		String name = "saeed";
		String typed = "saaeeed";
		Assert.assertEquals(islongpressedName(name, typed), true);
	}

	@Test
	public void example4() {
		String name = "saeed";
		String typed = "s";
		Assert.assertEquals(islongpressedName(name, typed), false);
	}

	@Test
	public void example5() {
		String name = "sad";
		String typed = "ssaadd";
		Assert.assertEquals(islongpressedName(name, typed), true);
	}

	@Test
	public void example6() {
		String name = "alex";
		String typed = "aaleexa";
		Assert.assertEquals(islongpressedName(name, typed), false);
	}

	@Test
	public void example7() {
		String name = "alex";
		String typed = "aaleexeex";
		Assert.assertEquals(islongpressedName(name, typed), false);
	}

	@Test
	public void example8() {
		String name = "alex";
		String typed = "aaleelx";
		Assert.assertEquals(islongpressedName(name, typed), false);
	}
	
	@Test
	public void example9() {
		String name = "bdad";
		String typed = "bbbd";
		Assert.assertEquals(islongpressedName(name, typed), false);
	}
	
	/* Pseudo code:
	  1.Create two pointers left=0, right=0;
	  2.Convert word into charArray
	  3.If length of first word is less than second, return false
	  4.If first or last index of both array doesn't match, return false;
	  5. Traverse while left< name.length() and  right < typed.length()
	  6. If p1 = p2, increment both
	  7. else check if p2[right] == p2[right-1] then increment right. else return false
	  8. If(left < name.length() && right == typed.length()) return false;
	  9. If first word is complete and second word still has some characters left, 
	  10. then check for the condition if p2[right] == p2[right-1] , then increment right alone else return false
	  11. Return true by default	  
	
	*/
		

	public static boolean islongpressedName(String name, String typed) {
		
		int left=0, right =0;
		
		char[] p1 = name.toCharArray();
		char[] p2 = typed.toCharArray();
																																																																				
		if(name.length() > typed.length()) return false;
		if(p1[0] != p2[0] || (p1[name.length()-1] !=  p2[typed.length()-1] )) return false;
		
		while(left< name.length() && right < typed.length()) {
			
			if(p1[left] == p2[right]) {
				left++;
				right++;
			}			
			else {				
				
				if(p2[right-1] ==  p2[right]) {					
					right++; }
				else 
				return false;	}				  
		}
		
		if(left < name.length() && right == typed.length()) return false;
		
		else {
	     while(right < typed.length()){
	            if(p2[right] == p2[right-1])
	                right++;	            
	            else
	                return false;
	     } }
	     
	    return true;
	}
} 
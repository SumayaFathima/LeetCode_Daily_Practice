package Two_Pointers_Array;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S04_AssignCookies {

	 /* Leetcode_455 : leetcode.com/problems/assign-cookies/
	  
	Assume you are an awesome parent and want to give your children some cookies.
	But, you should give each child at most one cookie.
	
	Each child i has a greed factor g[i], which is the minimum size of a cookie
	that the child will be content with; and each cookie j has a size s[j].
	If s[j] >= g[i], we can assign the cookie j to the child i, and the child i
	will be content. Your goal is to maximize the number of your content children
	and output the maximum number.
	
	Constraints:

	1 <= g.length <= 3 * 104
	0 <= s.length <= 3 * 104
	1 <= g[i], s[j] <= 231 - 1
	
	*/
	
	
	@Test
	public void example1() {
		int[] g = {1,2,3};
		int[] s = {3,4,5};
		int output = 3;
        Assert.assertEquals(findContentChildren(g, s), output);
	}
	
	@Test
	public void example2() {
		int[] g = {1};
		int[] s = {3,4,5};
		int output = 1;
        Assert.assertEquals(findContentChildren(g, s), output);
	}
	
	@Test
	public void example3() {
		int[] g = {1,2,3};
		int[] s = {3};
		int output = 1;
        Assert.assertEquals(findContentChildren(g, s), output);
	}

    @Test
    public void example5(){
        int[] g={1};
        int[] s={};
        int output = 0;
        Assert.assertEquals(findContentChildren(g, s), output);
    }
    
/* Pseudo Code :

    1. Check if array is empty or not, if yes return 0
    2. Create two pointers p1 = 0 and p2=0
    3. Traversal array to each element to match s[j] >= g[i] 
    4. If s[j] >= g[i], we can assign the cookie and the child will be content, increment p1 and p2
    5. Else increment p1 and move to next cookie
    6. Return the content cookie count */
	
	public static int findContentChildren(int[] g, int[] s) 
	{
		
		if(g.length<1 && s.length<1) return 0;
		 
		Arrays.sort(g);
        Arrays.sort(s);

		int p1=0, p2 =0;
		
		while(p1 < s.length && p2< g.length) {
			
			if(g[p2] <= s[p1])  {
				g[p2] = s[p1];
				p1++;
				p2++; }
		  	else
				p1++;  }

		return p2;
        
        }	
}


 /*	public int findContentChildren(int[] g, int[] s) {

		Arrays.sort(s);
		Arrays.sort(g);
		int count =0;

		for(int i=0, j=0; j<g.length && i<s.length; i++) {

			if(s[i]>= g[j]) {
				j++;
				count++;
			}
		} return count;
	}
} */

 /*	public int findContentChildren(int[] g, int[] s) {
  		Arrays.sort(s);
		Arrays.sort(g);
		int i=0, j=0, count=0;

			while(i<g.length && j<s.length){
				if(s[j]>= g[i]) {
					i++;
					j++;
					count++;
				}
				else
				j++;
			} return count;
		}
	} */

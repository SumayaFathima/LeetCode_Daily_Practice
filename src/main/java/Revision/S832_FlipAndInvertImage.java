package Revision;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S832_FlipAndInvertImage {
	

	@Test
	public void example1() {
		
		int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
		int[][] output = {{1,0,0},{0,1,0},{1,1,1}};
		Assert.assertEquals(flipAndInvertImage(image), output);
	}
	
	@Test
	public void example2() {
		
		int[][] image = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		int[][] output = {{1,1,0,0},{0,1,1,0},{0,0,0,1},{1,0,1,0}};
		Assert.assertEquals(flipAndInvertImage(image), output);
	}
	
	@Test
	public void example3() {
		
		int[][] image = {{0,0},{1,1}};
		int[][] output = {{1,1},{0,0}};
		Assert.assertEquals(flipAndInvertImage(image), output);
	}
	
	/* Pseudo code:

	 	- Traverse from 0 rill image length
	 	- Create two pointers left=0, right= image.length-1
	 	- Traverse while left<= right through each row
	 	- if left == right then invert to 1 if 0 else to 1
	 	- Increment left and decrement right
	 	- Return the flipped image array
	*/


	public int[][] flipAndInvertImage(int[][] image) {

		for(int i=0;i<image.length;i++)
		{
			int left=0,right=image.length-1;
			while(left<=right)
			{
				if(image[i][left]==image[i][right])
				{
					if(image[i][left]==0)
					{
						image[i][left]=1;
						image[i][right]=1;
					}
					else
					{
						image[i][left]=0;
						image[i][right]=0;
					}
				}
				left++;
				right--;
			}
		}
		return image;
	}
}
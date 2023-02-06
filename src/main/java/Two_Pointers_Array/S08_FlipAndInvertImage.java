package Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S08_FlipAndInvertImage {	
	
	/* Leetcode_832 : https://leetcode.com/problems/flipping-an-image/
	 
		Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
		To flip an image horizontally means that each row of the image is reversed.

			For example, flipping [1,1,0] horizontally results in [0,1,1].
			 			To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

			For example, inverting [0,1,1] results in [1,0,0].
			
		Constraints:

		  n == image.length
		  n == image[i].length
	      1 <= n <= 20
		  images[i][j] is either 0 or 1.	
	*/
	
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
	 	
	 	1. Create two pointers left=0, right= image.length-1
	 	2. Traverse through the loop to reverse the array element in image array
	 	3. Traverse through the loop to convert 0 to 1 and 1 to 0
	 	4. Return the flipped image array
	 	
	*/

	/* public static int[][] flipAndInvertImage(int[][] image) {

		for(int i=0; i<image.length; i++) {

			int left=0, right= image.length-1;

			while(left < right) {

				int temp = image[i][left];
				image[i][left] = image[i][right];
				image[i][right] = temp;
				left++;
				right--;
			}
		}

		for(int i=0; i<image.length; i++) {

			for(int j = 0; j<image.length; j++){

				if(image[i][j] == 0 )
					image[i][j] = 1;

				else if(image[i][j] == 1 )
					image[i][j] = 0;
			}
		}
		return image;
	}
} */

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
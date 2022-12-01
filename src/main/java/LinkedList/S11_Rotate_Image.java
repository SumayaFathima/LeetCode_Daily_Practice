package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S11_Rotate_Image {

    // Leetcode_ 48 : https://leetcode.com/problems/rotate-image/
    @Test
    public void example1() {
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] output = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        //Assert.assertEquals(rotate(input), output);
    }

    @Test
    public void example2() {
        int[][] input = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] output = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        //Assert.assertEquals(rotate(input), output);
    }

    @Test
    public void example3() {
        int[][] input = {{1, 2}, {4, 5}};
        int[][] output = {{4, 1}, {5, 2}};
        //Assert.assertEquals(rotate(input), output);
    }

    /* Pseudo code :

        1. Place first row of matrix in first column of matrix and so on
        2. Then reverse each row
     */

    //TC : O(N^2)

 /*   public int[][] rotate(int[][] matrix) {

        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
        return matrix;
    }
} */


/* Pseudo code :

   1. For each array in matrix, reverse the elements of matrix[i]
   2. Create 4 pointers l1,l2=0 and r1,r2=matrix.length-1
   3. Swap the last values of each matrix[i] and place it along the matrix[0]
   4. When current element is reached, reset the pointers and start the step 3 from second last element and matrix[1]
   5. Continue till l1<r1
   6. Return matrix

 */

    public int[][] rotateImage(int[][] matrix) {
        int len=matrix.length-1;
        for(int i=0;i<=len;i++){
            int left=0,right=len;
            while(left<right){
                int temp = matrix[i][left];
                matrix[i][left++] = matrix[i][right];
                matrix[i][right--] = temp;
            }
        }
        int l1=0,l2=0;
        int r1=len,r2=len;

        while(l1<r1){
            int temp = matrix[l1][l2];
            matrix[l1][l2] = matrix[r1][r2];
            matrix[r1][r2] = temp;
            l2++;
            r1--;

            if(l1==r1) {
                l1++;
                l2=0;
                r1=len;
                r2--;
            }
        }
        return matrix;
    }
}
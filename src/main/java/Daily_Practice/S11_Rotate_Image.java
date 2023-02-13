package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S11_Rotate_Image {

    // Leetcode_ 48 : https://leetcode.com/problems/rotate-image/
    @Test
    public void example1() {
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] output = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        rotate(input);
        Assert.assertEquals(input, output);
    }

    @Test
    public void example2() {
        int[][] input = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] output = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        rotate(input);
        Assert.assertEquals(input, output);
    }

    @Test
    public void example3() {
        int[][] input = {{1, 2}, {4, 5}};
        int[][] output = {{4, 1}, {5, 2}};
        rotate(input);
        Assert.assertEquals(input, output);
    }

    /* Pseudo code :

        1. Tranpose the matrix by placing first row of matrix in first column and so on
        2. Then reverse each row
     */

    //TC : O(N^2)

    public void rotate(int[][] matrix) {

        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix.length/2;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = temp;
            }
        }
    }
}
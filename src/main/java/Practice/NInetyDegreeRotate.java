package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class NInetyDegreeRotate {

    // https://leetcode.ca/2021-07-23-1886-Determine-Whether-Matrix-Can-Be-Obtained-By-Rotation/#:~:text=Given%20two%20n%20x%20n%20binary%20matrices,degree%20increments%2C%20or%20false%20otherwise.&text=Explanation%3A%20We%20can%20rotate%20mat,to%20make%20mat%20equal%20target.&text=Explanation%3A%20It%20is%20impossible%20to,to%20target%20by%20rotating%20mat


    @Test
    public void example1() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] target = {{9,8,7}, {6,5,4},{3,2,1}};
        boolean output = true;
        Assert.assertEquals(rotate(matrix, target), output);
    }

    @Test
    public void example2() {
        int[][] matrix = {{0,0},{0,1}};
        int[][] target = {{0,0},{1,0}};
        boolean output = true;
        Assert.assertEquals(rotate(matrix, target), output);
    }

    @Test
    public void example3() {
        int[][] matrix = {{0,1},{1,1}};
        int[][] target = {{1,0},{0,1}};
        boolean output = false;
        Assert.assertEquals(rotate(matrix, target), output);
    }

    @Test
    public void example4() {
        int[][] matrix = {{1}};
        int[][] target = {{1}};
        boolean output = true;
        Assert.assertEquals(rotate(matrix, target), output);
    }

    @Test
    public void example5() {
        int[][] matrix = {{0,0,0,1},{0,1,0,0},{1,1,1,0}, {0,0,1,1}};
        int[][] target = {{0,1,0,0},{0,1,1,0},{1,1,0,0},{1,0,0,1}};
        boolean output = true;
        Assert.assertEquals(rotate(matrix, target), output);
    }

    /*
        Pseudo code:
    1. Traverse from 0 to 3 - for 90, 180 and 270
    2. if values of matrix and target matches, return true
    3. else do transpose and rotate until it matches target and condition fails
    4. return false if it doesnt matches target

     */
    public boolean rotate(int[][] matrix, int[][] target) {
            for(int i=0;i<=3;i++) {
                if(Arrays.deepEquals(matrix,target)) return true;
                transpose(matrix);
                rotate(matrix);
            }
            return false;
        }

        public void transpose(int[][] matrix) {
            for(int i=0;i<matrix.length;i++) {
                for(int j=i+1;j<matrix.length;j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
       public void rotate(int[][] matrix) {
            for(int i=0;i<matrix.length;i++) {
                for(int j=0;j<matrix.length/2;j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length-j-1];
                    matrix[i][matrix.length-j-1] = temp;
                }
            }
        }
    }
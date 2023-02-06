package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class revision {

    @Test
    public void example1() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] target = {{9,8,7}, {6,5,4},{3,2,1}};
        boolean output = true;
        Assert.assertEquals(rotate(matrix, target), output);
    }

    public boolean rotate(int[][] matrix, int[][] target) {

        for(int i=0; i<=3; i++) {
            if(Arrays.deepEquals(matrix, target)) return true;
            transpose(matrix);
            rotate(matrix);
        }
        return false;
    }

    public void transpose(int[][] matrix) {

        for(int i=0; i<matrix.length; i++) {
            for(int j=i+1; j<matrix.length; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public void rotate(int[][] matrix) {

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j< matrix.length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = temp;
            }
        }
    }
}

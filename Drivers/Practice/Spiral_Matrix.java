package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {

    @Test
    public void example1() {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        int[] output = {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
        Assert.assertEquals(spiral(matrix), output);

    }

    public List<Integer> spiral(int[][] matrix) {

        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1, size = matrix[0].length * matrix.length;;
        List<Integer> list = new ArrayList<>();

        while (list.size() < size) {

            for (int i = left; i <= right && list.size() < size; i++) {

                list.add(matrix[top][i]);

            }
            top++;

            for (int i = top; i <= bottom && list.size() < size; i++) {

                list.add(matrix[i][right]);
            }
            right--;

            for (int i = right; i >= left && list.size() < size; i--) {

                list.add(matrix[bottom][i]);
            }

            bottom--;

            for (int i = bottom; i >= top && list.size() < size; i--) {

                list.add(matrix[i][left]);
            }

            left++;

        }
        return list;
    }
}

package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class S14_Valid_Sudoku {

    @Test
    public void example1() {
        char[][] input = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean output = true;
        Assert.assertEquals(isValidSudoku(input), output);
    }

    /* Pseudo code :

        1. Create a set
        2. Check for i and j value if it is not equal to '.'
        3. if yes then save the row index and value in a steing
        4. Then column index and value
        5.
        6. check if set doesnt contain the either of the value, if yes return false
        7. Return true by default
     */

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String row = i + "" + board[i][j];
                    String column =  j + "" + board[i][j];


                    if (!set.add(row) || !set.add(column) || !set.add(box))
                        return false;
                }
            }
        }
        return true;
    }
}

package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {

    @Test
    public void example1() {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] output = {{1, 6}, {8, 10}, {15, 18}};
        Assert.assertEquals(merge(intervals), output);
    }

    public int[][] merge(int[][] intervals) {

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int[] temp = intervals[0];
        list.add(temp);

        for (int[] fr : intervals) {

            if (temp[1] >= fr[0]) {
                if(temp[1] < fr[1])
                    temp[1] = fr[1];
            } else {
                list.add(fr);
                temp = fr;
            }
        }

        int[][] res = list.toArray(new int[list.size()][]);
        return res;
    }
}
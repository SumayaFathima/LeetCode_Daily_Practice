package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class prve {


    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] > b[0]) return 1;
            else return -1;
        });

        List<int[]> lst = new ArrayList<>();
        int[] current_Interval = intervals[0];
        lst.add(current_Interval);

        for (int[] interval : intervals) {
            int current_start = current_Interval[0];
            int current_end = current_Interval[1];
            int next_start = interval[0];
            int next_end = interval[1];

            if (current_end >= next_start) {
                current_Interval[1] = Math.max(current_end, next_end);
            } else {
                current_Interval = interval;
                lst.add(current_Interval);
            }
            System.out.println(Arrays.toString(lst.get(0)));
        }
        return lst.toArray(new int[lst.size()][]);
    }
}

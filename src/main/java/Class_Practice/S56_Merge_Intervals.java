package Class_Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S56_Merge_Intervals {
    @Test
    public void example1() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] output = {{1,6},{8,10},{15,18}};;
        Assert.assertEquals(merge(intervals), output);
    }

    @Test
    public void example2() {
        int[][] intervals = {{1,4},{4,5}};
        int[][] output = {{1,5}};
        Assert.assertEquals(merge(intervals), output);
    }

    @Test
    public void example3() {
        int[][] intervals = {{10,20}, {30,40}};
        int[][] output = {{10,20}, {30,40}};;
        Assert.assertEquals(merge(intervals), output);
    }

    @Test
    public void example4() {
        int[][] intervals = {{20,22},{21,25}};
        int[][] output = {{20,25}};;
        Assert.assertEquals(merge(intervals), output);
    }

    /*  Pseudo code :
    - Sort the array
    - Create a list and add first value to a currmeeting variable and then add to list
    - A for loop traversing to each element
    - Check if second value of that currmeeting value  >= first value of array, then find the max of it and change the second value
      of currmeeting
    - else make interval as currmeeting and add the value to list
    - convert list to 2D array and return the result
     */
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> list = new ArrayList<>();

        int[] currmeeting = intervals[0];
        list.add(currmeeting);

        for(int[] interval : intervals) {
            if(currmeeting[1] >= interval[0]) {
                currmeeting[1] = Math.max(currmeeting[1], interval[1]);
            }
            else {
                currmeeting = interval;
                list.add(currmeeting);
            }
        }

        return list.toArray(new int[list.size()][]);

    }
}
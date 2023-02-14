package Daily_Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {
    @Test
    public void example1() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        boolean output = false;
        Assert.assertEquals(merge(intervals), output);
    }

    @Test
    public void example2() {
        int[][] intervals = {{1,5},{5,10}};
        boolean output = false;
        Assert.assertEquals(merge(intervals), output);
    }

    @Test
    public void example3() {
        int[][] intervals = {{10,20}, {30,40}};
        boolean output = false;
        Assert.assertEquals(merge(intervals), output);
    }

    @Test
    public void example4() {
        int[][] intervals = {{20,22},{21,25}};
        boolean output = false;
        Assert.assertEquals(merge(intervals), output);
    }

    /*  Pseudo code :
    - Sort the array
    - Create a list and add first value to a currmeeting variable and then add to list
    - A for loop traversing to each element
    - Check if second value of that currmeeting value  >= first value of array, if yes return false
    - else make interval as currmeeting and add the value to list
    - if list size == array length then return true
    - return false by default
     */
    public boolean merge(int[][] intervals) {

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> list = new ArrayList<>();

        int[] currmeeting = intervals[0];
        list.add(currmeeting);

        for(int[] interval : intervals) {
            if(currmeeting[1] >= interval[0]) {
                return false;
            }
            else {
                currmeeting = interval;
                list.add(currmeeting);
            }
        }

        if(list.size() == intervals.length) return true;
        return false;
    }
}
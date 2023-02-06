package HackerRank;

import java.util.Collections;
import java.util.List;

public class MinimumAndMaximum {

    //https://www.hackerrank.com/challenges/mini-max-sum/problem

    public static void miniMaxSum(List<Integer> arr) {

        Collections.sort(arr);
        int pointer =0;
        long sum =0;
        while(pointer < arr.size()-1) {
            sum += arr.get(pointer++);
        }
        System.out.print(sum);

        sum += arr.get(pointer) - arr.get(pointer - pointer);

        System.out.print(" " + sum);
    }
}
package HackerRank;

import java.util.List;

public class DiagonalDifference {

    //https://www.hackerrank.com/challenges/diagonal-difference/problem

    public static int diagonalDifference(List<List<Integer>> arr) {

        int sumleft =0, sumright =0;
        for(int i=0; i< arr.size(); i++) {

            sumleft += arr.get(i).get(i);
            sumright += arr.get(i).get(arr.size()-1-i);
        }

        return Math.abs(sumleft - sumright);
    }
}


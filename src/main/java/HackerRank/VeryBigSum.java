package HackerRank;

import java.util.List;

public class VeryBigSum {

    // https://www.hackerrank.com/challenges/a-very-big-sum/problem

    public static long aVeryBigSum(List<Long> ar) {

        if(ar.size() == 1) return ar.get(0);

        long sum =0;

        for(int i =0; i<ar.size(); i++) {

            sum += ar.get(i);
        }

        return sum;
    }
}


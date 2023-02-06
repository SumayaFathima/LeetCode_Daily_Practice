package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class Triplets {

    // https://www.hackerrank.com/challenges/compare-the-triplets/problem


    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        List<Integer> list = new ArrayList<>();

        int a1count =0, b1count =0;
        for(int i=0; i < a.size(); i++) {

            if (a.get(i) != b.get(i)) {
                if (a.get(i) > b.get(i)) a1count++;
                else b1count++;
            }
        }
        list.add(a1count);
        list.add(b1count);
        return list;
    }
}
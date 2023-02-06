package HackerRank;

import java.util.List;

public class proportionOfValues {

    //https://www.hackerrank.com/challenges/plus-minus/

    public static void plusMinus(List<Integer> arr) {

        int pos = 0, neg =0, zero =0;

        for(int i=0; i<arr.size(); i++) {

            if(arr.get(i) == 0) zero++;
            else if(arr.get(i) >= 1) pos++;
            else neg++;
        }
        System.out.println((double) pos/arr.size());
        System.out.println((double) neg/arr.size());
        System.out.println((double) zero/arr.size());
    }
}
package HackerRank;

import java.util.HashMap;
import java.util.List;

public class Birthday_cake {
    //https://www.hackerrank.com/challenges/birthday-cake-candles/

    public static int birthdayCakeCandles(List<Integer> candles) {

        int max = 0;
        int count = 0;

        for(int i =0; i < candles.size(); i++){

            if(candles.get(i) > max){
                count = 1;
                max = candles.get(i);
            }else if(candles.get(i) == max){
                count++;
            }
        }
        return count;
    }
}

       /* if(candles.size() ==1) return candles.get(0);

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int fr : candles) {
            if(map.containsKey(fr)) {
                map.put(fr, map.getOrDefault(fr, 0)+1);
            } else
                map.put(fr, 1);
        }
        int maximum = Integer.MIN_VALUE;
        for(int i=0; i<candles.size(); i++) {
            maximum = Math.max(maximum, candles.get(i));
        }

        return map.get(maximum);

    }
} */

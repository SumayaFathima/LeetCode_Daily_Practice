package HackerRank;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class TimeConversion {

    //https://www.hackerrank.com/challenges/time-conversion/

    @Test
    public void example1() {
        String s = "07:05:45PM";
        String output = "19:05:45";
        Assert.assertEquals(timeConversion(s), output);
    }

    @Test
    public void example2() {
        String s = "19:05:45";
        String output = "19:05:45";
        Assert.assertEquals(timeConversion(s), output);
    }

    public static String timeConversion(String s) {

        if (s == "12:00:00AM") return "00:00:00";

       // s.replace("AM", " ");
        String ss = s.replace("PM", " ");

        String[] str = s.split(":");

        int in = Integer.valueOf(str[0]) + 12;
        String st = Integer.toString(in);

        return st + ":" + str[1] + ":" + str[2];
    }
}

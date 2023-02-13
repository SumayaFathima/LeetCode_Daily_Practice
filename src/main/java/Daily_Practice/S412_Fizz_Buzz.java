package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S412_Fizz_Buzz {

    @Test
    public void example1() {
        int nums = 3;
        List<String> output = Arrays.asList(new String[]{"1", "2", "Fizz"});
        Assert.assertEquals(fizzBuzz(nums), output);
    }

    /*
    A loop from 1 till n
    if i%3 ==0 and i%5 ==0 then add Fizzbuzz in list
    if i%3 ==0 then add Fizz in list
    if i%5 ==0 then add Buzz in list
    else convert to string and add i in list
    return list
     */
    public List<String> fizzBuzz(int n) {

        List list = new ArrayList();

        for(int i=1; i<= n; i++) {

            if(i%3 ==0 && i%5 ==0)
                list.add("FizzBuzz");

            else if(i%3==0)
                list.add("Fizz");

            else if(i%5==0)
                list.add("Buzz");

            else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}

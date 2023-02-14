package Daily_Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashMap;

public class S12_Integer_to_Roman {

    @Test
    public void example1() {
        int num = 3;
        String output = "III";
        Assert.assertEquals(intToRoman(num), output);
    }

    @Test
    public void example2() {
        int num = 58;
        String output = "LVIII";
        Assert.assertEquals(intToRoman(num), output);
    }

    @Test
    public void example3() {
        int num = 1994;
        String output = "MCMXCIV";
        Assert.assertEquals(intToRoman(num), output);
    }

    @Test
    public void example4() {
        int num = 1000;
        String output = "M";
        Assert.assertEquals(intToRoman(num), output);
    }

    /*
    - Create a hashmap and put all numbers with roman numbers
    - create an array and all numbers
    - Traverse from 0 till array length
    - if array num > given number, skip  else break
    - Then add respective roman numerals to a new string and substract num by array value
    - return str
     */
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");

        int[] arr = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String str = "";
        int i;

        while(num > 0){
            for(i=0;i<arr.length;i++){
                if(arr[i] > num){
                    continue;
                }
                else{
                    break;
                }
            }
            str += map.get(arr[i]);
            num -= arr[i];
        }
        return str;
    }
}


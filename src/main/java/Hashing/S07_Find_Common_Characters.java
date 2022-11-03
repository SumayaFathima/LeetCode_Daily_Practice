package Hashing;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class S07_Find_Common_Characters {

    @Test
    public void example1() {

        String[] words = {"bella","label","roller"};  // e,l,l
        System.out.println(commonChars(words));
    }

    @Test
    public void example2() {

        String[] words = {"cool","lock","cook"}; //c,o
        System.out.println(commonChars(words));
    }

    @Test
    public void example3() {

        String[] words = {" "," ","a"};  // []
        System.out.println(commonChars(words));
    }

    @Test
    public void example4() {

        String[] words = {"a","b","c"};  //[]
        System.out.println(commonChars(words));
    }

    @Test
    public void example5() {

        String[] words = {"aa","aaa","aaaa"};  //a,a
        System.out.println(commonChars(words));
    }

    /* Pseudo code:

       1. Create an ArrayList of String type
       2. Declare a Hashmap of char and int
       3. Store the first word of the array in a string
       4. Loop1 :
            * Traverse each character of first word and place in map in key and value should have 1
            * If the character repeats then add the frequency
       5. Loop2 :
            * Iterate over rest of the words and compare the frequency
            * If any character count is less than the loop1 only then update the frequency in map
       6. Loop3 :
            * Map has characters and number of times it is there in each words
            * If the count of each character is > 0 then convert the character to String and add to list
       7. Return the list of Strings

     */
    public List<String> commonChars(String[] words) {

        List<String> list = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();

        String word1 = words[0];

        for(int i =0;i<word1.length();i++){
            if(map.containsKey(word1.charAt(i))){
                map.put(word1.charAt(i),map.get(word1.charAt(i))+1);
            }else{
                map.put(word1.charAt(i),1);
            }
        }

        for(Character ch :map.keySet()){
            for(int i =1;i<words.length;i++){
                String current = words[i];
                int count=0;
                for(int j =0;j<current.length();j++){
                    if(ch == current.charAt(j)){
                        count ++;
                    }
                }
                if(map.containsKey(ch) && map.get(ch) > count){
                    map.put(ch,count);
                }
            }
        }

        for(Character ch :map.keySet()){
            if(map.get(ch) > 0) {
                for (int i = 0; i < map.get(ch); i++) {
                    list.add(ch.toString());
                }
            }
        }   return list;
    }
}
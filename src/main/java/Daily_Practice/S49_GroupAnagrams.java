package Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class S49_GroupAnagrams {

    @Test
    public void example1() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    @Test
    public void example2() {
        String[] strs = new String[]{"sun", "moon", "star", "stars"};
        System.out.println(groupAnagrams(strs));
    }

    @Test
    public void example3() {
        String[] strs = new String[]{"a"};
        System.out.println(groupAnagrams(strs));
    }

    @Test
    public void example4() {
        String[] strs = new String[]{" "};
        System.out.println(groupAnagrams(strs));
    }

    @Test
    public void example5() {
        String[] strs = new String[]{"a", "b", "c", "d" , "b"};
        System.out.println(groupAnagrams(strs));
    }


    /*
    Pseudo code :
        - Create a hashmap with String and ArrayList<String>>
        - Convert each string to charArray and sort
        - Iterate each element and check if it is in map
        - if yes - create a list and add in list then put in map
        - if no - create a new list and add in list then put in map
        - Add the result to a new list and return
     */
    public List<List<String>> groupAnagrams(String[] input) {

        List<List<String>> resultlist = new ArrayList();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String str : input) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);

            String ss = new String(ch);
            if(map.containsKey(ss)) {
                ArrayList<String> list = map.get(ss);
                list.add(str);
                map.put(ss, list);
            }
            else {
                ArrayList<String> list1 = new ArrayList();
                list1.add(str);
                map.put(ss, list1);
            }
        }

        for(String Key : map.keySet()) {
            resultlist.add(new ArrayList(map.get(Key)));
        }

        return resultlist;
    }
}
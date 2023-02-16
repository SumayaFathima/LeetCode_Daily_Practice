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
        String[] strs = new String[]{""};
        System.out.println(groupAnagrams(strs));
    }

    @Test
    public void example3() {
        String[] strs = new String[]{"a"};
        System.out.println(groupAnagrams(strs));
    }


    /*
    Pseudo code :
        - Create a hashmap with String and ArrayList<String>>
        - Convert to charArray and sort
        - Iterate each element and check if it is in map
        - if yes - create a list and add in list then put in map
        - if no - create a new list and add in list then put in map
        - Add the result to a new list and return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> newlist = new ArrayList();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);

            String ss = new String(ch);
            if(map.containsKey(ss)) {
                ArrayList<String> list = map.get(ss);
                list.add(s);
                map.put(ss, list);
            }
            else {
                ArrayList<String> list1 = new ArrayList();
                list1.add(s);
                map.put(ss, list1);
            }
        }

        for(String s : map.keySet()) {
            newlist.add(new ArrayList(map.get(s)));
        }

        return newlist;
    }
}
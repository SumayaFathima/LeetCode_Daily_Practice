package HackerRank;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class Complex_list_of_Duplicate_products {

    @Test
    public void example1() {

        String[] name = {"ball", "bat", "glove", "glove", "glove"};
        int[] price = {2, 3, 1, 2, 1};
        int[] weight = {2, 5, 1, 1, 1};
        long output = 1;
        Assert.assertEquals(numDuplicates(name, price, weight), output);
    }
    @Test
    public void example2() {

        String[] name = {"glove", "glove"};
        int[] price = {2, 2};
        int[] weight = {2, 2};
        long output = 1;
        Assert.assertEquals(numDuplicates(name, price, weight), output);
    }
    @Test
    public void example3() {

        String[] name = {"ball", "bat"};
        int[] price = {2, 2};
        int[] weight = {2, 2};
        long output = 0;
        Assert.assertEquals(numDuplicates(name, price, weight), output);
    }

    /* Pseudo code :

        1. Traverse from 0 to name length
        2. Concat with the index of all the 3 attributes
        3. Add in set. if set already has that string increment count
        4. return count
     */

    public  static  int numDuplicates(String[] name, int[] price, int[] weight) {

        int count =0;
        HashSet set = new HashSet();

        for(int i=0; i<name.length; i++) {
            String str = name[i] + price[i] + weight[i];

            if(set.contains(str)) {
                count++;
            }
            else
            set.add(str);
        }

        return count;
    }
}

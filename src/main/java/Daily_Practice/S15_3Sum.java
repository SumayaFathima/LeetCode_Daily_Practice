package Daily_Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.*;

public class S15_3Sum {

    @Test
    public void example1() { //{{-1,-1,2}, {-1,0,1}}
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    @Test
    public void example2() { //{{-5,0,5}}
        int[] nums = {-5,0,5};
        System.out.println(threeSum(nums));
    }

    @Test
    public void example3() { //{{}}
        int[] nums = {-5,0,-5};
        System.out.println(threeSum(nums));
    }

    @Test
    public void example4() { //{{-1,-1,2}}
        int[] nums = {-1,-1,-1,-1,2};
        System.out.println(threeSum(nums));
    }

    /*
    - Create a hashset with list of integers
    - Create a loop starting from 0 till < nums length-1
    - Create a hashset of integers
    - Create another loop starting from i+1 till nums lenngth
    - Assign nums[i] +nums[j] to a variable add in set if not present
    - if it is present, then add nums[i] , nums[j] and the variable to list of integers
    - sort the list using collection
    - add the list to hashset of integers list
    - return new ArrayList<>(hashset of integers list);
     */
    public List<List<Integer>> threeSum(int[] nums) {

        HashSet<List<Integer>> hashlist = new HashSet<>();

        for(int i=0; i< nums.length-1; i++) {

            HashSet<Integer> set = new HashSet();

            for(int j=i+1; j< nums.length; j++) {

                int k = -(nums[i] +nums[j]);
                if (set.contains(k)) {
                    List<Integer> list = Arrays.asList(nums[i] , nums[j], k);
                    Collections.sort(list);
                    hashlist.add(list);
                }

                else
                    set.add(nums[j]);
            }

        }

        return new ArrayList<>(hashlist);

    }
}
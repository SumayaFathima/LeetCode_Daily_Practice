package Two_Pointers_Array;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S06_CheckIfDoubleExist { 
	
	 /*  Leetcode_1346 :https://leetcode.com/problems/check-if-n-and-its-double-exist/
	  
    Given an array arr of integers, check if there exist two indices i
    and j such that :
    					i != j
    					0 <= i, j < arr.length
    					arr[i] == 2 * arr[j]

    Constraints:
    2 <= arr.length <= 500
    -10^3 <= arr[i] <= 10^3
    */
	
	@Test
    public void example1(){
        int[] arr={10,2,5,3};
        Assert.assertEquals(checkExist(arr), true);
    }
	
	@Test
    public void example2(){
        int[] arr={3,1,7,11};
        Assert.assertEquals(checkExist(arr), false);
    }


    @Test
    public void example3(){
        int[] arr={0,5};
        Assert.assertEquals(checkExist(arr), false);
    }
    
    @Test
    public void example4(){
        int[] arr={-10,9,-6,-7,13};
        Assert.assertEquals(checkExist(arr), false);
    }
    

    @Test
    public void example5(){
        int[] arr={0,0};
        Assert.assertEquals(checkExist(arr), true);
    }

    @Test
    public void example6(){
        int[] arr= {7,1,14,11};
        Assert.assertEquals(checkExist(arr), true);
    }

    @Test
    public void example7(){
     int[] arr= {1,0,3};
     Assert.assertEquals(checkExist(arr), false);
 }

   
/*  Pseudo code:
 
   1. Create Set of Integers
   2. Traverse through the given element
   3. When the set contains twice of current element, return true
   4. If the element is even and contains half of current element in set, return true
   5. Add current element into set
   6. Return false by default
   
*/ 
    
	public boolean checkExist(int[] arr) {
		
				Set<Integer> set = new HashSet<Integer>();	    
			    
			    for(int i=0; i < arr.length; i++) {
			    
			        if(set.contains(arr[i] * 2) || (arr[i]%2 ==0 &&  set.contains(arr[i] / 2) ))
			        	return true;
                    else
			           set.add(arr[i]);
			        }
			   
			    return false;
			}
	}

    /* Bruteforce :

        public boolean checkExist(int[] arr) {

        for (int i = 0; i < arr.length;; i++)
            for (int j = 0; j < arr.length;; j++)
                if (i != j && arr[i] == 2 * arr[j])
                    return true;

        return false;
    }
     */

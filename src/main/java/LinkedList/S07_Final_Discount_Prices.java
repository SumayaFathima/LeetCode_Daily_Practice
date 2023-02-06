package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class S07_Final_Discount_Prices {

    @Test
    public void example1() {
        int[] prices = {8, 4, 6, 2, 3};
        int[] output = {4, 2, 4, 2, 3};
        Assert.assertEquals(finalPrices(prices), output);
    }

    @Test
    public void example2() {
        int[] prices = {1,2,3,4,5};
        int[] output = {1,2,3,4,5};
        Assert.assertEquals(finalPrices(prices), output);
    }

    @Test
    public void example3() {
        int[] prices = {10,1,1,6};
        int[] output = {9,0,1,6};
        Assert.assertEquals(finalPrices(prices), output);
    }

    @Test
    public void example4() {
        int[] prices = {5,1};
        int[] output = {4,1};
        Assert.assertEquals(finalPrices(prices), output);
    }

    @Test
    public void example5() {
        int[] prices = {5,5,5,5,5,5,5,5};
        int[] output = {0,0,0,0,0,0,0,5};
        Assert.assertEquals(finalPrices(prices), output);
    }


    /* Leetcode_4175 : https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

        You are given an integer array prices where prices[i] is the price of the ith item in a shop.
        There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent
        to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any
        discount at all.

        Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop,
        considering the special discount.

        Constraints:

            1 <= prices.length <= 500
            1 <= prices[i] <= 1000

     */

    /* Pseudo code :

    1. Traverse while i and j < prices.length and j is i+1
    2. Check if j is less than i, if yes subtract prices[i] - prices[j] and replace the prices[i] and break
    3. If no, j++ and check
    4. Continue until the condition fails
    5. Return prices

    */
     public int[] finalPrices(int[] prices) {  //O(N^2)

        for (int i = 0; i < prices.length; i++) {

            for (int j = i + 1; j < prices.length; j++) {

                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}

  /*   public int[] finalPrices(int[] prices) {  //O(N)

        Stack<Integer> stack = new Stack();

        for(int i=0; i<prices.length; i++) {

            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                     prices[stack.pop()] = prices[stack.pop()] - prices[i];
            }
            stack.push(i);
         }
        return prices;
    }
} */

//Test case : 10min
//Pseudo code : 30min
// code : 20min
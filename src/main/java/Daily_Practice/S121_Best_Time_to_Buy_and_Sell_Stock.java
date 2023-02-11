package Daily_Practice;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class S121_Best_Time_to_Buy_and_Sell_Stock {

    @Test
    public void example1() {
        int[] prices = {7,1,5,3,6,4};
        int output = 5;
        Assert.assertEquals(maxProfit(prices), output);
    }

    @Test
    public void example2() {
        int[] prices = {7,6,4,3,1};
        int output = 0;
        Assert.assertEquals(maxProfit(prices), output);
    }

    /*
    1. Add first value to minprice
    2. Traverse each element and find min
    3. Find profit with max of profit and price-minPrice
    4. Return profit

     */
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int profit = 0;

        for(int price:prices){
            minPrice = Math.min(minPrice,price);
            profit = Math.max(profit, price-minPrice);
        }
        return profit;
    }
}
//LeetCode 122 Best Time to Buy and Sell Stock II

import java.util.*;
public class BestTimeToBuyandSellStock2 {
	//update when met peak or end
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int minBuyPrice = prices[0], maxSellPrice = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > maxSellPrice)
               maxSellPrice = prices[i];
            if (prices[i] < maxSellPrice || i == prices.length - 1) {
                profit += maxSellPrice - minBuyPrice;
                minBuyPrice = prices[i];
                maxSellPrice = prices[i];
            } 
        }
        return profit;
    }
	
	public static void main(String[] args) {
		BestTimeToBuyandSellStock2 b = new BestTimeToBuyandSellStock2();
		int[] prices = {7,1,5,3,6,4};
		System.out.println(b.maxProfit(prices));
	}
}

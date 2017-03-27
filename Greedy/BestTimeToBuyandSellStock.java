//LeetCode 121 Best Time to Buy and Sell Stock
import java.util.*;
public class BestTimeToBuyandSellStock {
    //brute force
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length, maxProfit = 0;
        for (int i = 0; i< len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int profit = prices[j] - prices[i];
                if (maxProfit < profit) maxProfit = profit;
            }
        }
        return maxProfit;
        
    }
    // iterate in two pass, first pass find the minBuyPrice so far, the second pass get the maxProfit
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int[] minBuyByDay = Arrays.copyOf(prices, len);
        for (int i = 1; i < len; i++) {
            minBuyByDay[i] = Math.min(minBuyByDay[i - 1], minBuyByDay[i]);
        }
        int max = 0;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, prices[i] - minBuyByDay[i]);
        }
        return max;
    }
    //iterate in one pass, each time update minBuyPrice and maxProfit
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int len = prices.length, minBuyPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] < minBuyPrice) minBuyPrice = prices[i];
            else {
                maxProfit = Math.max(maxProfit, prices[i] - minBuyPrice);
            }
        }
        return maxProfit;
    }
    
}

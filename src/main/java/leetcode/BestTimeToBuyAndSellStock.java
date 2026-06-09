package leetcode;



public class BestTimeToBuyAndSellStock {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * <p>
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     * <p>
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     */

    public static int maxProfit1(int[] prices) {
        var maxProfits = 0;
        for (int i = 0; i < prices.length; i++) {
            var currentMax = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    currentMax = Math.max(currentMax, prices[j] - prices[i]);
                } else {
                    break;
                }
            }
            maxProfits = Math.max(currentMax, maxProfits);
        }
        return maxProfits;
    }


}

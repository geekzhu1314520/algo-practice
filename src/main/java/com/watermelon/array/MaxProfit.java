package com.watermelon.array;

/**
 * <h1>MaxProfit</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/9
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;

    }

}
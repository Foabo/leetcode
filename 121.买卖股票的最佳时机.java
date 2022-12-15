/*
 * @Date: 2020-11-08 23:12:37
 * @LastEditors: Foabo
 * @LastEditTime: 2020-11-08 23:55:36
 * @FilePath: /leetcode_vs/121.买卖股票的最佳时机.java
 */
/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        // dp[i,j]表示i天买入j天卖出

        int max = 0, val1 = 0, val2 = 0, tmp = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                val1 = prices[j] - prices[i];
                val2 = prices[n - 1] - prices[j];
                val1 = val1 > 0 ? val1 : 0;
                val2 = val2 > 0 ? val2 : 0;
                tmp = val1 + val2;
                max = tmp > max ? tmp : max;
            }

        }

        return max;
    }

    public int maxProfit(int[] prices) {

        int maxProfit = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            min = prices[i] < min ? prices[i] : min;
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }

        return maxProfit;
    }
}
// @lc code=end

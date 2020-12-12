/*
 * @Date: 2020-11-08 23:12:47
 * @LastEditors: Foabo
 * @LastEditTime: 2020-11-09 11:11:49
 * @FilePath: /leetcode_vs/122.买卖股票的最佳时机-ii.java
 */
/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // max()参数，前一个表示什么都不做，后一个表示当前买入（第二行）或卖出（第一行）操作
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /* 优化空间 */
    public int maxProfit2(int[] prices) {
        int n = prices.length;

        int cash = 0;
        int buy = -prices[0];
        int pre_cash;

        for (int i = 1; i < n; i++) {
            pre_cash = cash;
            // max()参数，前一个表示什么都不做，后一个表示当前买入（第二行）或卖出（第一行）操作
            cash = Math.max(pre_cash, buy + prices[i]);
            buy = Math.max(buy, pre_cash - prices[i]);
        }
        return cash;
    }

    /* 贪心算法 */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;

    }

}
// @lc code=end

/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        /**
         * dp[i][k][j]
         * i:天
         * k:最大交易次数
         * dp[i][k] 表示在第 i 天结束时，最多进行 k 次交易的情况下可以获得的最大收益。
         */
        int[][][] dp = new int[n][3][2];

        /*
         * T[i][2][0] = max(T[i - 1][2][0], T[i - 1][2][1] + prices[i]) 
         * T[i][2][1] = max(T[i - 1][2][1], T[i - 1][1][0] - prices[i]) 
         * T[i][1][0] = max(T[i - 1][1][0], T[i - 1][1][1] + prices[i]) 
         * T[i][1][1] = max(T[i - 1][1][1], T[i - 1][0][0] - prices[i]) = max(T[i - 1][1][1], -prices[i])
         */
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            /**
             * 状态转移：休息 / 买入或卖出
             */
            //只能休息或卖出，k不变
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            //只能休息或买入，k-1
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            //只能休息或卖出，k不变
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            //只能休息或买入，k-1
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);

        }
        return dp[n - 1][2][0];
    }
}
// @lc code=end

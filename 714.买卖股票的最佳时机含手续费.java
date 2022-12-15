/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        /*
         * base case： 
         * dp[-1][k][0] = dp[i][0][0] = 0 
         * dp[-1][k][1] = dp[i][0][1] = -infinity
         * 
         * 状态转移方程： 
         * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
         */
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            
            // 特判一下，考虑base case
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }

            // 第i天没持有股票,可能是i-1没持有股票，今天休息
            // 或者昨天有股票今天卖了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]-fee);
             // 第i天持有股票,可能是i-持有股票，今天休息
            // 或者昨天没有股票今天买了 
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

        }

        return dp[n - 1][0];
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 1)
            return 0;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {

            // 第i天没持有股票,可能是i-1没持有股票，今天休息
            // 或者昨天有股票今天卖了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 第i天持有股票,可能是i-1持有股票，今天休息
            // 或者i-2天卖了股票今天买了
            if (i < 2) {
                dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
            }
            else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]); 
            }

        }
        return dp[n - 1][0];
    }


    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 代表 dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
}
// @lc code=end

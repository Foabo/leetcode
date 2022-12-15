/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        /*
         * base case： dp[-1][k][0] = dp[i][0][0] = 0 dp[-1][k][1] = dp[i][0][1] =
         * -infinity
         * 
         * 状态转移方程： dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
         */
        int n = prices.length;
        if (n < 1)
            return 0;
        // 防止爆内存
        // if (k > n / 2)
        //     return maxProfit(prices);
        int[][][] dp = new int[n][k + 1][2];
        // 定义一次买入再卖出算一次交易
        for (int i = 0; i < n; i++) {
            for (int j = k; j > 0; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                // 第i天第k次交易下未持有股票
                // 只能是i-1天k次交易下没有股票，今天休息
                // 或者是i-1天k次交易下有股票，卖出股票
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);

                // 第i天第k次交易下持有股票
                // 只能是i-1天k次交易下持有股票，今天休息
                // 或者是i-1天k次交易下没，买入股票
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    
}
// @lc code=end

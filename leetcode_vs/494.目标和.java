import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        // dp[i][j]表示 第前i个数目标和为j的方法数
        int[][] dp = new int[n][2001];
        dp[0][1000 + nums[0]] = 1;
        // nums[0]==0的情况
        dp[0][1000 - nums[0]] += 1;
        for (int i = 1; i < n; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if (dp[i - 1][j + 1000] > 0) {
                    dp[i][1000 + j + nums[i]] += dp[i - 1][1000 + j];
                    dp[i][1000 + j - nums[i]] += dp[i - 1][1000 + j];
                }

            }
        }

        return S > 1000 ? 0 : dp[n - 1][1000 + S];

    }
}
// @lc code=end

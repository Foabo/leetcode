/*
 * @lc app=leetcode.cn id=629 lang=java
 *
 * [629] K个逆序对数组
 */

// @lc code=start
class Solution {
    public int kInversePairs(int n, int k) {

        // dp[i][j] 1...i 的數中 j个逆序对的个数
        // i为最大的数
        // 我们在数字 [1 .. i - 1] 组成的排列中放入 i 时，有 i 种放置方法：
        // 如果将 i 放在最后，则逆序对数量不变；如果将 i 放在倒数第二个，则逆序对数量增加 1；如果将 i 放在第一个，则逆序对数量增加 i - 1。
        // 状态转移方程
        // f(i, j) = f(i - 1, j) + f(i - 1, j - 1) + ... + f(i - 1, j - i + 1)
        //
        // f(i, j - 1) = f(i - 1, j - 1) + f(i - 1, j - 2) + ... + f(i - 1, j - i)
        // f(i, j) - f(i - 1, j) = f(i, j - 1) - f(i - 1, j - i)
        // ==> f(i, j) = f(i, j - 1) + f(i - 1, j) - f(i - 1, j - i)

        // basecase ：
        // f(i, j0) = 0 if j0 < 0
        // f(i, 0) = 1
        int M = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1; // 逆序对为0 就是这个数本身
            // 最大逆序数
            int cnt = i * (i - 1) >> 1;
            for (int j = 1; j <= Math.min(cnt, k); j++) {
                // val = f(i - 1, j) - f(i - 1, j - i)
                int val = (dp[i - 1][j] + M - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % M;
                dp[i][j] = (dp[i][j - 1] + val) % M;
            }
        }
        return dp[n][k];

    }
}
// @lc code=end

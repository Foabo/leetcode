/*
 * @lc app=leetcode.cn id=877 lang=java
 *
 * [877] 石子游戏
 */

// @lc code=start
class Solution {
    public boolean stoneGame1(int[] piles) {
        /*
         * 可以在第一步就观察好，奇数堆的石头总数多，还是偶数堆的石头总数多， 每次只拿奇数堆或者偶数堆
         */
        return true;
    }

    public boolean stoneGame(int[] piles) {
        /*
         *
         * dp[i][j][0]表示，对于 piles[i...j] 这部分石头堆，先手能获得的最高分数。
         * dp[i][j][1]表示，对于piles[i...j]  这部分石头堆，后手能获得的最高分数。 
         * 我们想求的答案是先手和后手最终分数之差，按照这个定义也就是 dp[0][n-1][0] - dp[0][n-1][1]，
         * 即面对整个 piles，先手的最优得分和后手的最优得分之差。
         * 
         * 状态显然有三个：开始的索引 i，结束的索引 j，当前轮到的人，先手和后手，两者相互转换。 
         * 选择有两个：选择最左边的那堆石头，或者选择最右边的那堆石头
         * 
         * 先手：
         * dp[i][j].fir = max(piles[i] + dp[i+1][j].sec, piles[j] + dp[i][j-1].sec)
         * dp[i][j].fir = max(    选择最左边的石头堆     ,     选择最右边的石头堆     )
         * 后手：
         * if 先手选择了左边:
         *  dp[i][j].sec = dp[i+1][j].fir
         * if 先手选择右边:
         *  dp[i][j].sec = dp[i][j-1].fir
         * 
         * base case:
         * dp[i][j].fir = piles[i]
         * p[i][j].sec = 0
         * 其中 0 <= i == j < n
         */
        int n = piles.length;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i][0] = piles[i];
        }

        for (int j = 1; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int l = piles[i] + dp[i + 1][j][1];
                int r = piles[j] + dp[i][j - 1][1];
                if (l > r) {
                    dp[i][j][0] = l;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = r;
                    dp[i][j][1] = dp[i][j - 1][0];
                }

            }
        }
        return dp[0][n - 1][0] > dp[0][n - 1][1];
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String s1, String s2) {
        // 由s1变成s2
        // if s1[i] == s2[j]:
        //   啥都别做（skip）
        //   i, j 同时向前移动
        // else:
        //   三选一：
        //   插入（insert）
        //   删除（delete）
        //   替换（replace）
        // return dfs(s1, s2, s1.length() - 1, s2.length() - 1);

        // dp[i-1][j-1]
        // 存储 s1[0..i] 和 s2[0..j] 的最小编辑距离
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j] + 1, // 刪除
                            dp[i][j - 1] + 1, // 插入
                            dp[i - 1][j - 1] + 1); // 替換
                }
            }
        }
        return dp[m][n];

    }

    public int dfs(String s1, String s2, int i, int j) {
        // base case
        if (i == -1)
            return j + 1;
        if (j == -1)
            return i + 1;
        if (s1.charAt(i) == s2.charAt(j)) {
            return dfs(s1, s2, i - 1, j - 1);
        } else {
            return Math.min(dfs(s1, s2, i, j - 1) + 1, // 插入
                    Math.min(dfs(s1, s2, i - 1, j) + 1, // 删除
                            dfs(s1, s2, i - 1, j - 1) + 1)); // 替换
        }
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
// @lc code=end

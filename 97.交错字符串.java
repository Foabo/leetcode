import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length(), n = s2.length();
        if (s3.length() != m + n)
            return false;
        // dp[i][j]表示对 1...i 中 s1 的字符和 1...j 中s2的字符
        // 是否在s3[i+j]中交叉对应
        // 对于s3中的当前下标 i+j，要么和s1[i]匹配，要么和s2[j]匹配；
        boolean[][] dp = new boolean[m + 1][n + 1];
        s1 = " " + s1;
        s2 = " " + s2;
        s3 = " " + s3;
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i > 0 && s1.charAt(i) == s3.charAt(i + j))
                    dp[i][j] = dp[i - 1][j];
                if (j > 0 && s2.charAt(j) == s3.charAt(i + j))
                    dp[i][j] = dp[i][j] || dp[i][j - 1];

            }
        }
        return dp[m][n];

    }
}
// @lc code=end

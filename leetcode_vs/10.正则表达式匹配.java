/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        s = ' ' + s;
        p = ' ' + p;
        boolean[][] dp = new boolean[n + 1][m + 1];
        // dp[i][j]表示 s[1...i] 和 p[1...j] 是否存在合法方案
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // 特判一下，如果p[j+1]是*,则这个可以跳过
                // 将 （a*）看成一个整体，它们是一个字符
                if (j + 1 <= m && p.charAt(j + 1) == '*') {
                    continue;
                }
                if (i > 0 && p.charAt(j) != '*') {
                    // 要么s[i]和p[j]匹配，要么p[j]是一个'.'表示匹配任意字符
                    // 同时他们前一个字符也得匹配
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                } else if (p.charAt(j) == '*') {
                    // 因为 '*' 可以表示匹配0个或多个前一个字符，看成(a*)来，一个字符占两个
                    // 所以比较 a 前面的字符就是 p[j-2]，如果他们不匹配，dp[i][j-2]表示 ‘*’ 表示0个字符
                    // 所以其实还有表示1个字符的时候 s[i]==p[j-1]要成立，或者p[j-1]是 '.'，
                    // 同时还要满足 s[i-1] p[j]
                    // '*' 表示两个字符以此类推
                    // 最终状态转移就为 dp[i][j-2] || (dp[i-1][j]&&s[i]p[j])匹配情况
                    dp[i][j] = dp[i][j - 2]
                            || i > 0 && dp[i - 1][j] && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }

            }
        }
        return dp[n][m];
    }
}
// @lc code=end

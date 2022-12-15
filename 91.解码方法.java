/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        // 动态规划
        // 对当前的i，要么它是当前的字符，要么是和前一个字符结合
        // dp[i]
        if (s.length() == 0)
            return 0;
        s = " " + s;
        char pre = s.charAt(0);
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            // 只计算当前一位
            if (c >= '1' && c <= '9') {
                dp[i] += dp[i - 1];
            }
            // 计算两位
            if (i > 1) {
                int t = (pre - '0') * 10 + c - '0';
                if (t >= 10 && t <= 26)
                    dp[i] += dp[i - 2];
            }
            pre = c;
        }
        return dp[s.length()-1];
    }
}
// @lc code=end

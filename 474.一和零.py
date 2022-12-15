#
# @lc app=leetcode.cn id=474 lang=python3
#
# [474] 一和零
#

# @lc code=start


class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        # dp[i][j] : i个1，j个0中能拼出的字符串个数
        def count(s):
            m, n = 0, 0
            for c in s:
                if c == '0':
                    m += 1
                else:
                    n += 1
            return m, n

        dp = [[0]*(n+1) for _ in range(m+1)]
        for s in strs:
            m_0, n_1 = count(s)
            for i in range(m, m_0-1, -1):
                for j in range(n, n_1-1, -1):
                    dp[i][j] = max(1+dp[i-m_0][j-n_1], dp[i][j])
        return dp[m][n]
# @lc code=end

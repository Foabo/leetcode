#
# @lc app=leetcode.cn id=62 lang=python3
#
# [62] 不同路径
#

# @lc code=start


class Solution:
    # 普通动态规划
    def uniquePaths2(self, m: int, n: int) -> int:
        dp = [[1 for _ in range(n)]for _ in range(m)]

        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j]+dp[i][j-1]
        return dp[m-1][n-1]

    # 优化空间 O(2n)
    def uniquePaths1(self, m: int, n: int) -> int:
        pre = [1]*n
        cur = [1]*n

        for i in range(1, m):
            for j in range(1, n):
                cur[j] = pre[j]+cur[j-1]
            pre = cur[:]
        return cur[-1]

    def uniquePaths(self, m: int, n: int) -> int:
        cur = [1]*n
        for i in range(1, m):
            for j in range(1, n):
                cur[j] += cur[j-1]
        return cur[-1]
# @lc code=end

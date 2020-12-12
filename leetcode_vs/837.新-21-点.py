#
# @lc app=leetcode.cn id=837 lang=python3
#
# [837] 新21点
#

# @lc code=start


class Solution:
    def new21Game(self, N: int, K: int, W: int) -> float:
        dp = [0.0] * (K + W)
        for i in range(K, K+W):
            dp[i] = 1 if i <= N else 0
        S = min(N-K+1, W)
        for i in range(K - 1, -1, -1):
            # tmp = 0
            # for j in range(i+1, i + W+1):
            #     tmp += dp[j]
            # dp[i] = tmp / float(W)
            dp[i] = S / float(W)
            S = S-dp[i+W]+dp[i]
        return dp[0]


# @lc code=end
if __name__ == "__main__":
    solution = Solution()
    print(solution.new21Game(21, 17, 10))

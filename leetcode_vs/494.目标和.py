#
# @lc app=leetcode.cn id=494 lang=python3
#
# [494] 目标和
#

# @lc code=start


class Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        # 选择，+或者-
        # 组合 S
        # dp[i...][S]
        # dp[i][j]表示 第前i个数目标和为j的方法数
        n = len(nums)
        dp = [[0]*(2001) for _ in range(n+1)]
        dp[0][nums[0]+1000] = 1
        dp[0][-nums[0]+1000] += 1
        for i in range(1, n+1):
            for j in range(-1000, 1001):
                dp[i][j+1000] = dp[i - 1][j - nums[i]+1000] + dp[i - 1][j + nums[i]+1000]
                # -1的选择
        print(dp)
        return dp[n][S]
# @lc code=end

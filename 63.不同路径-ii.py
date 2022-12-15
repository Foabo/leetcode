#
# @lc app=leetcode.cn id=63 lang=python3
#
# [63] 不同路径 II
#

# @lc code=start


class Solution:
    def uniquePathsWithObstacles1(self, obstacleGrid: List[List[int]]) -> int:
        r = len(obstacleGrid)
        c = len(obstacleGrid[0])
        dp = [[0]*c for _ in range(r)]

        for i in range(c):
            if obstacleGrid[0][i]:
                dp[0][i] = 0
                break
            dp[0][i] = 1
        for j in range(r):
            if obstacleGrid[j][0]:
                dp[j][0] = 0
                break
            dp[j][0] = 1

        for i in range(1, r):
            for j in range(1, c):
                if obstacleGrid[i][j]:
                    dp[i][j] = 0

                else:
                    upper = dp[i-1][j]
                    left = dp[i][j-1]
                    dp[i][j] = upper+left

        return dp[-1][-1]

    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        r = len(obstacleGrid)
        c = len(obstacleGrid[0])
        dp = [0]*c
        for i in range(c):
            # 第一行向右遍历，如果遇到障碍
            if obstacleGrid[0][i]:
                dp[i] = 0
                break
            dp[i] = 1
        print(dp)
        for i in range(1, r):
            if obstacleGrid[i][0]:
                dp[0] = 0
            for j in range(1, c):
                # 遇到障碍
                if obstacleGrid[i][j]:
                    dp[j] = 0
                else:
                    dp[j] += dp[j-1]
            print(dp)
        return dp[-1]
# @lc code=end

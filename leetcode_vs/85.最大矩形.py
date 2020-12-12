#
# @lc app=leetcode.cn id=85 lang=python3
#
# [85] 最大矩形
#

# @lc code=start


class Solution:
    def leetcode84(self, heights):
        stack = [-1]

        maxarea = 0
        for i in range(len(heights)):

            while stack[-1] != -1 and heights[stack[-1]] >= heights[i]:
                maxarea = max(
                    maxarea, heights[stack.pop()] * (i - stack[-1] - 1))
            stack.append(i)

        while stack[-1] != -1:
            maxarea = max(maxarea, heights[stack.pop()]
                          * (len(heights) - stack[-1] - 1))
        return maxarea

    def maximalRectangle2(self, matrix: List[List[str]]) -> int:
        max_area = 0
        dp = [[0 for i in range(len(matrix[0]))] for _ in range(len(matrix))]

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == '0':
                    continue
                width = dp[i][j] = dp[i][j - 1] + 1 if j else 1
                for k in range(i, -1, -1):
                    width = min(dp[k][j], width)
                    max_area = max(max_area, width*(i-k+1))

        return max_area

    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        max_area = 0
        dp = [0] * len(matrix[0])
        for i in range(len(matrix)):
            for j in range(len(metrix[0])):
                dp[j] = dp[j] + 1 if matrix[i][j] == "1" else 0
            max_area = max(max_area, self.leetcode84(dp))
        return max_area

# @lc code=end

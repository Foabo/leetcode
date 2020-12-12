#
# @lc app=leetcode.cn id=542 lang=python3
#
# [542] 01 矩阵
#

# @lc code=start
from collections import deque


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        R = len(matrix)
        C = len(matrix[0])
        queue = deque()
        for i in range(R):
            for j in range(C):
                if matrix[i][j] == 0:
                    queue.append((i, j))
                else:
                    matrix[i][j] = -1
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        while queue:
            x, y = queue.popleft()
            for i in range(4):
                dx, dy = dirs[i]
                newx = x + dx
                newy = y + dy
                if newx >= 0 and newx < R and newy >= 0 and newy < C and matrix[newx][newy] == -1:
                    matrix[newx][newy] = matrix[x][y] + 1
                    queue.append((newx, newy))

        return matrix

    def dp_updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        R, C = len(matrix), len(matrix[0])
        dist = [[R * C] * C for _ in range(R)]

        for i in range(R):
            for j in range(C):
                if matrix[i][j] == 0:
                    dist[i][j] = 0
        # 实际上，我们只需要保留
        # 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
        for i in range(R):
            for j in range(C):
                if i - 1 >= 0:
                    dist[i][j] = min(dist[i, j], dist[i-1][j]+1)
                if j - 1 >= 0:
                    dist[i][j] = min(dist[i][j], dist[i][j - 1] + 1)
        # 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
        for i in range(R - 1, -1, -1):
            for j in range(C - 1, -1, -1):
                if i + 1 < R:
                    dist[i][j] = min(dist[i][j], dist[i + 1][j] + 1)
                if j + 1 < C:
                    dist[i][j] = min(dist[i][j], dist[i][j + 1] + 1)
        # # 只有 水平向左移动 和 竖直向下移动，注意动态规划的计算顺序
        # for i in range(R - 1, -1, -1):
        #     for j in range(C):
        #         if i + 1 < R:
        #             dist[i][j] = min(dist[i][j], dist[i + 1][j] + 1)
        #         if j - 1 >= 0:
        #             dist[i][j] = min(dist[i][j], dist[i][j - 1] + 1)

        # # 只有 水平向右移动 和 竖直向上移动，注意动态规划的计算顺序
        # for i in range(R):
        #     for j in range(C - 1, -1, -1):
        #         if i - 1 >= 0:
        #             dist[i][j] = min(dist[i][j], dist[i - 1][j] + 1)
        #         if j + 1 < C:
        #             dist[i][j] = min(dist[i][j], dist[i][j + 1] + 1)
       

        return dist


# @lc code=end

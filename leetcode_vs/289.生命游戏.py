#
# @lc app=leetcode.cn id=289 lang=python3
#
# [289] 生命游戏
#

# @lc code=start


from numpy.core.defchararray import array


class Solution:
    def gameOfLife1(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        directions = [(0, -1), (0, 1), (-1, 0), (1, 0),
                      (-1, -1), (-1, 1), (1, -1), (1, 1)]
        rows = len(board)
        columns = len(board[0])

        def check(i, j):
            count = 0
            for extra_i, extra_j in directions:
                new_i, new_j = i+extra_i, j+extra_j
                if new_i >= 0 and new_i < rows and new_j >= 0 and new_j < columns and abs(board[new_i][new_j]) == 1:
                    count += 1
            return count
        for i in range(rows):
            for j in range(columns):
                count = check(i, j)
                if board[i][j]:
                    if count < 2 or count > 3:
                        board[i][j] = -1
                elif board[i][j] == 0:
                    if count == 3:
                        board[i][j] = 2
        for i in range(rows):
            for j in range(columns):
                if board[i][j] > 0:
                    board[i][j] = 1
                else:
                    board[i][j] = 0

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        import numpy as np
        r, c = len(board), len(board[0])
        # zero padding
        board_exp = np.zeros((r+2, c+2))
        board_exp[1:r+1, 1:c+1] = np.array(board)
        # 设置卷积核
        kernel = np.array([[1, 1, 1],
                           [1, 0, 1],
                           [1, 1, 1]])
        # 卷积
        for i in range(1, r+1):
            for j in range(1, c+1):
                # 统计细胞周围8个位置的状态
                temp_sum = np.sum(kernel*board_exp[i-1: i+2, j-1:j+2])

                # 判断
                # 原来位置是1
                if board_exp[i, j] == 1:
                    if temp_sum < 2 or temp_sum > 3:
                        board[i-1][j-1] = 0
                else:
                    if temp_sum == 3:
                        board[i-1][j-1] = 1

# @lc code=end

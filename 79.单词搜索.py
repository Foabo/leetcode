#
# @lc app=leetcode.cn id=79 lang=python3
#
# [79] 单词搜索
#
from typing import List
# @lc code=start


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        drt = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        word_len = len(word)
        rows = len(board)
        cols = len(board[0])
        visited = set()

        def check(i, j, k):
            # 终止条件,两个
            if board[i][j] != word[k]:
                return False
            if k == word_len - 1:
                return True

            visited.add((i, j))
            res = False
            for di, dj in drt:
                newi, newj = i + di, j + dj
                if 0 <= newi < rows and 0 <= newj < cols:
                    if ((newi, newj)) not in visited:
                        # 递归调用,深度优先搜索
                        if check(newi, newj, k + 1):
                            res = True
                            break
            # 关键一步,回溯到上一个状态
            visited.remove((i, j))
            return res

        for i in range(rows):
            for j in range(cols):
                if check(i, j, 0):
                    return True
        return False


# @lc code=end
if __name__ == "__main__":
    board = [["A", "B", "C", "E"],
             ["S", "F", "C", "S"],
             ["A", "D", "E", "E"]]
    word = "ABCCED"
    s = Solution()
    print(s.exist(board, word))

#
# @lc app=leetcode.cn id=118 lang=python3
#
# [118] 杨辉三角
#
from typing import List
# @lc code=start


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = []
        for i in range(numRows):
            res.append([1 for j in range(i+1)])

        for i in range(1, numRows):
            for j in range(1, i):
                res[i][j] = res[i - 1][j - 1] + res[i - 1][j]
        return res
# @lc code=end


if __name__ == "__main__":
    res = []
    numRows = 10
    for i in range(numRows):
        res.append([1 for j in range(i+1)])
    print(res)

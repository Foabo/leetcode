#
# @lc app=leetcode.cn id=119 lang=python3
#
# [119] 杨辉三角 II
#
from typing import List
# @lc code=start


class Solution:
    # 超时
    # def helper(self, i, j):

    #     return self.helper(i-1, j-1)+self.helper(i-1, j) if j != 0 and i != j else 1

    def getRow(self, rowIndex: int) -> List[int]:
        res = [1 for _ in range(rowIndex+1)]
        for i in range(rowIndex+1):
            # res.append(self.helper(rowIndex, i))
            for j in range(i-1, 0, -1):
                res[j] = res[j-1]+res[j]

        return res


# @lc code=end
if __name__ == "__main__":
    solution = Solution()
    print(solution.getRow(3))

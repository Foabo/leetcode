#
# @lc app=leetcode.cn id=216 lang=python3
#
# [216] 组合总和 III
from typing import List
# @lc code=start

import copy


class Solution:

    def combinationSum3(self, k: int, n: int) -> List[List[int]]:

        res = []
        lst = []

        def dfs(k, start, n):
            # 终止条件,找到一组合适的
            if len(lst) == k or n <= 0:
                if len(lst) == k and n == 0:
                    res.append(lst.copy())
                return
            # 因为不能有重复的集合和集合中不能有重复的数字,所以i不能从0开始
            # 从上一个选择的下一个值开始
            for i in range(start, 10):
                # 选择当前值
                lst.append(i)
                # 递归
                dfs(k, i + 1, n - i)
                # 撤销选择,移除最后一个元素
                lst.pop()
        dfs(k, 1, n)
        return res


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    res = s.combinationSum3(3, 7)
    print(res)

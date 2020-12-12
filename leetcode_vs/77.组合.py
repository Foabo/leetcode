#
# @lc app=leetcode.cn id=77 lang=python3
#
# [77] 组合
#

# @lc code=start


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        lst = []

        def dfs(start):
            if len(lst) == k:
                res.append(lst[:])
            for i in range(start, n+1):
                lst.append(i)
                dfs(i+1)
                lst.pop()
        dfs(1)

        return res
# @lc code=end

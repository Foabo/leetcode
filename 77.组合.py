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

        # 注意传入的是start
        def dfs(start):
            #  终止条件
            if len(lst) == k:
                res.append(lst[:])
            #
            # 可能要剪枝
            #
            
            for i in range(start, n+1):
                # 状态选择
                lst.append(i)
                dfs(i+1)
                # 回溯，撤销选择
                lst.pop()
        dfs(1)

        return res
# @lc code=end

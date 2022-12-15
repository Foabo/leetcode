#
# @lc app=leetcode.cn id=39 lang=python3
#
# [39] 组合总和
#

# @lc code=start


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        lst = []
        length = len(candidates)
        
        def dfs(start, cur_sum):
            # 终止方法
            if target - cur_sum == 0:
                res.append(lst.copy())
                return
            if cur_sum > target:
                return
            for i in range(start, length):
                # 选择当前值
                lst.append(candidates[i])
                # 递归,从当前遍历的集合的序号开始
                dfs(i, cur_sum + candidates[i])
                # 回溯,撤销选择
                lst.pop()
        dfs(0, 0)
        return res
# @lc code=end

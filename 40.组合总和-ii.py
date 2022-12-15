#
# @lc app=leetcode.cn id=40 lang=python3
#
# [40] 组合总和 II
#

# @lc code=start


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        lst = []
        length = len(candidates)
        candidates.sort()

        def dfs(start, cur_sum):
            # 终止方法
            if target - cur_sum == 0:
                res.append(lst.copy())
                return
            if cur_sum > target:
                return
            for i in range(start, length):
                # 关键步骤,避免重复,这里的start是dfs return后的,也就是循环最开始的那个start
                # https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
                if i > start and candidates[i - 1] == candidates[i]:
                    continue
                # 选择当前值
                lst.append(candidates[i])
                # 递归,从当前遍历的集合的序号下一个开始
                dfs(i+1, cur_sum + candidates[i])
                # 回溯,撤销选择
                lst.pop()
        dfs(0, 0)
        return res
# @lc code=end

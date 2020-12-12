#
# @lc app=leetcode.cn id=18 lang=python3
#
# [18] 四数之和
#

# @lc code=start


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        if not nums:
            return []
        res = []
        lst = []
        n = len(nums)
        nums.sort()
        
        def dfs(cur_sum, start):
            # 终止条件
            if len(lst) == 4 and cur_sum == target:
                res.append(lst[:])
                return
            elif len(lst) >= 4:
                return
            for i in range(start, n):
                if n-start < 4-len(lst):
                    return
                if i > start and nums[i] == nums[i-1]:
                    continue

                check_sum = cur_sum+nums[i]
                # 剪枝
                if i < n-1 and check_sum+(3-len(lst))*nums[i+1] > target:
                    return
                if i < n-1 and check_sum+(3-len(lst))*nums[n-1] < target:
                    continue
                lst.append(nums[i])
                
                dfs(check_sum, i+1)
                lst.pop()
                
        dfs(0, 0)

        return res
# @lc code=end

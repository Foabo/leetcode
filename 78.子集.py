#
# @lc app=leetcode.cn id=78 lang=python3
#
# [78] 子集
#

# @lc code=start


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        
        lst = []
        # nums.sort()
        k = len(nums)

        def dfs(start):
            
            res.append(lst[:])
            for i in range(start, k):
                lst.append(nums[i])
                dfs(i+1)
                lst.pop()
        dfs(0)

        return res
# @lc code=end

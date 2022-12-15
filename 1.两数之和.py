#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mp = {}
        size = len(nums)
        if size == 0:
            return[]
        res = []
        for i in range(size):
            mp[nums[i]] = i
        for i in range(size):
            k = target-nums[i]
            if k in mp and mp[k] > i:
                res = [i, mp[k]]
        return res
# @lc code=end

#
# @lc app=leetcode.cn id=268 lang=python3
#
# [268] 缺失数字
#

# @lc code=start


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        num_sum = n*(n+1)//2
        cur_sum = 0
        for num in nums:
            cur_sum += num
        return num_sum-cur_sum
# @lc code=end

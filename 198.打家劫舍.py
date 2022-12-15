#
# @lc app=leetcode.cn id=198 lang=python3
#
# [198] 打家劫舍
#

# @lc code=start


class Solution:
    def rob(self, nums: List[int]) -> int:
        size = len(nums)
        if size == 0:
            return 0
        elif size == 1:
            return nums[0]
        elif size == 2:
            return nums[0]if nums[0] > nums[1]else nums[1]
        # dp = [0 for _ in range(size)]
        # dp[0] = nums[0]
        # dp[1] = max(nums[0], nums[1])
        first = nums[0]
        second = max(nums[0], nums[1])
        for i in range(2, size):
            # dp[i] = max(dp[i-2]+nums[i], dp[i-1])
            tmp = second
            second = max(first+nums[i], second)
            first = tmp
        return second
# @lc code=end

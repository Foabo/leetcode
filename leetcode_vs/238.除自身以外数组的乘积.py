#
# @lc app=leetcode.cn id=238 lang=python3
#
# [238] 除自身以外数组的乘积
#

# @lc code=start


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        size = len(nums)
        output = [1] * size
        # L = [1] * size
        # R = [1] * size
        for i in range(1, size):
            # L[i] = L[i - 1] * nums[i - 1]
            output[i] = output[i - 1] * nums[i - 1]
        R = 1
        for i in range(size - 1, -1, -1):
            # R[i] = R[i + 1] * nums[i + 1]
            output[i] = output[i] * R
            R *= nums[i]
        # for i in range(size):
        #     output[i] = L[i]*R[i]
        return output
# @lc code=end

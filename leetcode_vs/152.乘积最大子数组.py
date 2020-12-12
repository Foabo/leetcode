#
# @lc app=leetcode.cn id=152 lang=python3
#
# [152] 乘积最大子数组
#
from typing import List
# @lc code=start


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        res = nums[0]
        pre_max = pre_min = nums[0]
        for i in range(1, len(nums)):
            left = pre_max*nums[i]
            right = pre_min*nums[i]
            pre_max = max(left, right, nums[i])
            pre_min = min(left, right, nums[i])
            res = max(res, pre_max)
        return res


# @lc code=end
if __name__ == "__main__":
    nums = [2, 3, -2, 4]
    solution = Solution()
    max_prdt = solution.maxProduct(nums)

    print(max_prdt)

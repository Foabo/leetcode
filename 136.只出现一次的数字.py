#
# @lc app=leetcode.cn id=136 lang=python3
#
# [136] 只出现一次的数字
#
from typing import List
from functools import reduce
# @lc code=start


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # res = 0
        # for num in nums:
        #     res = res ^ num
        # return res
        return reduce(lambda x, y: x ^ y, nums)


# @lc code=end
if __name__ == "__main__":
    nums = [2, 2, 1, 1, 3, 4, 5, 5, 4]
    solution = Solution()
    print(solution.singleNumber(nums))

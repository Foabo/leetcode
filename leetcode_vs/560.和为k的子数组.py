#
# @lc app=leetcode.cn id=560 lang=python3
#
# [560] 和为K的子数组
#
from typing import List
# @lc code=start


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        mp = {0: 1}
        pre = 0
        count = 0
        for i in range(len(nums)):
            pre += nums[i]
            if pre-k in mp:
                count += mp[pre-k]
            if pre in mp:
                mp[pre] += 1
            else:
                mp[pre] = 1

        return count


# @lc code=end
if __name__ == "__main__":
    nums = [1, 1, 1, 1]
    solution = Solution()
    print(solution.subarraySum(nums, 2))

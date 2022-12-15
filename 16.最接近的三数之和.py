#
# @lc app=leetcode.cn id=16 lang=python3
#
# [16] 最接近的三数之和
#

# @lc code=start
import sys


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        mp = {}
        size = len(nums)

        nums.sort()
        ans, min_dist = nums[0]+nums[1]+nums[2], sys.maxsize

        for i in range(size):
            mp[nums[i]] = i
        for first in range(size - 2):
            if i > 0 and nums[first] == nums[first-1]:
                continue
            second = first+1
            third = size - 1
            while second < third:
                k = nums[first] + nums[second] + nums[third]
                if k == target:
                    return target
                dist = abs(target-k)
                if dist < min_dist:
                    ans = k
                    min_dist = dist
                if k >= target:
                    third0 = third - 1
                    while second < third0 and nums[third] == nums[third0]:
                        third0 -= 1
                    third = third0
                else:
                    second0 = second + 1
                    while second0 < third and nums[second0] == nums[second]:
                        second0 += 1
                    second = second0

        return ans
# @lc code=end

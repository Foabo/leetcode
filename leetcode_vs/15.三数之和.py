#
# @lc app=leetcode.cn id=15 lang=python3
#
# [15] 三数之和
#
from typing import List
# @lc code=start


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        size = len(nums)
        res = []
        if size < 3:
            return []

        def check(frist, second, third):
            if nums[first] + nums[second] + nums[third] == 0:
                res.append([nums[first], nums[second], nums[third]])

        for first in range(size):
            if first > 0 and nums[first] == nums[first - 1]:
                continue
            third = size - 1
            for second in range(first + 1, size):
                if second > first + 1 and nums[second] == nums[second - 1]:
                    continue
                while second < third and nums[first] + nums[second] + nums[third] > 0:
                    third -= 1
                if second == third:
                    break
                check(first, second, third)
        return res


# @lc code=end
if __name__ == "__main__":
    # a, b, c = map(int, input().split())
    # # 6种输出 但其实两种情况 分为a>b和a<=b
    # if a > b:
    #     if b > c:
    #         print("{:0.2f}>={:0.2f}>={:0.2f}".format(a, b, c))
    #     elif a > c:
    #         print("{:0.2f}>={:0.2f}>={:0.2f}".format(a, c, b))
    #     else:
    #         print("{:0.2f}>={:0.2f}>={:0.2f}".format(c, a, b))
    # else:
    #     if c > b:
    #         print("{:0.2f}>={:0.2f}>={:0.2f}".format(c, b, a))
    #     elif c > a:
    #         print("{:0.2f}>={:0.2f}>={:0.2f}".format(b, c, a))
    #     else:
    #         print("{:0.2f}>={:0.2f}>={:0.2f}".format(b, a, c))

    nums = list(map(int, input().split()))
    nums.sort(reverse=True)
    print("{:0.2f}>={:0.2f}>={:0.2f}".format(nums[0], nums[1], nums[2]))
    

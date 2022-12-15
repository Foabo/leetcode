#
# @lc app=leetcode.cn id=1431 lang=python3
#
# [1431] 拥有最多糖果的孩子
#

# @lc code=start


class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        maxNum = 0
        res = []
        for candie in candies:
            if candie > maxNum:
                maxNum = candie
        for candie in candies:
            if candie + extraCandies >= maxNum:
                res.append(True)
            else:
                res.append(False)
        return res
# @lc code=end

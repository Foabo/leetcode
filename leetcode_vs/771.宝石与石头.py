#
# @lc app=leetcode.cn id=771 lang=python3
#
# [771] 宝石与石头
#

# @lc code=start


class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        mp_j = {}
        for j in J:
            mp_j[j] = 0
        for s in S:
            if s in mp_j:
                mp_j[s] += 1
        count = 0
        for j in mp_j:

            count += mp_j[j]
        return count
# @lc code=end

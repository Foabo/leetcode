#
# @lc app=leetcode.cn id=14 lang=python3
#
# [14] 最长公共前缀
#

# @lc code=start
import sys


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        row = len(strs)
        if row == 0:
            return ""
        if row == 1:
            return strs[0]
        col = sys.maxsize
        length = 0
        flag = True
        for s in strs:
            col = min(col, len(s))

        for j in range(col):
            same = strs[0][j]
            for i in range(row):
                if strs[i][j] != same:
                    flag = False
                    break
            if flag:
                length += 1
            else:
                break
        return strs[0][0:length] if length else ""
# @lc code=end

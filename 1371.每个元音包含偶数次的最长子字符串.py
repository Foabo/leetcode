#
# @lc app=leetcode.cn id=1371 lang=python3
#
# [1371] 每个元音包含偶数次的最长子字符串
#

# @lc code=start


class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        res = status = 0
        n = len(s)
        # pos记录status对应的第一次出现的位置
        pos = [-1]*(1 << 5)
        pos[0] = 0
        for i in range(n):
            if s[i] == 'a':
                status ^= 1 << 0
            elif s[i] == 'e':
                status ^= 1 << 1
            elif s[i] == 'i':
                status ^= 1 << 2
            elif s[i] == 'o':
                status ^= 1 << 3
            elif s[i] == 'u':
                status ^= 1 << 4
            # i+1-pos[status]得出子串长度
            if pos[status] != -1:
                res = max(res, i+1-pos[status])
            else:
                # 奇偶性为status的为-1，即32个状态都第一次出现的
                pos[status] = i+1

        return res
# @lc code=end

#
# @lc app=leetcode.cn id=1002 lang=python3
#
# [1002] 查找常用字符
#

# @lc code=start


class Solution:
    def commonChars(self, A: List[str]) -> List[str]:
        minfreq = [float("inf")]*26
        res = []
        for s in A:
            freq = [0]*26
            for c in s:
                freq[ord(c)-ord('a')] += 1
            for i in range(26):
                minfreq[i] = min(freq[i], minfreq[i])
        for i in range(26):
            
            res.extend([chr(i+ord('a'))]*minfreq[i])
        return res
# @lc code=end

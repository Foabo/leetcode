#
# @lc app=leetcode.cn id=5 lang=python3
#
# [5] 最长回文子串
#

# @lc code=start


class Solution:
    def longestPalindrome(self, s: str) -> str:
        length = len(s)
        if length < 2:
            return s

        dp = [[False for _ in range(length)]for _ in range(length)]
        for i in range(length):
            dp[i][i] = True

        maxLength = 1
        start = 0

        for j in range(1, length):
            for i in range(j+1):
                if s[i] == s[j] and (j-i < 3 or dp[i+1][j-1]):
                    dp[i][j] = True
                else:
                    dp[i][j] = False

                if dp[i][j] and j-i+1 > maxLength:
                    maxLength = j-i+1
                    start = i

        return s[start:start+maxLength]

# @lc code=end

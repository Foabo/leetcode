#
# @lc app=leetcode.cn id=680 lang=python3
#
# [680] 验证回文字符串 Ⅱ
#


# @lc code=start


class Solution:
    def isCircle(self, s: str) -> bool:
        for i in range(len(s)//2):
            if s[i] != s[(-i)-1]:
                return False
        return True

    def ff(self, str, num):
        return str[:num] + str[num+1:]

    def validPalindrome2(self, s: str) -> bool:
        # new_str = test_str.replace(test_str[3], "", 1)
        for i in range(len(s)):
            if s[i] != s[(-i)-1]:
                s1 = self.ff(s, i)
                s2 = self.ff(s, len(s)-1-i)
                if self.isCircle(s1) or self.isCircle(s2):
                    return True

                return False
        return True

    def validPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        def isPalindrome(x): return x == x[::-1]
        left, right = 0, len(s) - 1
        while left <= right:
            if s[left] == s[right]:
                left += 1
                right -= 1
            else:
                return isPalindrome(s[left + 1: right + 1]) or isPalindrome(s[left: right])
        return True


# @lc code=end
if __name__ == "__main__":
    solution = Solution()
    print(solution.validPalindrome("bebebsafaf"))

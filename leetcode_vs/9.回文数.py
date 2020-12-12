#
# @lc app=leetcode.cn id=9 lang=python3
#
# [9] 回文数
#

# @lc code=start


class Solution:
    def isPalindrome(self, x: int) -> bool:
        num = []
        if x < 0:
            return False
        while x != 0:
            num.append(x % 10)
            x = x // 10
        left, right = 0, len(num) - 1
        print(num)
        while left < right:
            if num[left] != num[right]:
                return False
            left += 1
            right -= 1
        return True


# @lc code=end
if __name__ == "__main__":
    solution = Solution()
    print(solution.isPalindrome(121))

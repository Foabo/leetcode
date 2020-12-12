#
# @lc app=leetcode.cn id=67 lang=python3
#
# [67] 二进制求和
#
from collections import deque
# @lc code=start


class Solution:
    def addBinary(self, a: str, b: str) -> str:
        # c = 0
        # if len(a) < len(b):
        #     a, b = b, a

        # res = ""
        # len_a, len_b = len(a), len(b)

        # while len_b > 0:

        #     plus = int(a[len_a - 1]) + int(b[len_b - 1]) + c
        #     len_a -= 1
        #     len_b -= 1
        #     if plus > 1:
        #         c = 1
        #     else:
        #         c = 0

        #     res = str(plus % 2) + res

        # while len_a > 0:
        #     plus = int(a[len_a - 1]) + c
        #     len_a -= 1
        #     if plus == 2:
        #         c == 1
        #     else:
        #         c = 0
        #     res = str(plus % 2) + res
        # if c == 1:
        #     res = "1"+res
        # return res
        x, y = int(a, 2), int(b, 2)
        while y:
            answer = x ^ y
            carry = (x & y) << 1
            x, y = answer, carry
        return bin(x)[2:]



# @lc code=end


if __name__ == "__main__":
    solution = Solution()
    print(solution.addBinary("1010", "11110"))

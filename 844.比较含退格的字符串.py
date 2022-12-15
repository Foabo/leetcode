# @before-stub-for-debug-begin
from python3problem844 import *
from typing import *
# @before-stub-for-debug-end

#
# @lc app=leetcode.cn id=844 lang=python3
#
# [844] 比较含退格的字符串
#

# @lc code=start


class Solution:
    def backspaceCompare1(self, S: str, T: str) -> bool:
        n = len(S)
        m = len(T)

        S_stack = []
        T_stack = []
        for i in range(n):
            if S[i] == '#':
                if S_stack:
                    S_stack.pop()
            else:
                S_stack.append(S[i])
        for i in range(m):
            if T[i] == '#':
                if T_stack:
                    T_stack.pop()
            else:
                T_stack.append(T[i])
        if len(S_stack) != len(T_stack):
            return False
        for i in range(len(S_stack)):
            if S_stack[i] != T_stack[i]:
                return False
        return True

    def backspaceCompare(self, S: str, T: str) -> bool:
        n = len(S)-1
        m = len(T)-1
        skip_s, skip_t = 0, 0
        while n >= 0 or m >= 0:

            while n >= 0:
                if S[n] == '#':
                    skip_s += 1
                    n -= 1
                elif skip_s > 0:
                    skip_s -= 1
                    n -= 1
                else:
                    break

            while m >= 0:
                if T[m] == '#':
                    skip_t += 1
                    m -= 1
                elif skip_t > 0:
                    skip_t -= 1
                    m -= 1
                else:
                    break

            if n >= 0 and m >= 0:
                if S[n] != T[m]:
                    return False
            else:
                if n >= 0 or m >= 0:
                    return False

            n -= 1
            m -= 1
        return True


# @lc code=end

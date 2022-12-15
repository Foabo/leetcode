#
# @lc app=leetcode.cn id=509 lang=python3
#
# [509] 斐波那契数
#

# @lc code=start


class Solution:
    def __init__(self, *args, **kwargs):
        self.mp = {}

    def fib(self, N: int) -> int:
        if N in self.mp:
            return self.mp[N]
        if N < 2:
            res = N
        else:
            res = self.fib(N - 1) + self.fib(N - 2)
        self.mp[N] = res
        return res

# @lc code=end

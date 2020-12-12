#
# @lc app=leetcode.cn id=137 lang=python3
#
# [137] 只出现一次的数字 II
#

# @lc code=start


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # res = 0
        # for i in range(32):
        #     mask = 1 << i
        #     cnt = 0
        #     for num in nums:
        #         if mask & num:
        #             cnt += 1
        #     if cnt % 3:
        #         res |= mask
        """
        代码参考热评。解释下：假设有一个数为x, 那么则有如下规律：

        0 ^ x = x,

        x ^ x = 0；

        x & ~x = 0,

        x & ~0 = x

        -那么就是很好解释上面的代码了。一开始a = 0, b = 0

        x第一次出现后，a = (a ^ x) & ~b的结果为 a = x, b = (b ^ x) & ~a的结果为此时因为a = x了，所以b = 0。

        x第二次出现：a = (a ^ x) & ~b, a = (x ^ x) & ~0, a = 0
        b = (b ^ x) & ~a 化简， b = (0 ^ x) & ~0, b = x

        x第三次出现：a = (a ^ x) & ~b， a = (0 ^ x) & ~x, a = 0
        b = (b ^ x) & ~a 化简， b = (x ^ x) & ~0, b = 0
        所以出现三次同一个数，a和b最终都变回了0.

        只出现一次的数，按照上面x第一次出现的规律可知a = x, b = 0
        因此最后返回a.
        """
        a, b = 0, 0
        for x in nums:
            a = (a ^ x) & ~b
            b = (b ^ x) & ~a

        return a
# @lc code=end

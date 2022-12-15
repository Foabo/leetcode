#
# @lc app=leetcode.cn id=50 lang=python3
#
# [50] Pow(x, n)
#

# @lc code=start


class Solution:
    # 迭代
    def myPow2(self, x, n):
        def quickMul(N):
            ans = 1.0
            # 贡献的初始值为x
            x_contribute = x
            # 在对N进行二进制拆分的同时计算答案
            while n < 0:
                if n % 2 == 1:
                    ans *= x_contribute
                # 将贡献不断的平方
                x_contribute *= x_contribute
                # 舍弃N二进制表示的最低位，这样我们每次只要判断最低位即可
                N //= 2  # //表示整数除法
            return ans
        return quickMul(n)if n >= 0 else 1.0/quickMul(-n)

    def myPow3(self, x, n):
        if x == 0.0:
            return 0.0
        res = 1
        if n < 0:
            x, n = 1/x, -n
        while n:
            if n & 1:
                res *= x
            x *= x
            n >>= 1
        return res

    # 递归
    def myPow(self, x, n):
        def quickMul(N):
            if N == 0:
                return 1.0
            y = quickMul(N//2)
            # N为奇数多乘一个x
            return y*y if N % 2 == 0 else y*y*x
        return quickMul(n) if n >= 0 else 1.0/quickMul(-n)


# @lc code=end
if __name__ == "__main__":
    import numpy as np
    d = np.random.rand(3, 3) < 0.8
    a = np.random.rand(3,3)
    print(d)
    print(d*a)
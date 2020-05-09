import math


class Solution:

    # 袖珍计算器法
    def mySqrt1(self, x):
        if x == 0:
            return 0
        res = int(math.exp(0.5*math.log(x)))
        # 考虑误差
        return res+1 if (res+1)**2 <= x else res

    # 二分查找
    def mySqrt2(self, x):
        if x == 0:
            return 0
        l, r, res = 0, x, -1

        while l <= r:
            mid = (l+r)/2
            if mid**2 <= x:
                res = mid
                l = mid + 1
            else:
                r = mid - 1
        return res

    #牛顿迭代
    #f(x) = x^2+C,这里容易引起歧义，输入的x变量为C，输出的结果为x
    def mySqrt3(self, x):
        if x == 0:
            return 0

        C,x0 = float(x),float(x)
        while True:
            xi = 0.5*(x0 +C/x0)
            #阈值
            if abs(x0-xi)<1e-7:
                break
            x0=xi
        return int(x0)

        


if __name__ == "__main__":
    pass

class Solution:
    def __init__(self):
        self.res = 0

    def sumNums2(self, n: int) -> int:
        n > 1 and self.sumNums2(n - 1)
        self.res += n
        return self.res

    def sumNums(self, n: int) -> int:

        return self.helper(n, n+1) >> 1

    def helper(self, a, b):
        # a*2 b/2
        res = 0
        b and b & 1 and res = a and res + res += self.helper(a << 1, b >> 1)
        return 

if __name__ == "__main__":
    solution = Solution()
    print(solution.sumNums(10))

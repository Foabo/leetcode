#
# @lc app=leetcode.cn id=974 lang=python3
#
# [974] 和可被 K 整除的子数组
#
from typing import List

# @lc code=start


class Solution:
    def TLM_subarraysDivByK(self, A: List[int], K: int) -> int:
        size = len(A)
        dp = [[0 for _ in range(size)]for _ in range(size)]
        dp[0][0] = A[0]
        pre = A[0]
        count = 0
        if pre % K == 0:
            count += 1
        for j in range(1, size):
            dp[0][j] = pre+A[j]
            pre = dp[0][j]
            if pre % K == 0:
                count += 1
            for i in range(1, j+1):
                dp[i][j] = dp[i-1][j]-dp[i-1][i-1]
                if dp[i][j] % K == 0:
                    count += 1

        return count

    def subarraysDivByK(self, A: List[int], K: int) -> int:
        mp = {0: 1}
        pre_sum = 0
        count = 0
        for i in range(len(A)):
            pre_sum = (A[i]+pre_sum) % K
            if pre_sum in mp:
                count += mp[pre_sum]
                mp[pre_sum] += 1
            else:
                mp[pre_sum] = 1
        return count


# @lc code=end
if __name__ == "__main__":
    A = [4, 5, 0, -2, -3, 1]
    solution = Solution()
    print(solution.subarraysDivByK(A, 5))

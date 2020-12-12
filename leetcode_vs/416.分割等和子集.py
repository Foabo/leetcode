#
# @lc app=leetcode.cn id=416 lang=python3
#
# [416] 分割等和子集
#
from typing import List
# @lc code=start


class Solution:
    def canPartition2(self, nums: List[int]) -> bool:
        n = len(nums)
        if n < 2:
            return False
        sum = 0
        max_num = 0
        for num in nums:
            sum += num
            if max_num < num:
                max_num = num
        target = sum//2

        if sum % 2 or max_num > target:
            return False
        # dp[i][j]表示0...i中和为j的情况
        dp = [[True]+[False]*target for _ in range(n)]
        if target >= nums[0]:
            dp[0][nums[0]] = True
        for i in range(1, n):
            for j in range(1, target+1):
                if j < nums[i]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j-nums[i]] | dp[i-1][j]
        return dp[-1][-1]

    def canPartition(self, nums: List[int]) -> bool:
        n = len(nums)
        if n < 2:
            return False
        sum = 0
        max_num = 0
        for num in nums:
            sum += num
            if max_num < num:
                max_num = num
        target = sum//2

        if sum % 2 or max_num > target:
            return False
        # dp[i][j]表示0...i中和为j的情况
        dp = [True]+[False]*target

        for i in range(1, n):
            for j in range(target, nums[i]-1, -1):
                if dp[target]:
                    return True
                dp[j] = dp[j-nums[i]] | dp[j]
        return dp[-1]


# @lc code=end
if __name__ == "__main__":
    dp = [[True]+[False]*3 for _ in range(4)]
    print(dp)

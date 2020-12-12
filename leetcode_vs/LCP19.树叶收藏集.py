class Solution:
    def minimumOperations(self, leaves: str) -> int:
        n = len(leaves)
        dp = [[0, 0, 0] for _ in range(n)]
        dp[0][0] = int(leaves[0] == 'y')
        dp[0][1] = dp[0][2] = dp[1][2] = float("inf")
        for i in range(1, n):
            y = int(leaves[i] == 'y')
            dp[i][0] = dp[i-1][0]+y
            dp[i][1] = min(dp[i-1][0], dp[i-1][1])+(y ^ 1)
            if i >= 2:
                dp[i][2] = min(dp[i-1][1], dp[i-1][2])+y
        return dp[n-1][2]
    


if __name__ == "__main__":
    s = Solution()
    s.minimumOperations('rrryyy')

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {

    public int coinChange(int[] coins, int amount) {
        // 1. 确定base case ，目标金额amount为0的时候返回0
        // 2. 确定状态，原问题和子问题变化的量，只有一个amount
        // 3. 选择，每选择一枚硬币，目标金额amount都减少了
        // 4. dp[amount]的含义：金额为amount最少要多少个硬币

        // int[] dp = new int[amount+1];
        // Arrays.fill(dp, -1);
        // dfs(coins, amount, dp);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子問題無解，跳過
                if (i - coin < 0) {
                    continue;
                }
                // 分为选择还是不选择
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[amount] == amount + 1)
            return -1;
        return dp[amount];

    }

    public int dfs(int[] coins, int amount, int[] dp) {

        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (dp[amount] != 0) {
            return dp[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 选这个硬币还是不选择？
            int subProblem = dfs(coins, amount - coin, dp);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subProblem);

        }
        if (res != Integer.MAX_VALUE)
            dp[amount] = res;
        else {
            dp[amount] = -1;
        }
        return dp[amount];

    }
}
// @lc code=end

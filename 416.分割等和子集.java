/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            if(max<num)max= num;
        }
        int target = sum/2;

        if(sum%2==1||max>target){
            return false;
        }
        if(max==target)return true;
        // dp表示0.。i的数中和为j的有没有
        boolean[][] dp = new boolean[n][target+1];
        dp[0][nums[0]]=true;
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                // 对当前j可以选择nums[i]
                if(j-nums[i]>=0){
                    // 分为 选择和不选择两种情况,
                    // 找到i前面有没有数的和加起来再加上nums[i]和为j
                    // 如果dp[i-1][j]可以满足情况
                    dp[i][j] = dp[i-1][j-nums[i]]||dp[i-1][j];
                }
                // 不选择nums[i]
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];
    }
}
// @lc code=end


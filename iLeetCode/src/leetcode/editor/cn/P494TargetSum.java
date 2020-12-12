//
//You are given a list of non-negative integers, a1, a2, ..., an, and a target, 
//S. Now you have 2 symbols + and -. For each integer, you should choose one from 
//+ and - as its new symbol.
// 
//
// Find out how many ways to assign symbols to make sum of integers equal to tar
//get S. 
// 
//
// Example 1: 
// 
//Input: nums is [1, 1, 1, 1, 1], S is 3. 
//Output: 5
//Explanation: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//There are 5 ways to assign symbols to make the sum of nums be target 3.
// 
// 
//
// Note: 
// 
// The length of the given array is positive and will not exceed 20. 
// The sum of elements in the given array will not exceed 1000. 
// Your output answer is guaranteed to be fitted in a 32-bit integer. 
// 
// Related Topics 深度优先搜索 动态规划


package leetcode.editor.cn;

//Java：目标和
public class P494TargetSum {
    public static void main(String[] args) {
        Solution solution = new P494TargetSum().new Solution();
        // TO TEST
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(solution.findTargetSumWays(nums, S));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int count = 0;

        public void dfs(int[] nums, int i, int s, int sum) {

            int sum1 = sum + nums[i];
            int sum2 = sum - nums[i];
            if (i == nums.length - 1) {
                if (sum1 == s) {
                    count++;
                }
                if (sum2 == s) {
                    count++;
                }
            }
            if (i < nums.length - 1) {
                dfs(nums, i + 1, s, sum1);
                dfs(nums, i + 1, s, sum2);
            }
        }

        public int dfs_findTargetSumWays(int[] nums, int S) {

            dfs(nums, 0, S, 0);
            return count;
        }

        // dp方法
        public int dp_findTargetSumWays(int[] nums, int S) {
            int[][] dp = new int[nums.length][2001];
            dp[0][1000 + nums[0]] = 1;
            // nums[0]=0时是特殊情况，所以要+=1
            dp[0][1000 - nums[0]] += 1;

            for (int i = 1; i < nums.length; i++) {
                for (int sum = -1000; sum <= 1000; sum++) {
                    // 前i-1项和为sum的数目为0，就不用加了
                    if (dp[i - 1][sum + 1000] > 0) {
                        dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                        dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                    }
                }
            }
            return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
        }

        // 优化的dp，将二维数组转为1维,使用两个一维数组，一个保存正的，一个保存负的
        public int findTargetSumWays(int[] nums, int S) {
            int[] dp = new int[2001];
            dp[nums[0] + 1000] = 1;
            dp[-nums[0] + 1000] += 1;

            for (int i = 1; i < nums.length; i++) {
                int[] next = new int[2001];
                for (int sum = -1000; sum <= 1000; sum++) {
                    if (dp[sum + 1000] > 0) {
                        next[sum + nums[i] + 1000] += dp[sum + 1000];
                        next[sum - nums[i] + 1000] += dp[sum + 1000];
                    }
                }
                dp = next;
            }
            return S > 1000 ? 0 : dp[S + 1000];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
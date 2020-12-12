/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {

    public int maxSubArray2(int[] nums) {

        int len = nums.length;
        // dp 表示i-j最大的和
        // int[] dp = new int[len];
        // dp[0] = nums[0];
        // int max_sum = dp[0];
        int pre = nums[0], max_sum = nums[0];
        for (int i = 1; i < len; i++) {
            // 两个状态，选择当前和不选择当前
            pre = Math.max(pre + nums[i], nums[i]);
            if (pre > max_sum)
                max_sum = pre;
        }
        return max_sum;
    }

    // 分治法
    public int maxSubArray(int[] nums) {

        int len = nums.length;

        return maxSubArrayHelper(nums, 0, len - 1);
    }

    public int maxSubArrayHelper(int[] nums,int left,int right ) {
        // 三种情况
        // 1、子序列在中心左边
        // 2、子序列在中心右边
        // 3、子序列跨中心
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        // 返回三种情况的最大值
        return Math.max(maxSubArrayHelper(nums, left, mid),
                Math.max(
                    maxSubArrayHelper(nums, mid + 1, right), 
                    maxCrossingHelper(nums, left, mid, right)));

    }
    
    private int maxCrossingHelper(int[] nums, int left, int mid, int right) {
        // 一定会包含 nums[mid] 这个元素
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // 左半边包含 nums[mid] 元素，最多可以到什么地方
        // 走到最边界，看看最值是什么
        // 计算以 mid 结尾的最大的子数组的和
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        // 右半边不包含 nums[mid] 元素，最多可以到什么地方
        // 计算以 mid+1 开始的最大的子数组的和
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

  
}
// @lc code=end

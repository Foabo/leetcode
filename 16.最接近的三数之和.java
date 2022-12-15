/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);
        int res = 0;
        int gap = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // 因为不允许重复的三元组
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1, k = n - 1; j < k; j++) {
                // 对当前j找到一个最小的k
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                while (j < k - 1 && nums[j] + nums[k - 1] + nums[i] >= target) {
                    k--;
                }

                int a1 = nums[j] + nums[k] + nums[i];
                int gap1 = Math.abs(a1 - target);
                if (gap1 < gap) {
                    gap = gap1;
                    res = a1;
                }
                if (k - 1 > j) {
                    int a2 = nums[j] + nums[k - 1] + nums[i];
                    int gap2 = target - a2;
                    if (gap2 < gap) {
                        res = a2;
                    }
                }
               

                
            }
        }
        return res;

    }
}
// @lc code=end

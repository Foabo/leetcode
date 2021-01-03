/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            // 因为不允许重复的三元组
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n; j++) {
                // 对当前j找到一个最小的k使三个数加起来大于等于0
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                for (int k = j + 1, u = n - 1; k < u; k++) {
                    if (k >j+1  && nums[k] == nums[k - 1])
                        continue;
                    while (k < u-1 && nums[i] + nums[j] + nums[k] + nums[u - 1] >= target)
                        u--;
                    if (nums[i] + nums[j] + nums[k] + nums[u] == target) {
                        ArrayList lst = new ArrayList<>();
                        lst.add(nums[i]);
                        lst.add(nums[j]);
                        lst.add(nums[k]);
                        lst.add(nums[u]);
                        res.add(lst);
                    }
                    
                    
                }
            }

        }
        return res;
    }
}
// @lc code=end

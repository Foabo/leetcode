import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            // 因为不允许重复的三元组
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int c = -nums[i];
            for (int j = i + 1, k = n - 1; j < k; j++) {
                // 对当前j找到一个最小的k使三个数加起来大于等于0
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                while (j < k - 1 && nums[j] + nums[k-1] >= c) {
                    k--;
                }
                if (nums[j] + nums[k] == c) {
                    ArrayList lst = new ArrayList<>();
                    lst.add(nums[i]);
                    lst.add(nums[j]);
                    lst.add(nums[k]);
                    res.add(lst);
                }
            }
        }
        return res;
    }
}
// @lc code=end

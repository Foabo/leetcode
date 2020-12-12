import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return 0;
        Arrays.sort(nums);
        int pre = nums[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            int tmp = nums[i] - pre;
            tmp = tmp >= 0 ? tmp : -tmp;
            if (max < tmp)
                max = tmp;
            pre = nums[i];
        }
        
        return max;
    }
}
// @lc code=end


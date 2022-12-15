/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = weights[0];
        int right = 0;
        for (int w : weights) {
            right += w;
        }
        right += 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinsh(weights, mid, D)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public boolean canFinsh(int[]weights,int cap,int D) {
        
        // 最低载重为cap，能否在D天完成
        int i = 0;
        for (int d = 0; d < D; d++) {
            int maxWeight = cap;
            while (maxWeight >= weights[i]) {
                maxWeight -= weights[i];
                i++;
                if (i == weights.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end


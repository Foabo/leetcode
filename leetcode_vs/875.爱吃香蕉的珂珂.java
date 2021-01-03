/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max = 0;
        for (int pile : piles) {
            if (max < pile) {
                max = pile;
            }
        }
        int l = 1,r = max+1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (canFinsh(piles, m, H)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public boolean canFinsh(int[] piles, int speed, int H) {
        int sum = 0;
        for (int pile : piles) {
            int t = pile % speed;
            int c = pile / speed;
            if (t > 0)
                c += 1;
            sum += c;
        }
        return sum <= H;
    }

}
// @lc code=end


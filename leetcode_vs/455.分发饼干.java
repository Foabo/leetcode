import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m = g.length;
        int n = s.length;

        int i = 0, j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < m && j < n) {
            // 每个孩子最多只能给一块饼干
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }

        return i;
    }
}
// @lc code=end


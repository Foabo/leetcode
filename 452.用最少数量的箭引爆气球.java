/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots1(int[][] points) {
        if (points.length == 0)
            return 0;
        // 对points有边界进行排序
        Arrays.sort(points, (p1, p2) -> p1[1] < p2[1] ? -1 : 1);
        int n = points.length;
        int i = 0;
        boolean[] burst = new boolean[n];
        int cnt = 0;
        while (i < n && burst[i] == false) {
            int flag = points[i][1];
            for (int j = i; j < n; j++) {
                // 对当前第j个气球，左边界points[j][0]表示<flag
                // 可以把它射爆
                i = j;
                if (points[j][0] <= flag) {
                    burst[j] = true;
                }
                // 否则进入下一个循环
                else {
                    break;
                }

            }
            cnt++;
        }
        return cnt;
    }
    
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, (p1, p2) -> p1[1] < p2[1] ? -1 : 1);
        int res = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pre) {
                res++;
                pre = points[i][1];
            }
        }
        return res;

    }
}
// @lc code=end

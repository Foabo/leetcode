import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // 给intervals数组按照右边界进行排序
        Arrays.sort(intervals, (int[] p1, int[] p2) -> {
            if (p1[1] < p2[1]) {
                return -1;
            } else if (p1[1] > p2[1]) {
                return 1;
            } else {
                return p1[0] - p2[0];
            }
        });
   
        int i = 0, cnt = 0;
        int n = intervals.length;
        // 数组随着右边界排序，右边界相同的按照左边界小的在前面
        // 对每一个i，flag为它的右边界的值
        // 只要下一个区间的左边界小于它的右边界，跳过下一个区间
        if (n < 2)
            return 0;
        // i要小于n-1，因为最后一个区间没有后续区间了
        while (i < n-1) {
            int flag = intervals[i][1];
            for (int j = i+1; j < n; j++) {
                i = j;
                if (intervals[j][0] < flag) {
                    cnt++;
                } else {
                    break;
                }
            }
        }
        return cnt;
    }
}
// @lc code=end

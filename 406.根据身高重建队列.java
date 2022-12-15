import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 第一步，按照身高从大到小先排序
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] p : people)
            list.add(p[1], p);
        return list.toArray(new int[0][2]);

    }
}
  // @lc code=end


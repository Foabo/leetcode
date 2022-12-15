import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1046 lang=java
 *
 * [1046] 最后一块石头的重量
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                return j - i;
            }
        });
        for (int stone : stones) {
            queue.offer(stone);
        }
        while ( queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            int res = Math.abs(a - b);
            if (res > 0)
                queue.offer(res);
            
        }
        if (queue.isEmpty())
            return 0;
        else {
            return queue.peek();
        }
    }
}
// @lc code=end


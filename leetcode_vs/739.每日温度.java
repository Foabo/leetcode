import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() &&  T[deque.peekLast()]<=T[i]) {
                deque.pollLast();
            }
            res[i]=deque.isEmpty()?0:(deque.peekLast()-i);
            deque.offerLast(i);
        }
        return res;
    }
}
// @lc code=end


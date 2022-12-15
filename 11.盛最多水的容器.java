import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // 单调栈
        // Deque<Integer> deque = new LinkedList<>();
        
        // for (int i = 0; i < height.length; i++) {
        //     while (!deque.isEmpty() && height[i] > height[deque.peekLast()]) {
        //         deque.pollLast();
        //     }
        //     deque.offerLast(i);
        // }
        // int left = deque.peekFirst();
        // int right = deque.peekLast();
        // return (right - left) * Math.min(height[left], height[right]);
        int n = height.length;
        int i = 0, j = n - 1;
        int res = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                res = Math.max(res, (j - i) * height[i]);
                i++;

            }
            else {
                res = Math.max(res, (j - i) * height[j]);
                
                j--;
            }
        }
        return res;
    }
}
// @lc code=end

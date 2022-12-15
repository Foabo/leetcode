import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow1(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        ArrayList
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] o1, int[] o2) -> {
            if (o1[0] > o2[0]) {
                return -1;
            } else if (o1[0] < o2[0])
                return 1;
            else
                return 0;
        });
        for (int i = 0; i < k; i++) {
            queue.offer(new int[] { nums[i], i });
        }
        int j = 0;
        res[j++] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[] { nums[i], i });
            // top是窗口的最大值数组
            int[] top = queue.peek();
            // 只有最大值不在滑动窗口才移除
            while (top[1] < i - k + 1) {
                queue.poll();
                top = queue.peek();
            }
            res[j++] = top[0];

        }
        return res;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        // 队列存放下标
        Deque<Integer> deque = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() < i - k + 1 ) {
                deque.pollFirst();
            }
        }
        res[j++] = nums[deque.peekFirst()];
        
        for (int i = k; i < nums.length; i++) {

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 队列头对应的值不在窗口中

            while (deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            
            res[j++] = nums[deque.peekFirst()];
        

        }
        return res;
    }

}
// @lc code=end

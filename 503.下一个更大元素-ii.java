import java.util.Deque;

/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        // 假装这个数组长度翻倍了
        for (int i = 2 * n - 1; i >= 0; i--) {
            // 索引要求模，其他的和模板一样
            while (!deque.isEmpty() && deque.peekLast() <= nums[i % n]) {
                deque.pollLast();
            }
            res[i % n] = deque.isEmpty() ? -1 : deque.peekLast();
            deque.offerLast(nums[i % n]);
        }
        return res;
    }
}
// @lc code=end

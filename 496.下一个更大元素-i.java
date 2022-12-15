import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.UnaryOp.Sqrt;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] next = new int[nums2.length];
        Deque<Integer> deque = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peekLast() <= nums2[i]) {
                deque.pollLast();
            }
            next[i] = deque.isEmpty() ? -1 : deque.peekLast();
            map.put(nums2[i], next[i]);
            deque.offerLast(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
// @lc code=end

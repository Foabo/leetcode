/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p, r;

        p = slow.next;
        slow.next = null;
        while (p != null) {
            r = p.next;
            p.next = slow.next;
            slow.next = p;
            p = r;
        }
        fast = slow.next;
        while (head != null && fast != null && head.val == fast.val) {
            head = head.next;
            fast = fast.next;
        }
        if (fast != null) {
            return false;
        }

        return true;
    }
}
// @lc code=end

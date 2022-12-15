/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // public class ListNode {
    // int val;
    // ListNode next;

    // ListNode() {
    // }

    // ListNode(int val) {
    // this.val = val;
    // }

    // ListNode(int val, ListNode next) {
    // this.val = val;
    // this.next = next;
    // }
    // }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        int count = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            count++;
        }
        int n = count / k;
        p = head;
        ListNode tail, cur_head, head_node, r, tmp;
        tail = new ListNode();
        head_node = tail;
        for (int i = 0; i < n; i++) {
            cur_head = tail;
            tmp = p;
            for (int j = 0; j < k; j++) {
                r = p.next;
                p.next = cur_head.next;
                cur_head.next = p;
                p = r;
            }
            // 最后面p=cur_head,tail=?
            // tail.next = cur_head.next;
            tmp.next = p;
            tail = tmp;

        }
        tail.next = p;
        return head_node.next;
    }
}
// @lc code=end

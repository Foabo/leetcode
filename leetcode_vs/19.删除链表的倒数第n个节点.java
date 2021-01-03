/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode headnode = new ListNode(-1, head);
        int m = 0;
        ListNode p = headnode;
        while (p != null) {
            p = p.next;
            m++;
        }
        p = headnode;
        for (int i = 0; i < m - n - 1; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return headnode.next;
    }
}
// @lc code=end


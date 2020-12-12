import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {

    // class ListNode {
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

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode head1 = head.next;
        // Map<Integer, ListNode> map = new HashMap<Integer,ListNode>();
        ArrayList<ListNode> list = new ArrayList<>();
        while (head1 != null) {
            // map.put(++count,head1.next);
            list.add(head1);
            head1 = head1.next;
        }
        int count = list.size();
        head1 = head;
        ListNode p;
        for (int i = 0; i < count / 2; i++) {
            p = list.get(count - i - 1);
            p.next = head1.next;
            head1.next = p;
            head1 = p.next;
        }
        if (count % 2 == 1) {
            head1.next.next = null;
        } else {
            head1.next = null;
        }

    }

}
// @lc code=end

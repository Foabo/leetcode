import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {

    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ListNode headnode = new ListNode();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode pre = headnode;
        for (Integer val : list) {
            ListNode p = new ListNode(val);
            pre.next = p;
            pre = p;

        }
        return headnode.next;
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList2(ListNode head, ListNode tail) {
        // 判断边界条件
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        // 快慢指针找到中点
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;

            if (fast != tail) {
                fast = fast.next;

            }

        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode list = merge(list1, list2);
        return list;

    }

    public ListNode sortList(ListNode head, ListNode tail) {
        // 判断边界条件
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;

    }

    public ListNode merge(ListNode head1, ListNode head2) {

        ListNode tmp1, tmp2;
        tmp1 = head1;
        tmp2 = head2;
        ListNode headnode = new ListNode();
        ListNode pre = headnode;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val < tmp2.val) {
                pre.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                pre.next = tmp2;
                tmp2 = tmp2.next;
            }
            pre = pre.next;
        }
        if (tmp1 != null) {
            pre.next = tmp1;
        } else if (tmp2 != null) {
            pre.next = tmp2;
        }
        return headnode.next;
    }

}
// @lc code=end

/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        // 判断边界
        if (head == null)
            return null;

        ListNode p = head.next;
        ListNode pre = head;
        ListNode headNode = new ListNode();
        headNode.next = head;
        int flag = 0;
        //对每一个当前的p，从头找到比他小的最后一个元素
        while (p != null) {
            // 从头遍历
            ListNode q = headNode;
            while (q.next != p) {
                 if (pre.val < p.val) {
                break;
            }
                // 如果要插入
                if (q.next.val > p.val) {
                    pre.next = p.next;
                    p.next = q.next;
                    q.next = p;
                    flag = 1;
                    break;
                }
                q = q.next;
            }
            // 如果不用插入
            if(flag==0){
                pre = p;
    
            }
            flag = 0;
            p = pre.next;
        }

        return headNode.next;

    }
}
// @lc code=end


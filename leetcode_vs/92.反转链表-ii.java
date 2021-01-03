/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dumy = new ListNode();
        dumy.next = head;
        int cnt = 1;
        ListNode pre =dumy;
        while (cnt < m) {
            pre = pre.next;
            cnt++;
        }
        // System.out.println(pre.val);
        // 此时cnt=m-1;pre=第m-1个节点
        // 翻转 p 后面的节点
        ListNode p = pre.next;
        ListNode tmp;
        while(cnt<n){
            tmp= p.next;
            p.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
            cnt++;
        }
        return dumy.next;
    }
}
// @lc code=end

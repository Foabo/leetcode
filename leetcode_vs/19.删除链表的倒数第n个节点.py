#
# @lc app=leetcode.cn id=19 lang=python3
#
# [19] 删除链表的倒数第N个节点
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        k = 0
        pre = head
        while head:
            head = head.next
            k += 1

        j = k-n
        if j == 0:
            return pre.next
        _head = pre
        head = pre
        for i in range(j):
            pre = head
            head = head.next
        pre.next = head.next

        return _head
# @lc code=end

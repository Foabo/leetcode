#
# @lc app=leetcode.cn id=2 lang=python3
#
# [2] 两数相加
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1:
            return l2
        if not l2:
            return l1
        pre = ListNode(0)
        cur = pre
        carry = 0
        cur_sum = 0
        while l1 or l2:
            if l1 and l2:
                cur_sum = l1.val+l2.val+carry
                l1 = l1.next
                l2 = l2.next
            elif not l1:
                cur_sum = l2.val+carry
                l2 = l2.next
            else:
                cur_sum = l1.val+carry
                l1 = l1.next
            carry = cur_sum//10
            cur_sum = cur_sum % 10
            cur.next = ListNode(cur_sum)
            cur = cur.next
        if carry:
            cur.next = ListNode(carry)
        return pre.next
# @lc code=end

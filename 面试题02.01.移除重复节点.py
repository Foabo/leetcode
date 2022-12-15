Definition for singly-linked list.


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def removeDuplicateNodes(self, head: ListNode) -> ListNode:
        if not head:
            return
        unq = []
        unq.append(head.val)
        pre = head
        cur = head.next
        while cur:
            if cur.val not in unq:
                unq.append(cur.val)
                pre = cur
                cur = cur.next
            else:
                pre.next = cur.next
                cur = cur.next
        return head
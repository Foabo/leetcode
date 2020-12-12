#
# @lc app=leetcode.cn id=25 lang=python3
#
# [25] K 个一组翻转链表
#


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def reverse(self, head: ListNode, tail: ListNode):
        prev = tail.next
        p = head
        while prev != tail:
            nex = p.next
            p.next = prev
            prev = p
            p = nex
        return tail, head

    def reverseKGroup2(self, head: ListNode, k: int) -> ListNode:
        hair = ListNode(0)
        hair.next = head
        pre = hair

        while head:
            tail = pre
            # 查看剩余部分长度是否大于等于 k
            for i in range(k):
                tail = tail.next
                if not tail:
                    return hair.next
            head, tail = self.reverse(head, tail)
            # 把子链表重新接回原链表
            pre.next = head
            pre = tail
            head = tail.next

    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        p = head
        count = 0
        while head:
            count += 1
            head = head.next
        n = count//k
        head_node = tail = cur_head = ListNode(0)
        for i in range(n):
            cur_head = tail
            tmp = p
            for _ in range(k):
                r = p.next
                p.next = cur_head.next
                cur_head.next = p
                p = r
            tail.next = cur_head.next
            tail = tmp
        tail.next = p
        return head_node.next


# @lc code=end
if __name__ == "__main__":
    head = ListNode(1)
    p = head
    p.next = ListNode(2)
    p = p.next
    p.next = ListNode(3)
    p = p.next
    p.next = ListNode(4)
    p = p.next
    p.next = ListNode(5)
    p = p.next
    p.next = ListNode(6)
    p = p.next
    p.next = ListNode(7)
    p = p.next
    solution = Solution()
    head = solution.reverseKGroup(head, 2)
    nums = []
    while head:
        nums.append(head.val)
        head = head.next
    print(nums)

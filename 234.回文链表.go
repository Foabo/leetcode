package leetcode_vs

/*
 * @lc app=leetcode.cn id=234 lang=golang
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func isPalindrome(head *ListNode) bool {
	if head == nil {
		return true
	}
	fast := head
	slow := head
	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	p := slow.Next
	slow.Next = nil
	for p != nil {
		r := p.Next
		p.Next = slow.Next
		slow.Next = p
		p = r
	}

	fast = slow.Next
	for head != nil && fast != nil && fast.Val == head.Val {
		head = head.Next
		fast = fast.Next

	}
	if fast != nil {
		return false
	}

	return true

}

// @lc code=end

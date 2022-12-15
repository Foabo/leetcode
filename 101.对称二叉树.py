#
# @lc app=leetcode.cn id=101 lang=python3
#
# [101] 对称二叉树
#


from collections import deque


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def rightOrder(self, root: TreeNode, rightStack: List[str]):
        if root is None:
            rightStack.append(None)
            return
        rightStack.append(root.val)
        self.rightOrder(root.right, rightStack)
        self.rightOrder(root.left, rightStack)

    def leftOrder(self, root: TreeNode, leftStack: List[str]):
        if root is None:
            leftStack.append(None)
            return
        leftStack.append(root.val)
        self.leftOrder(root.left, leftStack)
        self.leftOrder(root.right, leftStack)

    def isSymmetric1(self, root: TreeNode) -> bool:
        if root is None:
            return True
        left = root.left
        right = root.right
        leftStack = deque()
        rightStack = deque()
        self.leftOrder(left, leftStack)
        self.rightOrder(right, rightStack)
        for i in range(len(leftStack)):
            if leftStack[i] != rightStack[i]:
                return False

        return True

    def check(self, p: TreeNode, q: TreeNode):
        if p is None and q is None:
            return True
        if p is None or q is None:
            return False
        return p.val == q.val and self.check(p.left, q.right) and self.check(p.right, q.left)

    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:return True
        return self.check(root.left, root.right)

# @lc code=end

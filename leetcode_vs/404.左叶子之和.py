#
# @lc app=leetcode.cn id=404 lang=python3
#
# [404] 左叶子之和
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        res = 0

        def dfs(root, is_left):
            nonlocal res
            if not root.left and not root.right and is_left:
                res += root.val
                return
            if root.left:
                dfs(root.left, is_left=True)
            if root.right:
                dfs(root.right, is_left=False)

        is_left = False
        if not root:
            return 0
        if root.left:
            is_left = True

        dfs(root, is_left)
        return res
# @lc code=end

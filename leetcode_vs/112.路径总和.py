#
# @lc app=leetcode.cn id=112 lang=python3
#
# [112] 路径总和
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if not root:
            return False
        flag = False

        def order(root, cur_sum):
            nonlocal flag
            cur_sum += root.val
            if not root.left and not root.right:
                if sum == cur_sum:
                    flag = True
                return
            if root.left:
                order(root.left, cur_sum)
            if root.right:
                order(root.right, cur_sum)
        order(root, 0)
        return flag
# @lc code=end

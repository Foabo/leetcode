#
# @lc app=leetcode.cn id=235 lang=python3
#
# [235] 二叉搜索树的最近公共祖先
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        def find_p_or_q(root):
            if not root:
                return None
            if root == p or root == q:
                return root

            # 从当前节点出发,找到了左右两
            left = find_p_or_q(root.left)
            right = find_p_or_q(root.right)

            if left and right:
                return root
            elif left:
                return left
            elif right:
                return right
            else:
                return None
        return find_p_or_q(root)
# @lc code=end

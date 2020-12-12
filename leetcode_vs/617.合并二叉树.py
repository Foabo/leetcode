#
# @lc app=leetcode.cn id=617 lang=python
#
# [617] 合并二叉树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if not t1:
            return t2
        if not t2:
            return t1

        def dfs(root1, root2):
            # 终止条件
            if not root2:
                return
            # 当前位置下root1 root2都不为空
            root1.val += root2.val
            # 左子树为空
            if not root1.left:
                root1.left = root2.left
            else:
                dfs(root1.left, root2.left)
            # 右子树为空
            if not root1.right:
                root1.right = root2.right
            else:
                dfs(root1.right, root2.right)

        dfs(t1, t2)
        return t1
# @lc code=end

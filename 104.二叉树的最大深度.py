#
# @lc app=leetcode.cn id=104 lang=python
#
# [104] 二叉树的最大深度
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        
        def dfs(root):
            
            if not root:
                return 0
            cur_size = max(dfs(root.left), dfs(root.right))+1
            return cur_size
        return dfs(root)
# @lc code=end

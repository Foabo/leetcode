#
# @lc app=leetcode.cn id=530 lang=python3
#
# [530] 二叉搜索树的最小绝对差
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def getMinimumDifference(self, root: TreeNode) -> int:
        dist = float("inf")
        pre = -1
        
        def dfs(root):
            nonlocal dist, pre
            if not root:
                return
            dfs(root.left)
            # 中序遍历的第一个节点，值最小
            if pre != -1:
                dist = min(dist, root.val-pre)
            pre = root.val
            dfs(root.right)
        dfs(root)
        return dist
# @lc code=end

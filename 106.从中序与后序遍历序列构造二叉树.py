#
# @lc app=leetcode.cn id=106 lang=python3
#
# [106] 从中序与后序遍历序列构造二叉树
#


from typing import List


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
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:

        mp = {val: idx for idx, val in enumerate(inorder)}

        def order(istart: int, iend: int):
            if iend < istart:
                return None

            root = postorder.pop()  # int
            idx = mp[root]
            node = TreeNode(root)

            node.right = order(idx+1, iend)

            node.left = order(istart, idx-1)

            return node
        root = order(0, len(inorder)-1)
        return root


"""
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        mp = {val: idx for idx, val in enumerate(inorder)}
        iend = len(inorder)

        def order(istart: int, iend: int, pstart: int, pend: int):
            if istart > iend or pstart > pend:
                return None
            
            idx = mp[postorder[iend]]
            node = TreeNode(inorder[idx])
            node.left = order(istart, idx-1, pstart, pstart+idx-istart-1)
            node.right = order(idx+1, iend, pstart+idx-istart, pend-1)
            return node
        return order(0, iend-1, 0, iend-1)
"""
# @lc code=end

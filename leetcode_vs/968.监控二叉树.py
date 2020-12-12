#
# @lc app=leetcode.cn id=968 lang=python3
#
# [968] 监控二叉树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    # def is_leaf(self, root):
    #     if root.left is None and root.right is None:
    #         return True
    #     return False

    # def minCameraCover(self, root: TreeNode) -> int:

    #     res = 0
    #     if root is None:
    #         return res

    #     def dfs(root, flag):
    #         nonlocal res
    #         if self.is_leaf(root):
    #             return
    #         # if self.is_leaf(root.left) or self.is_leaf(root.right):
    #         # 当前层是叶子节点的父节点
    #         if (root.left and self.is_leaf(root.left)) or (root.right and self.is_leaf(root.right)):
    #             res += 1
    #             if root.left:
    #                 dfs(root.left, True)
    #             if root.right:
    #                 dfs(root.right, True)

    #         # 上一层没有监控,则这一层要有监控
    #         elif not flag:
    #             res += 1
    #             flag = True
    #             if root.left:
    #                 dfs(root.left, True)
    #             if root.right:
    #                 dfs(root.right, True)
    #         # 上一层有监控,这一层就不需要了
    #         else:
    #             flag = False
    #             if root.left:
    #                 dfs(root.left, False)
    #             if root.right:
    #                 dfs(root.right, False)
    #         # flag标记本层是否是监控
            
    #     if self.is_leaf(root):
    #         return 1
    #     else:
    #         dfs(root, True)

    #     return res
    def minCameraCover(self, root: TreeNode) -> int:
        def dfs(root: TreeNode) -> List[int]:
            if not root:
                return [float("inf"), 0, 0]

            la, lb, lc = dfs(root.left)
            ra, rb, rc = dfs(root.right)
            a = lc + rc + 1
            b = min(a, la + rb, ra + lb)
            c = min(a, lb + rb)
            return [a, b, c]

        a, b, c = dfs(root)
        return b




# @lc code=end

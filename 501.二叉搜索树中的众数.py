#
# @lc app=leetcode.cn id=501 lang=python3
#
# [501] 二叉搜索树中的众数
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findMode(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        res = []
        max_size = 0
        count = 0
        cur_num = None

        def dfs(root):

            if root.left:
                dfs(root.left)
            nonlocal res, max_size, count, cur_num
            if root.val != cur_num:
                cur_num = root.val
                count = 1
            elif root.val == cur_num:
                count += 1
            if max_size == count:
                res.append(cur_num)
            elif max_size < count:
                max_size = count
                for i in range(len(res)):
                    res.pop()
                res.append(cur_num)

            if root.right:
                dfs(root.right)

        dfs(root)
        return res
        
# @lc code=end


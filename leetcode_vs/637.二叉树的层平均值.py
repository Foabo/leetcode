#
# @lc app=leetcode.cn id=637 lang=python3
#
# [637] 二叉树的层平均值
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque


class Solution:
    def averageOfLevels(self, root: TreeNode) -> List[float]:
        if not root:
            return []
        res = []
        cur_level = deque()
        cur_level.append(root)
        while(cur_level):
            size = len(cur_level)
            cur_sums = 0
            for _ in range(size):
                cur = cur_level.popleft()
                cur_sums += cur.val
                if cur.left:
                    cur_level.append(cur.left)
                if cur.right:
                    cur_level.append(cur.right)
            res.append(cur_sums/size)
        return res

# @lc code=end

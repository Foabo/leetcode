# @before-stub-for-debug-begin
from python3problem102 import *
from typing import List
# @before-stub-for-debug-end

#
# @lc app=leetcode.cn id=102 lang=python3
#
# [102] 二叉树的层序遍历


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
# @lc code=start
# Definition for a binary tree node.


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        from collections import deque
        res = []
        cur_level = deque()
        cur_level.append(root)
        while(cur_level):
            size = len(cur_level)
            cur_nums = []
            for _ in range(size):
                cur = cur_level.popleft()
                cur_nums.append(cur.val)
                if cur.left:
                    cur_level.append(cur.left)
                if cur.right:
                    cur_level.append(cur.right)
            res.append(cur_nums)
        return res
# @lc code=end

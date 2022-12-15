#
# @lc app=leetcode.cn id=113 lang=python3
#
# [113] 路径总和 II
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if not root:
            return []
        res = []

        def dfs(root, cur_sum, temp):

            cur_sum += root.val
            temp.append(root.val)
            # 遍历到了叶子节点
            if not root.left and not root.right:
                if cur_sum == sum:
                    res.append(temp[:])
                if not temp:
                    temp.pop()
                return
            if root.left:
                dfs(root.left, cur_sum, temp)
                # 回溯到当前节点的状态
                temp.pop()
            if root.right:
                dfs(root.right, cur_sum, temp)
                # 回溯到当前节点的状态
                temp.pop()

        dfs(root, 0, [])
        return res
# @lc code=end

#
# @lc app=leetcode.cn id=236 lang=python3
#
# [236] 二叉树的最近公共祖先
#

# @lc code=start
# Definition for a binary tree node.


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def insert_left(self, new_node):
        if self.left_child is None:
            self.left_child = TreeNode(new_node)
        else:
            t = TreeNode(new_node)
            t.left_child = self.left_child
            self.left_child = t

    def insert_right(self, new_node):
        if self.right_child is None:
            self.right_child = TreeNode(new_node)
        else:
            t = TreeNode(new_node)
            t.right_child = self.right_child
            self.right_child = t

    def get_right_child(self):
        return self.right_child

    def get_left_child(self):
        return self.left_child

    def set_root_val(self, obj):
        self.key = obj

    def get_root_val(self):
        return self.key


class Solution:
    def __init__(self):
        self.ans = None

    def dfs(self, root, p, q):
        # 每次dfs都是由当前节点的角度看的
        if root is None:
            return False
        # lson rson是boolean类型的
        lson = self.dfs(root.left, p, q)
        rson = self.dfs(root.right, p, q)
        if (lson and rson)
        or ((root.val == p.val or root.val == q.val) and (lson or rson)):
            self.ans = root
        return lson or rson or (root.val == p.val or root.val == q.val)

    def lowestCommonAncestor(self, root, p, q):
        self.dfs(root, p, q)
        return self.ans

     def lowestCommonAncestor2(self, root, p, q):
            # not root 如果root is None条件成立
            if not root or root == p or root == q:
                return root
            lelft = self.lowestCommonAncestor2(root.left,p,q)
            right = self.lowestCommonAncestor2(root.right,p,q)
            # if not left and not right: return # 1.
            if not left:return right
            if not right:return left
            return root
        return self.ans
# @lc code=end


def print_all(node):
    if node is not None:
        print(node.val)
        print_all(node.left)
        print_all(node.right)


if __name__ == '__main__':
    data = [3, 5, 1, 6, 2, 0, 8, None, None, 7, 4]
    node_list = []
    for i in range(len(data)):
        node = TreeNode(data[i])
        node_list.append(node)
    if len(node_list) > 0:
        for i in range(int(len(data)/2-1)):
            if node_list[2*i+1].left is None:
                node_list[i].left = node_list[2*i+1]
            if node_list[2*i+2].right is None:
                node_list[i].right = node_list[2*i+2]
        last_idx = int(len(data)/2-1)
        node_list[last_idx].left = node_list[last_idx*2+1]
        if len(data) % 2 == 1:
            node_list[last_idx].right = node_list[last_idx*2+2]
        if node_list is not None:
            print_all(node_list[0])

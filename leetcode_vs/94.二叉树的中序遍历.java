import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        // dfs(root);
        // return ans;

        // 迭代
        Deque<TreeNode> deque = new LinkedList<>();

        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.offerLast(root);
                root = root.left;
            }

            root = deque.pollLast();
            ans.add(root.val);
            root = root.right;

        }
        return ans;
    }

    //递归
    public void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
}
// @lc code=end

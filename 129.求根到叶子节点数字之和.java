/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private int sum;

    public int sumNumbers(TreeNode root) {

        if (root == null)
            return sum;
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode root, int preval) {
        root.val += preval * 10;
        if (root.left == null && root.right == null) {
            sum += root.val;
        }
        if (root.left != null)
            dfs(root.left, root.val);
        if (root.right != null)
            dfs(root.right, root.val);

    }
}
// @lc code=end

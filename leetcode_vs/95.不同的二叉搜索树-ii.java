import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return dfs(1, n);

    }

    public List<TreeNode> dfs(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        if (l > r) {
            res.add(null);
            return res;
        }

       
        for (int i = l; i <= r; i++) {
            List<TreeNode> left = dfs(l, i - 1), right = dfs(i + 1, r);
            for (TreeNode lchild : left) {
                for (TreeNode rchild : right) {
                    // 根节点
                    TreeNode root = new TreeNode(i);
                    root.left = lchild;
                    root.right = rchild;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
// @lc code=end

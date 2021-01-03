import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    public void recoverTree(TreeNode root) {

        // O(n)做法为找到逆序对，逆序对可能一个（两个节点相邻）
        // 可能两个（两个不相邻）

        // 莫里斯遍历
        // 没有左子树，则直接遍历该点，然后走到右儿子
        // 有左子，则将左子树的中序遍历最后一个节点指向该节点
        // 因此，要想办法判断是从上面下来的还是从下面上去的

        TreeNode first = null, second = null, pre = null;
        while (root != null) {
            if (root.left == null) {
                if (pre != null && pre.val > root.val) {
                    if (first == null) {
                        first = pre;
                        second = root;
                    } else {
                        second = root;
                    }

                }
                pre = root;
                root = root.right;

            } else {
                // 有左子树，找前驱结点p
                // p.right==null 则p.right=root root = root.left
                // p.right==root,则p.right=null遍历root，root=root.right,
                TreeNode p = root.left;
                while (p.right != null && p.right != root) {
                    p = p.right;
                }
                if (p.right == null) {
                    p.right = root;
                    root = root.left;
                } else {
                    //这一步相当于已经遍历过左子树了
                    p.right = null;
                    
                    if (pre != null && pre.val > root.val) {
                        if (first == null) {
                            first = pre;
                            second = root;
                        } else {
                            second = root;
                        }

                    }
                    pre = root;
                    root = root.right;
                }

            }

        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

    }
}
// @lc code=end

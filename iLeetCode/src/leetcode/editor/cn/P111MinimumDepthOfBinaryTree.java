//Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the roo
//t node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given binary tree [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// return its minimum depth = 2. 
// Related Topics 树 深度优先搜索 广度优先搜索


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：二叉树的最小深度
public class P111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();
        // TO TEST
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */


    class Solution {
        public int minDepth(TreeNode root) {
            int depth = 0;
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            if (root != null) {
                q.offer(root);
            }
            while (!q.isEmpty()) {
                depth++;
                int sz = q.size();
                /* 将当前队列中所有节点向四周扩散 */
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    /*判断是否到达终点*/
                    if (cur.left == null && cur.right == null) {
                        return depth;
                    }
                    /* 将cur的相邻节点加入队列 */
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
            }
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
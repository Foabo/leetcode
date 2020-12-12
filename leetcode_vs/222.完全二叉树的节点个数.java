import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
 */

// @lc code=start

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    // public int countNodes(TreeNode root) {
    // if(root==null)return 0;
    // return 1 + countNodes(root.left) + countNodes(root.right);
    // }
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /*
         * 计算level 层数
         */
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        /*
         * 假如完全二叉树有k层，第一个结点的序号对应的二级制位数就有k+1位 最右边结点(不一定有)就是 k+1个1
         */
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        /*
         * 使用二分法，利用完全二叉树的特性
         * 对某一个结点，从根节点出发，向左二进制位置就是0，向右就是1（最高位从1开始）
         * 如 12 的二进制为 1100 就是根节点向右再向左向左
         */
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    
    /*
     * 找该序号表示的节点是否存在
     * level是最后的层数，k是要找的中间节点
     */
    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            // 如果当前二进制位为0，向左找
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                //  否则向右找
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

}
// @lc code=end

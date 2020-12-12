import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public boolean isValidBST1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(list, root);
        if (list.size() < 2)
            return true;

        int pre = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i);
            if (pre >= val) {
                return false;
            }
            pre = val;
        }
        return true;
    }

    public void helper(ArrayList<Integer> list, TreeNode root) {
        if (root == null)
            return;
        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
    }

    private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        // 因为是中序遍历，先访问左子树再判断与前一个的值
        if (!isValidBST(root.left)) {
            return false;
        }
        // 当前结点的值必须小于中序前继
        if (root.val <= pre)
            return false;
        pre = root.val;
        // 左子树全验证成功了，再访问右子树
        return isValidBST(root.right);

    }

}
// @lc code=end

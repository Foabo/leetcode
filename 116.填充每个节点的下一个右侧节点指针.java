import java.util.Queue;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // public Node levelOrder(Node root) {
    //     if (root == null)
    //         return null;
    //     Queue<Node> q = new LinkedList<Node>();
    //     q.add(root);
    //     while (!q.isEmpty()) {
    //         int level_size = q.size();
    //         for (int i = 0; i < level_size - 1; i++) {
    //             Node cur = q.poll();
    //             if (cur.left != null)
    //                 q.add(cur.left);
    //             if (cur.right != null)
    //                 q.add(cur.right);
    //             cur.next = q.peek();
    //         }
    //         q.add(q.poll());
    //     }
    //     return root;
    // }

    public Node connect1(Node root) {
        // root = levelOrder(root);
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            int level_size = q.size();
            for (int i = 0; i < level_size; i++) {
                Node cur = q.poll();
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
                if (i < level_size - 1)
                    cur.next = q.peek();
            }

        }
        return root;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node leftmost, head;
        leftmost = root;
        while (leftmost.left != null) {
            head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;

        }
        return root;

    }

}
// @lc code=end

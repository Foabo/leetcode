/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length,n = matrix.length;
        int K = n / 2;
        for (int k = 0; k < K; k++) {
            
            for (int l = 0; l < len - 1; l++) {
                // System.out.println("k==" + k);
                // 一圈的起点
                int i = k, j = k;

                // 遍历每一条边，长度为len
                // System.out.println("向右");
                int pre = matrix[i + 1][j];
                int temp;
                // 向右
                for (j = k; j < n - k; j++) {
                    temp = matrix[i][j];
                    matrix[i][j] = pre;
                    pre = temp;
                }
                j--;
                // System.out.println("向下");
                // 向下

                for (i = i + 1; i < n - k; i++) {
                    temp = matrix[i][j];
                    matrix[i][j] = pre;
                    pre = temp;
                }
                i--;
                // System.out.println("向左");
                // 向左
                for (j = j - 1; j >= k; j--) {
                    temp = matrix[i][j];
                    matrix[i][j] = pre;
                    pre = temp;
                }
                j++;
                // System.out.println("向上");
                // 向上

                for (i = i - 1; i > k; i--) {
                    temp = matrix[i][j];
                    matrix[i][j] = pre;
                    pre = temp;
                }
            }
            len -= 2;

        }

    }
}
// @lc code=end

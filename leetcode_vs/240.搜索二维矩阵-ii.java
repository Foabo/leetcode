/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int m = matrix.length,n = matrix[0].length;
        int i=0,j=n-1;
        while (i < m && j >= 0) {
            if (target<matrix[i][j]) {
                j--;
            }
            else if (target>matrix[i][j] ) {
                i++;
            } else {
                return true;
            }
        }
        return false; 

    }
}
// @lc code=end


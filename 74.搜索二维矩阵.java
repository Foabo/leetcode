import jdk.javadoc.internal.doclets.toolkit.BaseConfiguration.Hidden;

/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 先从上到下，再从左到右  都是二分查找
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m - 1;
        while (low < high) {
            int mid = (high + low) / 2;
            if (matrix[mid][0] < target) {
                low = mid + 1;
            } else if (matrix[mid][0] > target) {
                high = mid - 1;
            } else if (matrix[mid][0] == target) {
                return true;
            }
        }
        if (matrix[low][0] > target)
        {
            low -= 1;
            if (low < 0)
                return false;
        }
        // System.out.println("low=" + low);
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[low][mid] < target) {
                left = mid + 1;
            } else if (matrix[low][mid] > target) {
                right = mid - 1;
            } else if (matrix[low][mid] == target) {
                return true;
            }
        }
        // System.out.println("left=" + left);
        return matrix[low][left] == target;

    }
}
// @lc code=end

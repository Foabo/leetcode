/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 */

// @lc code=start
class Solution {
    // 计算四周的0的个数
    public int countZeros(int[][] grid, int i, int j, int r, int c) {
        int sum = 0;
        // 四个方位

        if (i > 0 && grid[i - 1][j] == 0) {
            sum++;
        }
        if (i + 1 <= r - 1 && grid[i + 1][j] == 0) {
            sum++;
        }
        if (j > 0 && grid[i][j - 1] == 0) {
            sum++;
        }
        if (j + 1 <= c - 1 && grid[i][j + 1] == 0) {
            sum++;
        }
        return sum;

    }

    public int islandPerimeter(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    // 边界条件
                    if (i == 0) {
                        sum++;
                    }
                    if (i == r - 1)
                        sum++;
                    if (j == 0) {
                        sum++;
                    }
                    if (j == c - 1)
                        sum++;
                    sum += countZeros(grid, i, j, r, c);
                    // System.out.println(i + " " + j + " " + sum);
                }
            }
        }
        return sum;
    }
}
// @lc code=end

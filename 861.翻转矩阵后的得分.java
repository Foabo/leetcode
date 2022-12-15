/*
 * @lc app=leetcode.cn id=861 lang=java
 *
 * [861] 翻转矩阵后的得分
 */

// @lc code=start
class Solution {
    public int matrixScore(int[][] A) {
        // 翻转最左边数不为1的行
        // 对每一列，计算0和1 的数量。0比1多，翻转整个列
        // 每一位从左到右对分数的贡献为2^(n-1)
        int m = A.length,n = A[0].length;
        // for (int i = 0; i < m; i++) {
        //     if (A[i][0] == 0) {
        //         for (int j = 0; j < n; j++) {
        //             A[i][j] ^= 1;
        //         }
        //     }
        // }
        int res = 0;
        // 列从第1列开始
        for (int j = 1; j < n; j++) {
            int cnt0 = 0;

            for (int i = 0; i < m; i++) {
                if ((A[i][0] ^ A[i][j]) == 1) {
                    cnt0++;
                }

            }
            // 如果0比1少
            int cnt1 = m - cnt0;
            if (cnt0 < cnt1) {
                cnt0 = cnt1;
            }
            res += cnt0 * (1 << (n - 1 - j));

        }
        res += m * (1 << (n - 1));
        return res;

    }
}
// @lc code=end


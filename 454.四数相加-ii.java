import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> sumAB = new HashMap<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum1 = A[i] + B[j];
                sumAB.put(sum1, sumAB.getOrDefault(sum1, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum2 = C[i] + D[j];
                int cnt = sumAB.getOrDefault(-sum2, 0);
                res += cnt;

            }
        }
        return res;
    }
}
// @lc code=end

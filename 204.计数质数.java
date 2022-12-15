import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        if (n < 3)
            return 0;
        int res = 0;
        // 判断每一个k是不是质数
        boolean[] isNotPrime = new boolean[n];
        for (int k = 2; k < n; k++) {
            // 如果k是质数
            if (isNotPrime[k] == false) {
                res++;
                // 从他的平方开始标记
                if ((long) k * k < n) {
                    for (int i = k * k; i < n; i+=k) {
                        isNotPrime[i] = true;
                    }
                }
            }

        }
        return res;

    }
}
// @lc code=end

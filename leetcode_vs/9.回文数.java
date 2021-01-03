/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int tmp = x;
        int res = 0;
        while (tmp > 0) {
            res = res * 10 + tmp % 10;
            tmp /= 10;
        }
        return res == x;
    }
}
// @lc code=end


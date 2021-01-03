/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i == n)
            return 0;
       
        // flag标记符号
        int flag = 1;
        if (s.charAt(i) == '-') {
            flag = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        
        int res = 0;
        if (i == n)
            return 0;
        // 构造数字
        int t = s.charAt(i) - '0';
        while (i<n&&t < 10 && t >= 0) {
            if (flag > 0 && res > (Integer.MAX_VALUE - t) / 10) {
                return Integer.MAX_VALUE;
            }
            if (flag < 0 && -res < (Integer.MIN_VALUE + t) / 10) {
                return Integer.MIN_VALUE;
            }
            // 特判
            if (-res * 10 - t == Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            res = res * 10 + t;
            i++;
            if (i < n) {
                t = s.charAt(i) - '0';
            } else {
                return res * flag;
            }

        }
        // 加上符号位
        return res * flag;
    }
}
// @lc code=end

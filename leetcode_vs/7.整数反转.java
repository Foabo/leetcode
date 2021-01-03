import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
      
        int res = 0;
        while (x != 0) {
            if (res > 0 && res > (Integer.MAX_VALUE - x % 10) / 10) {
                return 0;
            }
            if (res < 0 && res < (Integer.MIN_VALUE - x % 10) / 10) {
                return 0;
                
            }
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return res;
      

    }
}
// @lc code=end

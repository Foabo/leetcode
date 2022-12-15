import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;

            }
            set.add(s.charAt(i));
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
// @lc code=end


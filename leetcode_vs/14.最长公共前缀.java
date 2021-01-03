/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0)
            return "";
        StringBuffer res = new StringBuffer();

        for (int j = 0; j < strs[0].length(); j++) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < n; i++) {
                
                if (strs[i].length()<=j ||c != strs[i].charAt(j)) {
                    return res.toString();
                }
                
            }
            res.append(c);
        }
        return res.toString();
    }
}
// @lc code=end

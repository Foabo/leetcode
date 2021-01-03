import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        int[] charset = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charset[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            
            if (--charset[t.charAt(i) - 'a'] < 0)
                return t.charAt(i);
        }

        return ' ';
    }
}
// @lc code=end

import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int i = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            int cnt = map.getOrDefault(c, 0);
            map.put(c, cnt + 1);
        }
        for (i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))==1) {
                return i;
            } 
        }
        return -1;
    }
}
// @lc code=end

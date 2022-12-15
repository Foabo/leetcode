import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int val = map.get(s.charAt(i));
            
            if (val < map.get(s.charAt(i + 1))) {
                val = -val;
            }
            res += val;
  
        }
        res += map.get(s.charAt(s.length() - 1));
        return res;
    }
}
// @lc code=end

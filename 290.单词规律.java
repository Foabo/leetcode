import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sigles = s.split(" ");
        if (sigles.length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            // map1和map2必须双向绑定
            if (!map1.containsKey(c)) {
                map1.put(c, sigles[i]);
            }
            if (!map2.containsKey(sigles[i])) {
                map2.put(sigles[i], c);
            }
            // System.out.println(map1);
            // System.out.println(map2);
            if (!map2.get(sigles[i]).equals(c) || !map1.get(c).equals(sigles[i]))
                return false;

        }
        return true;
    }
}
// @lc code=end

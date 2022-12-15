import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        // valid 是窗口中满足need条件的字符个数
        int valid = 0;

        // 记录覆盖子串的起始索引和长度
        int start = 0, len = Integer.MAX_VALUE;
        // 左闭右开区间
        while (right < s.length()) {
            //增加right，直到窗口[left,right)中包含了t中的所有字符
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // System.out.println("window:["+left+","+right+")");
            //判断左窗口是否要收缩
            // valid==tlen时候窗口中包含所有的target
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 如果 d 是子串的一个
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
// @lc code=end

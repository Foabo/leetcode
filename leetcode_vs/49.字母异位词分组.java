import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        // 将strs中的字符串进行排序
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            ArrayList<String> temp;
            // 检查排序后的字符串在不在map中
            if (map.containsKey(key)) {
                temp = map.get(key);
            } else {
                temp = new ArrayList<String>();
            }
            temp.add(s);
            map.put(key, temp);
        }
        return new ArrayList<List<String>>(map.values());

    }
}
// @lc code=end

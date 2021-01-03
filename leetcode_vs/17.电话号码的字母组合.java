import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    List<String> res= new ArrayList<>();
    String[] vals = { "", "!@#", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        
        if (digits.length() < 1)
            return res;
        StringBuffer sb = new StringBuffer();
        backtrack(sb, 0, digits);
        return res;
    }

    public void backtrack(StringBuffer path, int start, String digits) {
        // 判断边界
        if (start == digits.length()) {
            res.add(path.toString());
            return;
        }
        // start是和digits有关的，即和需要回溯的字符串相关
        String val = vals[digits.charAt(start) - '0'];
        for (int i = 0; i < val.length(); i++) {
            // 选择
            backtrack(path.append(val.charAt(i)), start + 1, digits);
            // 回溯
            path.delete(path.length() - 1, path.length());
        }
    }
}
// @lc code=end

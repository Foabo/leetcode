import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */

// @lc code=start
class Solution {
    private List<String> ans;

    public List<String> restoreIpAddresses(String s) {
        // 暴力搜索，把'.'放入字符串里面，排除前导0

        ans = new ArrayList<>();
        dfs(s, 0, 0, new StringBuffer());
        return ans;

    }

    // u 表示当前搜到第几位了，k表示当前搜到第几个数了,path表示当前的方案
    public void dfs(String s, int u, int k, StringBuffer path) {
        // 如果搜完了所有位
        if (u == s.length()) {
            if (k == 4) {

                ans.add(path.substring(0, path.length() - 1));
            }
            return;
        }
        // 剪枝,因为可能不止12位，也就不只是分割成4个数字
        if (k == 4) {
            return;
        }
        for (int i = u, t = 0; i < s.length(); i++) {
            // 判断有没有前导0，如果没有前导0，当前是0是可以的
            if (i > u && s.charAt(u) == '0')
                break;
            t = t * 10 + s.charAt(i) - '0';
            if (t <= 255) {
                // 定义一个新的StringBuffer用来更新选择
                // 原来的path就相当于回溯了
                StringBuffer newPath = new StringBuffer(path);
                dfs(s, i + 1, k + 1, newPath.append(t).append('.'));
            }
               
            else
                break;
        }

    }
}
// @lc code=end

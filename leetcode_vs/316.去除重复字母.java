import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        // 我们要去除的是在当前节点左边的重复串
        StringBuilder res = new StringBuilder();
        // 用map记录出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int val = map.getOrDefault(c, 0);
            map.put(c, val + 1);
        }
        // 每遇到一个字符，如果这个字符不存在于栈中，
        // 就需要将该字符压入栈中。
        // 但在压入之前，需要先将之后还会出现，并且字典序比当前字符小的栈顶字符移除，
        // 然后再将当前字符压入。
        Deque<Character> deque = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 栈中没有当前字符
            if (!set.contains(c)) {
                // 算法核心
                // 当前字符比前一个字符小，并且后面还出现了前一个字符，就删除前一个字符
                // 这里的前一个字符是不是s中的，是栈中的
                while (!deque.isEmpty() && c < deque.peekLast() && map.get(deque.peekLast()) > 0) {
                    set.remove(deque.pollLast());
                }
                deque.addLast(c);
                set.add(c);
            }

            map.put(c, map.get(c) - 1);
        }
        // 遍历deque
        while (!deque.isEmpty()) {
            char c = deque.pollFirst();
            res.append(c);
        }

        return res.length() == 0 ? "" : res.toString();

    }
}
// @lc code=end

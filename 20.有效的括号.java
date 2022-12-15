import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {

        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char top;
            
            switch (c) {
            case '}':
                if (deque.isEmpty())
                    return false;
                top = deque.pollLast();
                if (top != '{')
                    return false;
                break;

            case ']':
                if (deque.isEmpty())
                    return false;
                top = deque.pollLast();

                if (top != '[')
                    return false;
                break;
            case ')':
                if (deque.isEmpty())
                    return false;
                top = deque.pollLast();
                if (top != '(')
                    return false;
                break;
            default:
                deque.offerLast(c);
                break;
            }

        }
        return deque.isEmpty();
    }
}
// @lc code=end

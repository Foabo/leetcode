import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=767 lang=java
 *
 * [767] 重构字符串
 */

// @lc code=start
class Solution {
    public String reorganizeString(String S) {
        int n = S.length();
        if (n == 0)
            return "";
        char[] counts = new char[26];
        int maxCount = 0;
        // 记录每个字母出现的个数
        for (int i = 0; i < n; i++) {
            int idx = S.charAt(i) - 'a';
            counts[idx]++;
            maxCount = Math.max(maxCount, counts[idx]);
        }
        if (maxCount > (n + 1) / 2) {
            return "";
        }
        // 定义一个优先队列当做最大堆,最大就26
        // 堆顶元素为出现次数最多的字母
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                return counts[letter2 - 'a'] - counts[letter1 - 'a'];
            }
        });
        //遍历26次
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        // 每次从堆中取出2个最大的加到sb
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            // 取出来前两个之后，counts中对应的数量-1
            counts[index1]--;
            counts[index2]--;
            // 并将剩余出现次数大于 00 的字母重新加入最大堆
            if (counts[index1] > 0) {
                queue.offer(letter1);
            }
            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }
        // 当 nn 是奇数时，还有一次从最大堆取出一个字母的操作
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();

    }
}
// @lc code=end


//
//You have a lock in front of you with 4 circular wheels. Each wheel has 10 slot
//s: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freel
//y and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each
// move consists of turning one wheel one slot.
// 
//The lock initially starts at '0000', a string representing the state of the 4 
//wheels.
// 
//You are given a list of deadends dead ends, meaning if the lock displays any o
//f these codes, the wheels of the lock will stop turning and you will be unable t
//o open it.
// 
//Given a target representing the value of the wheels that will unlock the lock,
// return the minimum total number of turns required to open the lock, or -1 if it
// is impossible.
// 
//
// Example 1: 
// 
//Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//Output: 6
//Explanation:
//A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "12
//01" -> "1202" -> "0202".
//Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would
// be invalid,
//because the wheels of the lock become stuck after the display becomes the dead
// end "0102".
// 
// 
//
// Example 2: 
// 
//Input: deadends = ["8888"], target = "0009"
//Output: 1
//Explanation:
//We can turn the last wheel in reverse to move from "0000" -> "0009".
// 
// 
//
// Example 3: 
// 
//Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], t
//arget = "8888"
//Output: -1
//Explanation:
//We can't reach the target without getting stuck.
// 
// 
//
// Example 4: 
// 
//Input: deadends = ["0000"], target = "8888"
//Output: -1
// 
// 
//
// Note: 
// 
// The length of deadends will be in the range [1, 500]. 
// target will not be in the list deadends. 
// Every string in deadends and the string target will be a string of 4 digits f
//rom the 10,000 possibilities '0000' to '9999'. 
// 
// Related Topics 广度优先搜索


package leetcode.editor.cn;

import javafx.scene.media.VideoTrack;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//Java：打开转盘锁
public class P752OpenTheLock {
    public static void main(String[] args) {
        Solution solution = new P752OpenTheLock().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String plusOne(String s, int j) {
            char[] ch = s.toCharArray();
            if (ch[j] == '9') {
                ch[j] = '0';
            } else {
                ch[j] += 1;
            }
            return new String(ch);
        }

        public String mimusOne(String s, int j) {
            char[] ch = s.toCharArray();
            if (ch[j] == '0') {
                ch[j] = '9';
            } else {
                ch[j] -= 1;
            }
            return new String(ch);
        }

        public int openLock1(String[] deadends, String target) {
            // 记录需要跳过的死亡密码
            Set<String> deads = new HashSet<>();
            for (String s : deadends) {
                deads.add(s);
            }
            // 记录已经穷举过的密码，防止走回头路
            Set<String> visited = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            // 从起点开始启动广度优先搜索
            int step = 0;
            q.offer("0000");
            visited.add("0000");

            while (!q.isEmpty()) {
                int sz = q.size();
                /* 将当前队列中的所有节点向周围扩散 */
                for (int i = 0; i < sz; i++) {
                    String cur = q.poll();
                    /* 判断是否到达终点 */
                    if (deads.contains(cur)) {
                        continue;
                    }
                    if (cur.equals(target)) {
                        return step;
                    }

                    /* 将一个节点的未遍历相邻节点加入队列 */
                    for (int j = 0; j < 4; j++) {
                        String up = plusOne(cur, j);
                        if (!visited.contains(up)) {
                            q.offer(up);
                            visited.add(up);
                        }
                        String down = mimusOne(cur, j);
                        if (!visited.contains(down)) {
                            q.offer(down);
                            visited.add(down);

                        }
                    }
                }
                /* 在这里增加步数 */
                step++;
            }
            return -1;
        }

        // 双向BFS
        public int openLock(String[] deadends, String target) {
            // 记录需要跳过的死亡密码
            Set<String> deads = new HashSet<>();
            for (String s : deadends) {
                deads.add(s);
            }
            // 用集合不用队列，可以快速判断元素是否存在
            Set<String> q1 = new HashSet<>();
            Set<String> q2 = new HashSet<>();
            Set<String> visited = new HashSet<>();

            int step = 0;
            q1.add("0000");
            q2.add(target);

            while (!q1.isEmpty() && !q2.isEmpty()) {
                // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
                Set<String> temp = new HashSet<>();
                /* q1中所有节点向周围扩散*/
                for (String cur : q1) {
                    /* 判断是否到达终点 */
                    if (deads.contains(cur)) {
                        continue;
                    }
                    if (q2.contains(cur)) {
                        return step;
                    }
                    visited.add(cur);

                    /* 将一个节点的未遍历相邻节点加入集合 */
                    for(int j = 0;j<4;j++){
                        String up = plusOne(cur,j);
                        if(!visited.contains(up)){
                            temp.add(up);
                        }
                        String down = mimusOne(cur,j);
                        if(!visited.contains(down)){
                            temp.add(down);
                        }
                    }
                }
                step++;
                // temp 相当于 q1
                // 这里交换 q1 q2，下一轮 while 就是扩散 q2
                q1=q2;
                q2 = temp;

            }


            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
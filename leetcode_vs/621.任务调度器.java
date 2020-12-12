import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 一个最大堆，优先队列,堆顶元素为出现次数最多的字母
        // counts记录字母出现的次数
        int[] nextValid = new int[26];
        int[] counts = new int[26];
        System.out.println("=========1============");
        for (char c : tasks) {
            int idx = c - 'A';
            counts[idx]++;
        }

        int time = 0;
        // 选择不在冷却中并且剩余执行次数最多的那个任务
        for (int i = 0; i < tasks.length; i++) {
            
            ++time;
            // 找到counts最大的那个
            int max = 0;
            int max_idx = -1;
            // 记录最小的minValid
            int minValid = Integer.MAX_VALUE;
            for (int j = 0; j < 26; j++) {

                // 如果是待命状态可以用到，
                // 找到可以放的最小的时间片
                if (counts[j] > 0 && nextValid[j] < minValid) {
                    minValid = nextValid[j];
                }
                

            }

            time = Math.max(time, minValid);
            for (int j = 0; j < 26; j++) {
                // 当前时间下可以放的且counts最大的j
                if (counts[j] > 0 && nextValid[j] <= time ) {
                    if (max_idx == -1 || counts[j] > counts[max_idx]) {
                        max_idx = j;
                    }
                }
            }
            counts[max_idx]--;
            nextValid[max_idx] = time + n + 1;

        }
        

        return time;
    }
}
// @lc code=end

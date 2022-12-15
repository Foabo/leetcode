import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=659 lang=java
 *
 * [659] 分割数组为连续子序列
 */

// @lc code=start
class Solution {
    public boolean isPossible1(int[] nums) {

        // map的key是子序列的最后一个数字x-1
        // 遍历到x时，如果x-1中有，则x-1的堆顶+1，key变成x，移除掉原来的x-1的key
        // 如果x-1的不存在，就x对应的堆顶元素为1
        // 堆保存的是以x-1位结尾的序列的长度，可能不止一个，但是最顶上的是最短的长度
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new PriorityQueue<Integer>());
            }
            if (map.containsKey(num - 1)) {
                int count = map.get(num - 1).poll();
                map.get(num).offer(count + 1);
                if (map.get(num - 1).isEmpty()) {
                    map.remove(num - 1);
                }
            } else {
                map.get(num).offer(1);
            }

        }
        // 遍历每个堆，如果有一个堆顶小于3，return false
        for (PriorityQueue<Integer> heap : map.values()) {
            if (heap.peek() < 3)
                return false;
        }

        return true;

    }

    public boolean isPossible(int[] nums) {
    // 第一个哈希表 counts 存储数组中的每个数字的剩余次数，
    // 第二个哈希表 subSqNum 存储数组中的每个数字作为结尾的子序列的数量
    HashMap<Integer, Integer> counts = new HashMap<>();
    HashMap<Integer, Integer> sqNum = new HashMap<>();

    // 初始化counts
    for (int num : nums) {
        int count = counts.getOrDefault(num, 0);
        counts.put(num, count + 1);
    }
    // 遍历数组的每一个x
    for (int x : nums) {
        /* 
        找x-1结尾的子序列个数lastCount
        如果lastCount大于0,将x加入该子序列
         counts中x对应的要-1
         sqNum中x-1对应的要-1        
         sqNum中x对应的要+1
        如果lastCount小于等于0，也即sqNum中没有以x-1结尾的子序列
         counts中x对应的-1，
          x 为一个子序列的第一个数，
         为了得到长度至少为 3 的子序列，x+1 和 x+2 必须在子序列中，
         因此需要判断在第一个哈希表中 x+1 和 x+2 的剩余次数是否都大于 0
         当 x+1 和 x+2 的剩余次数都大于 0 时
           counts中x,x-1,x-2的值-1
           sqNum中x+2的值+1
         否则，无法得到长度为 3 的子序列,返回false
        
        其中要判断cnt>0吗，因为用到了x+2，所以要 */
        int cnt = counts.get(x);
        if(cnt>0){
            int lastCounts = sqNum.getOrDefault(x - 1, 0);
            if (lastCounts > 0) {
                counts.put(x, cnt - 1);
                sqNum.put(x - 1, lastCounts - 1);
                sqNum.put(x, sqNum.getOrDefault(x, 0) + 1);
            } else {
                int cnt1 = counts.getOrDefault(x + 1, 0);
                int cnt2 = counts.getOrDefault(x + 2, 0);

                if (cnt1 > 0 && cnt2 > 0) {
                    counts.put(x, cnt - 1);
                    counts.put(x + 1, cnt1 - 1);
                    counts.put(x + 2, cnt2 - 1);
                    sqNum.put(x + 2, sqNum.getOrDefault(x + 2, 0) + 1);
                } else {
                    return false;
                }
            }
        }
       

    }
    return true;

    }
}
// @lc code=end

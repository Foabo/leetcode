/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    // public int canCompleteCircuit(int[] gas, int[] cost) {
    //     if (gas.length == 0)
    //         return -1;
    //     // 贪心算法，到达一个加油站，当前汽油不够到达下一个加油站才加油
    //     for (int i = 0; i < gas.length; i++) {
    //         if (canReturn(i, gas, cost)) {
    //             return i;
    //         }

    //     }

    //     return -1;

    // }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //我们首先检查第 00 个加油站，并试图判断能否环绕一周；如果不能，就从第一个无法到达的加油站开始继续检查。
        int n = gas.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return gas[0] - cost[0]>=0 ? 0 : -1;
        }
        int i = 0;
        int cnt = 0;
        while(cnt<n){
            int j = canReturn(i, gas, cost);
            if (j == i) {
                return i;
            }
            if (j < i)
                return -1;
            
            i = j;
            cnt++;
        }


        return -1;
    }
    public int canReturn(int i, int[] gas, int[] cost) {
        int sum = gas[i] - cost[i];
        int len = gas.length;
        int j = (i + 1) % len;
        if (sum < 0)
            return j;
        while (j != i) {
            // 判断当前汽油是否能够到达下一个加油站
            // 行驶过程要消耗汽油
            sum = sum + gas[j] - cost[j];
            // if (sum < cost[j]) {
            if (sum < 0) {
                // 如果加满了都不能到达,返回
                return j;
            }
            // 开往下一个加油站,消耗汽油
            // sum -= cost[j];
            j = (j + 1) % len;

        }
        return i;
    }

}
// @lc code=end

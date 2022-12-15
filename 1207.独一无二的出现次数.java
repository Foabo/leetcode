import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1207 lang=java
 *
 * [1207] 独一无二的出现次数
 */

// @lc code=start
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int cnt = 0;
        for (int num : arr) {
            cnt = mp.getOrDefault(num, 0);
            mp.put(num, cnt + 1);
        }
        int isCur[] = new int[1000];
        for (Integer i : mp.keySet()) {
            int k = mp.get(i);
            isCur[k]++;
            if (isCur[k] > 1) {
                return false;
            }

        }

        return true;

    }
}
// @lc code=end

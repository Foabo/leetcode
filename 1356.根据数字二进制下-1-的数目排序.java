import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * @Date: 2020-11-06 16:32:39
 * @LastEditors: Foabo
 * @LastEditTime: 2020-11-06 18:21:39
 * @FilePath: /leetcode_vs/1356.根据数字二进制下-1-的数目排序.java
 */
/*
 * @lc app=leetcode.cn id=1356 lang=java
 *
 * [1356] 根据数字二进制下 1 的数目排序
 */

// @lc code=start
class Solution {

    public int[] sortByBits(int[] arr) {
        int[] res = new int[arr.length];
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        int maxCnt = 0;
        for (int num : arr) {
            int cnt = 0, tmp = num;
            while (tmp > 0) {
                if (tmp % 2 == 1) {
                    cnt++;

                }
                tmp = tmp / 2;
            }
            if (maxCnt < cnt) {
                maxCnt = cnt;
            }

            ArrayList<Integer> list = mp.get(cnt);
            if (list == null) {
                list = new ArrayList<Integer>();
                list.add(num);
                mp.put(cnt, list);
            } else {
                list = mp.get(cnt);
                list.add(num);
            }

        }
        int k = 0;
        for (int i = 0; i <= maxCnt; i++) {
            ArrayList<Integer> list = mp.get(i);
            if (list != null) {
                Collections.sort(list);
                for (int j = 0; j < list.size(); j++) {
                    res[k++] = list.get(j);
                }

            }
        }

        return res;
    }
}
// @lc code=end

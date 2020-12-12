import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> tmp = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> isContain = new HashSet<>();
        for (int num : nums1) {

            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                if (!isContain.contains(num)) {
                    isContain.add(num);
                    tmp.add(num);
                }
            }
        }
        int[] res = new int[tmp.size()];
        int i = 0;
        for (int num : tmp) {
            res[i++] = num;
        }

        return res;
    }
}
// @lc code=end

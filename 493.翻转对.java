/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 */

// @lc code=start
class Solution {
    private int res;

    public int reversePairs(int[] nums) {
        // 暴力
        res = 0;
        int n = nums.length;
        if (n < 2)
            return 0;
        int[] tmps = new int[nums.length];
        // for (int i = 0; i < nums.length-1; i++) {
        // for (int j = i + 1; j < nums.length; j++) {

        // if (nums[i] > (nums[j] * 2)) {
        // res++;
        // }
        // }
        // }
        mergeSort(nums, tmps, 0, nums.length - 1);
        return res;
    }

    public void mergeSort(int[] nums, int[] tmps, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, tmps, left, mid);
        mergeSort(nums, tmps, mid + 1, right);
        // 左右排好序了
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if ((long )nums[i] > (long )nums[j] * 2) {
                res += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        i = left;
        j = mid + 1;
        int idx = left;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {

                tmps[idx++] = nums[i++];
            } else {
                tmps[idx++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmps[idx++] = nums[i++];
        }
        while (j <= right) {
            tmps[idx++] = nums[j++];
        }
        for (i = left; i <= right; i++) {
            nums[i] = tmps[i];
        }

    }
}
// @lc code=end

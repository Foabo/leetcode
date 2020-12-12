/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        int len = nums.length;
        while (i < len) {
            // // 从j开始找到第一个0
            // while (j < len && nums[j] != 0) {
            //     j++;
            // }
            // if (j == len)
            //     break;
            // i = j;
            // // 从j（当前 0）开始找到第一个不为0的数
            // while (i < len && nums[i] == 0) {
            //     i++;
            // }
            // if (i == len)
            //     break;
            // // 交换nums[i] nums[j]

            // nums[i] ^= nums[j];
            // nums[j] ^= nums[i];
            // nums[i] ^= nums[j];
            // j++;
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
            i++;

        }
    }
}
// @lc code=end

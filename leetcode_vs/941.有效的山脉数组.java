/*
 * @lc app=leetcode.cn id=941 lang=java
 *
 * [941] 有效的山脉数组
 */

// @lc code=start
class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3 || A[0] > A[1]) {
            return false;
        }

        boolean flag = true;
        int pre = A[0];

        for (int i = 1; i < A.length; i++) {
            // 四种情况
            // flag==1:
            // 1, 右边比左边大，放行
            // 2, 右边比左边小，flag=0
            // flag==0:
            // 1, 右边比左边大，return false
            // 2, 右边比左边小，放行

            // 右边比左边大
            if (A[i] > pre && flag == false) {

                return false;

            }
            // 右边比左边小
            else if (A[i] < pre && flag == true) {
                flag = false;
            }
            // 相等
            else if (A[i] == pre) {
                return false;
            }

            pre = A[i];
        }
        return flag == false;

    }
}
// @lc code=end

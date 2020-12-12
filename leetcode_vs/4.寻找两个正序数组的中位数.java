/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    // 找到实际上合并数组后的第K个元素
    public int getKthNum(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int start1 = 0, start2 = 0;
        int halfK;
        while (true) {

            // start越界，nums没有可以比较的了，返回另一个nums对应的中位数
            if (start1 == m) {
                return nums2[start2 + k - 1];
            }
            if (start2 == n) {
                return nums1[start1 + k - 1];
            }
            // k==1，剩下的数组合起来中第1小的元素就是两个中比较小的
            if (k == 1) {

                return nums1[start1] <= nums2[start2] ? nums1[start1] : nums2[start2];

            }
            halfK = k / 2;

            int cmpIdx1 = Math.min(start1 + halfK, m) - 1;
            int cmpIdx2 = Math.min(start2 + halfK, n) - 1;
            // 去掉比较索引比较小的数组的前半(cmpIdx)部分
            if (nums1[cmpIdx1] <= nums2[cmpIdx2]) {
                k -= (cmpIdx1 - start1 + 1);
                start1 = cmpIdx1 + 1;
            } else {
                k -= (cmpIdx2 - start2 + 1);
                start2 = cmpIdx2 + 1;
            }

        }

    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        // total为奇数
        if (total % 2 == 1) {
            double res = getKthNum(nums1, nums2, total / 2 + 1);
            return res;
        }
        // total为偶数，计算k=total/2-1和total/2位置的
        else {
            return (getKthNum(nums1, nums2, total / 2) + getKthNum(nums1, nums2, total / 2 + 1)) / 2.0;
        }
    }

    // 分治法
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = m;
        while (left <= right) {
            int i = (left + right) / 2; // 一个一个试i
            int j = (m + n + 1 )/ 2 - i;
            // 两种情况
            if (j != 0 && i != m && nums2[j - 1] > nums1[i]) {
                left = i + 1;
                
            } else if (i != 0 && j != n && nums1[i - 1] > nums2[j]) {
                right = i - 1;
            }
            // 边界条件
            else {
                int leftmax = 0;
                if (i == 0) {
                    leftmax = nums2[j - 1];
                } else if (j == 0) {
                    leftmax = nums1[i - 1];
                } else {
                    leftmax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return leftmax;
                } // 奇数的话不需要考虑右半部分

                int rightmin = 0;
                if (i == m) {
                    rightmin = nums2[j];
                } else if (j == n) {
                    rightmin = nums1[i];
                } else {
                    rightmin = Math.min(nums2[j], nums1[i]);
                }

                return (leftmax + rightmin) / 2.0; // 如果是偶数的话返回结果

            }
           
        }
        return 0.0;
    }
}
// @lc code=end

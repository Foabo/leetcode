import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }
    
        int i = n-2;
        for (; i >= 0; i--) {
            //从右往左找到第一个比自己小的
            if (nums[i + 1] > nums[i]) {
                break;
            }

        }
        if(i<0){
            Arrays.sort(nums);
            return;
        }
        
        for (int j = n-1; j > i; j--) {
            if (nums[j] > nums[i]) {

        

                //交换 i j位置的数
                nums[j] ^= nums[i];
                nums[i] ^= nums[j];
                nums[j] ^= nums[i];
                break;
            }
        }
        //反转i+1,n-1;
        int k = n-1;
        i++;
        while(i<k) {
            nums[i] ^= nums[k];
            nums[k] ^= nums[i];
            nums[i] ^= nums[k];
            i++;
            k--;
        }


        
    }
}
// @lc code=end


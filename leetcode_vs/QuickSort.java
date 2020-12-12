/*
 * @Date: 2020-11-05 14:24:25
 * @LastEditors: Foabo
 * @LastEditTime: 2020-11-05 15:15:55
 * @FilePath: /leetcode_vs/quickSort.java
 */

public class QuickSort {
    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] > pivot) {
                high--;
            }
            if (low < high) {
                nums[low] = nums[high];
                low++;
            }
            while (low < high && nums[low] < pivot) {
                low++;
            }
            if (low < high) {
                nums[high] = nums[low];
                high--;
            }
        }
        nums[low] = pivot;
        return low;
    }

    public static void sort(int[] nums, int low, int high) {
        if                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            (   l   o   w   >  hi gh) {
            return;
        }
        int mid = partition(nums, low, high);
        sort(nums, low, mid - 1);
        sort(nums, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        QuickSort.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}

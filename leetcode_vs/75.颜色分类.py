#
# @lc app=leetcode.cn id=75 lang=python3
#
# [75] 颜色分类
#
from typing import List
# @lc code=start


class Solution:
    """
    def partition(self, low, high, nums):
        pivot = nums[low]
        while low < high:
            while low < high and nums[high] >= pivot:
                high -= 1
            if low < high:
                nums[low] = nums[high]
            while low < high and nums[low] <= pivot:
                low += 1
            if low < high:
                nums[high] = nums[low]
        nums[low] = pivot
        return low

    def quickSort(self, nums, low, high):
        pivot = self.partition(low, high, nums)
        self.quickSort(nums, low, pivot-1)
        self.quickSort(nums, pivot+1, high)
    """

    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # l1找到左边第一个不为0的数，l2找到左边第一个为0的数 l1<=l2
        # r1找到右边第一个不为2的数，r2找到右边边第一个为2的数 r1>=r2
        n = len(nums)
        ptr = 0
        for i in range(n):
            if nums[i] == 0:
                nums[i], nums[ptr] = nums[ptr], nums[i]
                ptr += 1
        for i in range(ptr, n):
            if nums[i] == 1:
                nums[i], nums[ptr] = nums[ptr], nums[i]
                ptr += 1




# @lc code=end
if __name__ == "__main__":
    nums = [1, 2]
    s = Solution()
    s.sortColors(nums)
    print(nums)

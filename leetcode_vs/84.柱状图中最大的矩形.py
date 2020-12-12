#
# @lc app=leetcode.cn id=84 lang=python3
#
# [84] 柱状图中最大的矩形
#
from typing import List
# @lc code=start


class Solution:
    def largestRectangleArea2(self, heights: List[int]) -> int:
        size = len(heights)
    #     """ 暴力法（超时） """
    #    """  for i in range(size):
    #         height = heights[i]
    #         left = right = i

    #         while left > 0 and heights[left-1] >= height:
    #             left -= 1
    #         while right < size-1 and heights[right+1] >= height:
    #             right += 1
    #         cur_area = height*(right-left+1)
    #         max_area = max(max_area, cur_area) """
    #     """ 单调栈 """
        if size == 0:
            return 0
        if size == 1:
            return heights[0]
        max_area = 0
        stack = []

        #  维护单调不减栈，没合并代码
        for i in range(size):

            while stack and heights[stack[-1]] > heights[i]:
                height = heights[stack.pop()]

                while stack and heights[stack[-1]] == height:
                    stack.pop()

                width = 0
                if len(stack) == 0:
                    width = i
                else:
                    width = i-stack[-1]-1

                max_area = max(max_area, height*width)

            stack.append(i)

        while stack:
            height = heights[stack.pop()]

            while stack and heights[stack[-1]] == height:
                stack.pop()

            width = 0
            if len(stack) == 0:
                width = size
            else:
                width = size - stack[-1] - 1
            max_area = max(max_area, height*width)

        return max_area

    def largestRectangleArea(self, heights: List[int]) -> int:
        size = len(heights)
        if size == 0:
            return 0
        if size == 1:
            return heights[0]
        max_area = 0
        stack = [0]
        new_heights = [0 for i in range(size + 2)]
        for i in range(size):
            new_heights[i + 1] = heights[i]

        heights = new_heights
        for i in range(1, size + 2):
            while heights[stack[-1]] > heights[i]:
                height = heights[stack.pop()]
                width = i - stack[-1] - 1
                max_area = max(max_area, height*width)
            stack.append(i)
        return max_area


# @lc code=end
if __name__ == "__main__":
    a = [2, 1, 5, 6, 2, 3]
    b = [0 for _ in range(len(a)+2)]

    for i in range(len(a)):
        b[i + 1] = a[i]
    a = b
    print(a)

#
# @lc app=leetcode.cn id=155 lang=python3
#
# [155] 最小栈
#

# @lc code=start
import sys
import math


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """

        self.front = -1
        self.stack = []
        self.mins = []
        self.min = sys.maxsize

    def push(self, x):
        self.stack.append(x)
        self.min = min(self.min, x)
        self.mins.append(self.min)
        self.front = self.front+1

    def pop(self):
        if self.front >= 0:
            data = self.stack.pop()
            self.mins.pop()
            if len(self.mins):
                self.min = self.mins[-1]
            else:
                self.min = sys.maxsize
            self.front = self.front - 1
            return data
        return

    def top(self):
        if self.front >= 0:
            return self.stack[self.front]
        return

    def getMin(self):
        if self.front >= 0:
            return self.mins[self.front]
        return
        # Your MinStack object will be instantiated and called as such:
        # obj = MinStack()
        # obj.push(x)
        # obj.pop()
        # param_3 = obj.top()
        # param_4 = obj.getMin()
        # @lc code=end


class MinStack2:
    def __init__(self):
        self.stack = []
        self.min_stack = [math.inf]

    def push(self, x: int) -> None:
        self.stack.append(x)
        self.min_stack.append(min(x, self.min_stack[-1]))

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]

#
# @lc app=leetcode.cn id=232 lang=python3
#
# [232] 用栈实现队列
#

# @lc code=start


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.first = []
        self.second = []
        self.size = 0

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.first.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if self.second:
            return self.second.pop()
        elif self.first:
            for i in range(len(self.first)):
                self.second.append(self.first.pop())
            return self.second.pop()
        else:
            return

    def peek(self) -> int:
        """
        Get the front element.
        """
        if self.second:
            return self.second[-1]
        elif self.first:
            return self.first[0]
        else:
            return

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not(self.first or self.second)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
# @lc code=end

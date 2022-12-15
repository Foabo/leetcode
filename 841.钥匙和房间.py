#
# @lc app=leetcode.cn id=841 lang=python3
#
# [841] 钥匙和房间
#

# @lc code=start
from collections import deque


class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        N = len(rooms)
        if N == 0:
            return False
        if N == 1:
            return True
        visited = [0 for _ in range(N)]
        queue = deque()
        queue.append(0)

        while queue:
            index = queue.popleft()
            visited[index] = 1
            for room in rooms[index]:
                # 房间没访问过
                if visited[room] == 0:
                    queue.append(room)
        for i in visited:
            if i == 0:
                return False
        return True
# @lc code=end

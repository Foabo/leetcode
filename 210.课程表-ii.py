#
# @lc app=leetcode.cn id=210 lang=python3
#
# [210] 课程表 II
#

from typing import List
from collections import deque, defaultdict

# @lc code=start


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        # 邻接表存储有向图
        edges = defaultdict(list)
        # 存储每个节点的入度
        indeg = [0]*numCourses
        # 存储答案
        res = []
        for info in prerequisites:
            edges[info[1]].append(info[0])
            indeg[info[0]] += 1
        # 将所有入度为0的节点放入队列中
        q = deque([u for u in range(numCourses)if indeg[u] == 0])

        while q:
            # 以u为头v为尾的边
            u = q.popleft()
            res.append(u)
            # u所指向的结点
            for v in edges[u]:
                indeg[v] -= 1
                if indeg[v] == 0:
                    q.append(v)
        # 判断是否有环，遍历完如果入度为0的结点不等于numCourses则有环
        if len(res) != numCourses:
            res = []
        return res

 # @lc code=end

#
# @lc app=leetcode.cn id=684 lang=python3
#
# [684] 冗余连接
#

# @lc code=start


class UnionFind:
    def __init__(self, n):
        self.ancestor = list(range(n))

    def union(self, index1: int, index2: int):
        # 找到index1和index2的掌门1,2,并且掌门1变成掌门2的手下

        root1 = self.find(index1)
        root2 = self.find(index2)
        # 改写union方法，第一次当x与y没有联通时，将其设置联通关系，返回ture
        # 第二次x和y的跟节点发现一致时，他们已经联通了，返回false
        if root1 == root2:
            return False
        self.ancestor[root1] = root2
        return True

    def find(self, index: int) -> int:
        # 如果index不是掌门
        if self.ancestor[index] != index:
            # 状态压缩,直接连接到掌门旗下
            self.ancestor[index] = self.find(self.ancestor[index])
        return self.ancestor[index]


class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        nodesCount = len(edges)
        uf = UnionFind(nodesCount + 1)
        # parent = list(range(nodesCount + 1))
        for i, (node1, node2) in enumerate(edges):

            if not uf.union(node1, node2):
                return [node1, node2]

# @lc code=end

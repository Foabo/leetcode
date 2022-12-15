#
# @lc app=leetcode.cn id=685 lang=python3
#
# [685] 冗余连接 II
#
from typing import List
# @lc code=start


class UnionFind:
    def __init__(self, n):
        self.ancestor = list(range(n))

    def union(self, index1: int, index2: int):
        # 找到index1和index2的掌门1,2,并且掌门1变成掌门2的手下
        self.ancestor[self.find(index1)] = self.find(index2)

    def find(self, index: int) -> int:
        # 如果index不是掌门
        if self.ancestor[index] != index:
            # 状态压缩,直接连接到掌门旗下
            self.ancestor[index] = self.find(self.ancestor[index])
        return self.ancestor[index]


class Solution:
    def findRedundantDirectedConnection(self, edges: List[List[int]]) -> List[int]:
        nodesCount = len(edges)
        uf = UnionFind(nodesCount + 1)
        parent = list(range(nodesCount + 1))
        # conflict表示冲突,即一个节点有两个父节点
        conflict = -1
        cycle = -1

        for i, (node1, node2) in enumerate(edges):
            # node2的上级不是他自己,说明node2之前有一个上级了,node2遍历过一次了
            # 即加上这个node2有两个父节点,将当前的边标记为导致冲突的边
            if parent[node2] != node2:
                conflict = i
            else:
                parent[node2] = node1
                # 因为node1指向了node2,即node2的上级是node1
                # 如果node1和node2的掌门是同一个,说明出现了环路
                # find函数自带了状态压缩,将节点及其祖先直接连接在了掌门下边
                if uf.find(node1) == uf.find(node2):
                    cycle = i
                else:
                    # node1的掌门成为node2掌门的手下
                    # 为什么不是node2掌门成为node1的手下?可能是因为减少递归次数,因为我们只关注是节点属于哪一个并查集
                    # 因为数字相同的为同一个并查集,即祖先一定一样
                    uf.union(node1, node2)

        # 没有导致冲突的边,说明附加的边一定出现了环路,而且是环路中最后一条被访问的边
        if conflict < 0:
            return [edges[cycle][0], edges[cycle][1]]
        # 有导致冲突的边,有两种情况
        else:
            conflictEdge = edges[conflict]
            # 有环
            if cycle >= 0:
                return [parent[conflictEdge[1]], conflictEdge[1]]
                # 无环
            else:
                return [conflictEdge[0], conflictEdge[1]]


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    edges = [[2, 1], [3, 1], [4, 2], [1, 4]]
    s.findRedundantDirectedConnection(edges)

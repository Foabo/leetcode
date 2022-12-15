from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if len(matrix) == 0:
            return []
        res = []
        m, n = len(matrix), len(matrix[0])
        visited = [[0] * n for _ in range(m)]
        i, j = 0, 0
        size = m * n
        step = 0

        while step < size:
            # 向右
            while j < n and visited[i][j] == 0:
                res.append(matrix[i][j])
                visited[i][j] = 1
                j += 1
                step += 1
            j -= 1
            i += 1
            # 向下
            while i < m and visited[i][j] == 0:
                res.append(matrix[i][j])
                visited[i][j] = 1
                i += 1
                step += 1
            i -= 1
            j -= 1
            # 向左
            while j >= 0 and visited[i][j] == 0:
                res.append(matrix[i][j])
                visited[i][j] = 1
                j -= 1
                step += 1
            j += 1
            i -= 1
            # 向上
            while i >= 0 and visited[i][j] == 0:
                res.append(matrix[i][j])
                visited[i][j] = 1
                i -= 1
                step += 1
            i += 1
            j += 1
        return res


if __name__ == "__main__":
    matrix = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
    solution = Solution()
    print(solution.spiralOrder(matrix=matrix))

# 最大正方形问题
import os


class Solution:
    def __init__(self):
        self.matrix = self.loadMatrix()

    def loadDatadet(self, infile):
        f = open(infile, 'r')
        sourceInLine = f.readlines()
        dataset = []
        for line in sourceInLine:
            temp1 = line.strip('\n')
            # 文件中看数字的分隔符是空格还是制表符
            temp2 = temp1.split(' ')
            dataset.append(temp2)
        # for循环转换数据格式str->int
        # for i in range(0, len(dataset)):
        #     k = len(dataset[i])
        #     for j in range(k):
        #         # int转换数字类型
        #         dataset[i].append(int(dataset[i][j]))
        #     del(dataset[i][0:k])
        return dataset

    def loadMatrix(self):
        # 获取当前上层文件夹路径
        current_dir = os.getcwd()
        infile = current_dir+'/5_8_221/data.txt'

        return self.loadDatadet(infile)

    # 暴力法
    def maximalSquare1(self):
        matrix = self.matrix
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        # 最大的正方形边长
        maxSide = 0
        # 行和列的大小，正方形的行列不会超过这个大小
        rows, columns = len(matrix), len(matrix[0])
        for i in range(rows):
            for j in range(columns):
                if matrix[i][j] == '1':
                    # 遇到一个 1 作为正方形的左上角
                    maxSide = max(maxSide, 1)
                    # 正方形的最大可能边长
                    currentMaxSide = min(rows-i, columns-j)
                    for k in range(1, currentMaxSide):
                        # flag判断新增的一行是否均为1
                        flag = True
                        # 对角线为零，break
                        if matrix[i+k][j+k] == '0':
                            break
                        for m in range(k):
                            if matrix[i+k][j+m] == '0' or matrix[i+m][j+k] == '0':
                                flag = False
                                break
                        if(flag):
                            maxSide = max(maxSide, k+1)
                        else:
                            break
        maxSquare = maxSide*maxSide
        return maxSquare

    def maximalSquare2(self):
        matrix = self.matrix
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        maxSide = 0
        rows, columns = len(matrix), len(matrix[0])
        # 初始化dp[][]列表解析方法
        dp = [[0]*columns for _ in range(rows)]
        for i in range(rows):
            for j in range(columns):
                if matrix[i][j] == '1':
                    # 判断边界，最上边和最左边的面积最大为1
                    if i == 0 or j == 0:
                        dp[i][j] = 1
                    else:
                        dp[i][j] = min(dp[i-1][j], dp[i]
                                       [j-1], dp[i-1][j-1])+1
                    maxSide = max(maxSide, dp[i][j])
        maxSquare = maxSide*maxSide
        return maxSquare


if __name__ == "__main__":
    s = Solution()

    print(s.maximalSquare2())

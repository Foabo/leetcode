#
# @lc app=leetcode.cn id=37 lang=python3
#
# [37] 解数独
#
from typing import List
# @lc code=start


class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # valid = False
        # line = [[False] * 9 for _ in range(9)]
        # column = [[False] * 9 for _ in range(9)]
        # block = [[[False] * 9 for _a in range(9)]for _b in range(3)]
        # spaces = list()
        # for i in range(9):
        #     for j in range(9):
        #         # 原先的是空白格
        #         if board[i][j] == '.':
        #             spaces.append((i, j))
        #         else:
        #             # 如果原来的位置有数字
        #             # 可以填写的数字范围为 [1, 9]，而数组的下标从 0 开始
        #             digit = int(board[i][j])-1
        #             line[i][digit] = column[j][digit] = block[i // 3][j // 3][digit] = True

        # def dfs(pos: int):
        #     nonlocal valid
        #     # 终止条件
        #     if pos == len(spaces):
        #         valid = True
        #         return
        #     i, j = spaces[pos]
        #     for digit in range(9):
        #         if line[i][digit] == column[j][digit] == block[i // 3][j // 3][digit] == False:
        #             line[i][digit] = column[j][digit] = block[i//3][j//3] = True
        #             board[i][j] = str(digit+1)
        #             # 递归
        #             dfs(pos+1)
        #             # 回溯
        #             line[i][digit] = column[j][digit] = block[i//3][j//3] = False
        #         if valid:
        #             return
        def flip(i: int, j: int, digit: int):
            # 使用按位异或运算 ^，将第 digit 位从 0 变为 1，或从 1 变为 0。
            # 具体地，与数 1 << digit 进行按位异或运算即可，其中 << 表示左移运算；
            # 将所在位置的信息添加进line column block,表示数字已经出现过
            line[i] ^= (1 << digit)
            column[j] ^= (1 << digit)
            block[i//3][j//3] ^= (1 << digit)

        def dfs(pos: int):
            nonlocal valid
            if pos == len(spaces):
                valid = True
                return

            i, j = spaces[pos]
            # line[i] | column[j] | block[i//3][j//3]第k位位1,表示该位置不能填入数字k+1(因为之前出现过了)
            # 其中 | 表示按位或运算
            # 如果我们对这个值进行 ∼ 按位取反运算，那么第 k 位为 1 就表示该位置可以填入数字 k+1
            # 由于在进行按位取反运算后，这个数的高位也全部变成了 1，而这是我们不应当枚举到的，
            # 因此我们需要将这个数和 (111111111)2 = (1FF)16进行按位与运算&,将无关的位置为0
            # mask表示 i 行 j 列的可以填的数字
            mask = ~(line[i] | column[j] | block[i//3][j//3]) & 0x1ff

            while mask:
                # 我们可以用 b & (−b) 得到 b 二进制表示中最低位的 1
                # digitMask表示一个十进制数,mask=(11000)24时,digitMask=(100)8
                digitMask = mask & (-mask)
                # 最低位的1究竟是第几位
                # digit表示i,j位置可以填的数字-1
                digit = bin(digitMask).count("0")-1
                # 第一次flip,将 i行j列填入数字digit,因为mask是根据原来 line column block设定的,所以
                # flip之后全变成1
                flip(i, j, digit)
                # board 尝试各个可以填的数字
                board[i][j] = str(digit+1)
                # 递归,填下一个空格
                dfs(pos+1)
                # 回溯,还原回原来的状态,digit位变为0
                flip(i, j, digit)
                # 我们可以用 b 和最低位的 1 进行按位异或运算，就可以将其从 b 中去除，这样就可以枚举下一个 1。
                # 同样地，我们也可以用 b 和 b-1 进行按位与运算达到相同的效果
                mask &= (mask-1)
                if valid:
                    return

        line = [0] * 9
        column = [0] * 9
        block = [[0] * 3 for _ in range(3)]
        valid = False
        spaces = list()

        for i in range(9):
            for j in range(9):
                if board[i][j] == ".":
                    spaces.append((i, j))
                else:
                    # digit从0开始,board中的数字为1-9
                    digit = int(board[i][j]) - 1
                    flip(i, j, digit)

        dfs(0)


# @lc code=end
if __name__ == "__main__":
    mask = 24
    digitMask = mask & (-mask)

    print(digitMask)
    digit = bin(digitMask).count("0")-1
    print(digit)
    print(bin(digitMask))
    print(mask&(mask-1))
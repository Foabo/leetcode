#
# @lc app=leetcode.cn id=224 lang=python3
#
# [224] 基本计算器
#

# @lc code=start


class Solution:
    def evaluate_expr(self, stack):
        res = stack.pop() if stack else 0

        # 计算结果直到遇到‘)' 因为将字符串反转了
        while stack and stack[-1] != ')':
            sign = stack.pop()
            if sign == '+':
                res += stack.pop()
            else:
                res -= stack.pop()
        return res

    def calculate(self, s: str) -> int:
        stack, n, op = [], 0, 0
        # 从后往前
        for i in range(len(s) - 1, -1, -1):
            ch = s[i]
            if '0' <= ch <= '9':
                op = (10 ** n * int(ch)) + op
                n += 1

            elif ch != ' ':
                if n:
                    stack.append(op)
                    n, op = 0, 0
                if ch == '(':
                    res = self.evaluate_expr(stack)
                    stack.pop()
                    stack.append(res)
                else:
                    stack.append(ch)
        if n:
            stack.append(op)
        return self.evaluate_expr(stack)

    def calculate2(self, s: str) -> int:
        stack, op, res, sign = [], 0, 0, 1

        # 1、正序迭代字符串
        for ch in s:
            # 2、形成操作数
            if ch.isdigit():
                op = op * 10 + int(ch)
            # 遇到+-号
            elif ch == '+':
                res += sign * op
                sign = 1
                op = 0
            elif ch == '-':
                res += sign * op
                sign = -1
                op = 0
            # 如果字符是左括号 (，我们将迄今为止计算的结果和符号添加到栈上，然后重新开始进行计算
            elif ch == '(':
                stack.append(res)
                stack.append(sign)

                sign = 1
                res = 0
            # 如果字符是右括号 )，则首先计算左侧的表达式。则产生的结果就是刚刚结束的子表达式的结果。
            # 如果栈顶部有符号，则将此结果与符号相乘。
            elif ch == ')':
                res += sign * op
                res *= stack.pop()
                res += stack.pop()
                op = 0
            return res+sign*op


# @lc code=end
if __name__ == "__main__":
    solution = Solution()

    # print(solution.calculate("(1+(4+5+2)-3)+(6+8)"))
    print(solution.calculate(" 2-1 + 2 "))

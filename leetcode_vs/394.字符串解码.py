#
# @lc app=leetcode.cn id=394 lang=python3
#
# [394] 字符串解码
#

# @lc code=start


class Solution:
    def decodeString1(self, s: str) -> str:
        stack, res, k = [], "", 0
        for c in s:
            if c == '[':
                stack.append([k, res])
                res, k = "", 0
            elif c == ']':
                cur_k, last_res = stack.pop()
                res = last_res+cur_k*res
            # 遇到数字
            elif '0' <= c <= '9':
                k = k*10+int(c)
            else:
                res += c
        return res

    def decodeString(self, s: str) -> str:
        res = ""
        nums = []
        signs = []
        k = 0
        tmp = ""
        for c in s:
            if '0' <= c <= '9':
                k = k*10+int(c)
            elif c == '[':
                nums.append(k)
                k = 0
                signs.append(c)
            elif c == ']':
                while 1:
                    _c = signs.pop()
                    if _c == '[':
                        break
                    tmp = _c+tmp
                k = nums.pop()
                res = tmp*k
                signs.append(res)
                tmp = ""
                k = 0
            else:
                signs.append(c)

        return "".join(signs)


# @lc code=end
if __name__ == "__main__":

    solution = Solution()
    print(solution.decodeString("3[a]2[bc]"))

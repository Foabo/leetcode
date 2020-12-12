#
# @lc app=leetcode.cn id=47 lang=python3
#
# [47] 全排列 II
#

# @lc code=start
from typing import List


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def backtrack(nums, track, used, res, size):
            # 触发结束
            if len(track) == size:
                res.append(track[:])
                return
            for i in range(size):
                # 排除不合法的选择
                if not used[i]:
                    if i > 0 and nums[i] == nums[i-1] and not used[i-1]:
                        continue
                    used[i] = True
                    # 做选择
                    track.append(nums[i])
                    # 进入下一次决策树
                    backtrack(nums, track, used, res, size)
                    # 取消选择
                    used[i] = False
                    track.pop()

        size = len(nums)
        if size == 0:
            return []
        track = []
        nums.sort()
        used = [False for _ in range(size)]
        res = []
        backtrack(nums, track, used, res, size)
        return res


# @lc code=end
if __name__ == "__main__":
    nums = [1, 1, 3]
    solution = Solution()
    res = solution.permuteUnique(nums)
    print(res)

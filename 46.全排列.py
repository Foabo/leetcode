#
# @lc app=leetcode.cn id=46 lang=python3
#
# [46] 全排列
#
from typing import List


# @lc code=start
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def backtrack(nums, track, used, res, size):
            # 触发结束
            if len(track) == size:
                res.append(track[:])
                return
            for i in range(size):
                # 排除不合法的选择
                if not used[i]:
                    used[i] = True
                    # 做选择
                    track.append(nums[i])
                    # 进入下一次决策树
                    backtrack(nums, track, used, res, size)
                    # 取消选择
                    used[i] = False
                    track.pop()

        # 用哈希表存储是否做了选择

        def backtrack2(nums, track, hash_set, res, size):
            # 触发结束
            if len(track) == size:
                res.append(track[:])
                return
            for i in range(size):
                if not nums[i] in hash_set:
                    hash_set.add(nums[i])
                    track.append(nums[i])
                    backtrack2(nums, track, hash_set, res, size)
                    track.pop()
                    hash_set.remove(nums[i])

        # 交换的回溯
        def backtrack3(nums, start, end, res):
            if start == end:
                res.append(nums[:])
            else:
                for i in range(start, end+1):
                    nums[i], nums[start] = nums[start], nums[i]
                    backtrack3(nums, start+1, end, res)
                    nums[i], nums[start] = nums[start], nums[i]

        # 路径：记录在 track 中
        # 选择列表：nums 中不存在于 track 的那些元素
        # 结束条件：nums 中的元素全都在 track 中出现
        size = len(nums)
        if size == 0:
            return []
        # track = []
        # used = [False for _ in range(len(nums))]
        # hash_set = set()
        res = []
        # backtrack(nums, track, used, res, size)
        # backtrack2(nums, track, hash_set, res, size)
        backtrack3(nums, 0, size-1, res)
        
        return res
# @lc code=end


if __name__ == "__main__":
    nums = [1, 2, 3]
    solution = Solution()
    res = solution.permute(nums)
    print(res)

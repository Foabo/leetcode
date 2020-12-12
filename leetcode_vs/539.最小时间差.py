#
# @lc app=leetcode.cn id=539 lang=python3
#
# [539] 最小时间差
#
from typing import List
# @lc code=start


class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        # 分为正向和反向
        tf = 24*60
        times = []
        for s in timePoints:
            hour, minute = s.split(":")
            time = int(hour)*60+int(minute)
            times.append(time)

        if not times:
            return 0
        times.sort()

        mindist = float('inf')
        for i in range(1, len(times)):
            mindist = min(mindist, times[i]-times[i-1])

        return min(mindist, times[0]-(times[-1]-tf))


# @lc code=end
if __name__ == "__main__":
    # s = Solution()
    # timePoints = ["23:59", "00:00"]
    # s.findMinDifference(timePoints)
    import numpy as np
    r = -4 * np.random.rand()
    a = 10**r
    print(a)

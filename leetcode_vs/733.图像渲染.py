#
# @lc app=leetcode.cn id=733 lang=python3
#
# [733] 图像渲染
#

# @lc code=start


class Solution:
    def dfs(self, image: List[List[int]], sr: int, sc: int, newColor: int, oldColor: int):
        if image[sr][sc] != oldColor:
            return
        else:
            image[sr][sc] = newColor
            if sr >= 1:
                self.dfs(image, sr-1, sc, newColor, oldColor)
            if sr+1 < len(image):
                self.dfs(image, sr+1, sc, newColor, oldColor)
            if sc >= 1:
                self.dfs(image, sr, sc-1, newColor, oldColor)
            if sc+1 < len(image[0]):
                self.dfs(image, sr, sc+1, newColor, oldColor)

    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        oldColor = image[sr][sc]
        if oldColor == newColor:
            return image
        self.dfs(image, sr, sc, newColor, oldColor)
        return image
# @lc code=end

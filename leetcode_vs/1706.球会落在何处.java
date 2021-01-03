/*
 * @lc app=leetcode.cn id=1706 lang=java
 *
 * [1706] 球会落在何处
 */

// @lc code=star
class Solution {
    public int[] findBall(int[][] grid) {
        // 定义最左为1，最右为-1
        // 当前为1，查看右边，如果右边为-1，堵住了
        // 如果右边为1，进入右下角
        // 当前为-1，查看左边，如果左边为1，堵住了
        // 如果左边为-1，进入右下角
        int m = grid.length;
        int n = grid[0].length;
        int []res = new int[n];
        for(int k =0;k<n;k++){
            int flag = 1;
            int j = k;
            int i=0;
            while(i<m){
                if(grid[i][j]==1){
                    // 当前为1
                    // 如果是最右边，或者右边是-1
                    if(j==n-1||grid[i][j+1]==-1){
                        flag = -1;
                        break;
                    }
                    // 进入右下角
                    else{
                        i++;j++;
                        continue;
                    }
                    
                }
                if(grid[i][j]==-1){
                    // 判断是不是最左边
                    if(j==0||grid[i][j-1]==1){
                        flag=-1;
                        break;
                    }
                    // 进入左下角
                    else{
                        i++;j--;
                        continue;
                    }

                }
            }
            if(flag==-1)
                res[k]=flag;
            else res[k]=j;
        }
        return res;
    }
}

// @lc code=en
/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (len < 2||numRows==1)
            return s;
        // 数列的等差值
        int n = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        int numCols = len / n + 1;

        // 有numRows行,numCols列
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows-1) {
                for (int j = i; j < len; j += n) {
                    sb.append(s.charAt(j));
                }

            }
            else{
                for(int j=i,k=n-i;j<len||k<len;j+=n,k+=n){
                    if(j<len)sb.append(s.charAt(j));
                    if(k<len)sb.append(s.charAt(k));
                }
            }
            
        }
        return sb.toString();

    }
}
// @lc code=end

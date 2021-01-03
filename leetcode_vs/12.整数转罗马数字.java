/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {

        int[]values={
            1000,
            900,500,400,100,
            90,50,40,10,
            9,5,4,1
        };
        String[]refs={
            "M",
            "CM","D","CD","C",
            "XC","L","XL","X",
            "IX","V","IV","I"
        };
        StringBuffer res = new StringBuffer();
        for (int i = 0; i <13; i++) {
            while (num >= values[i]) {
                num -= values[i];
                res.append(refs[i]);
            }
        }
        return res.toString();
    }
}
// @lc code=end


//Given a positive integer n, find the least number of perfect square numbers (f
//or example, 1, 4, 9, 16, ...) which sum to n. 
//
// Example 1: 
//
// 
//Input: n = 12
//Output: 3 
//Explanation: 12 = 4 + 4 + 4. 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9. Related Topics 广度优先搜索 数学 动态规划


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Java：完全平方数
public class P279PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new P279PerfectSquares().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            ArrayList<Integer> square_nums = new ArrayList<Integer>();
            for (int i = 1; i * i <= n; i++) {
                square_nums.add(i * i);
            }
            Set<Integer> queue = new HashSet<Integer>();
            queue.add(n);

            int level = 0;
            while (queue.size() > 0) {
                level += 1;
                Set<Integer> next_queue = new HashSet<Integer>();

                for (Integer remainder : queue) {
                    for (Integer square : square_nums) {
                        if (remainder.equals(square)) {
                            return level;
                        } else if (remainder < square) {
                            break;
                        } else {
                            next_queue.add(remainder - square);
                        }

                    }
                }
                queue = next_queue;

            }
            return level;

        }

        public int dp_numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            int max_square_index = (int) Math.sqrt(n) + 1;
            int square_nums[] = new int[max_square_index];

            for (int i = 1; i < max_square_index; i++) {
                square_nums[i] = i * i;
            }

            for (int i = 1; i <= n; i++) {
                for (int s = 1; s < max_square_index; s++) {
                    if (i < square_nums[s]) {
                        break;
                    }
                    dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
                }
            }
            return dp[n];
        }


        public boolean is_divided_by(int n, int count, Set<Integer> square_nums) {
            if (count == 1) {
                return square_nums.contains(n);
            }
            for (Integer square : square_nums) {
                if (is_divided_by(n - square, count - 1, square_nums)) {
                    return true;
                }
            }
            return false;
        }

        public int greedy_numSquares(int n) {
            Set<Integer> square_nums = new HashSet<Integer>();

            square_nums.clear();
            for (int i = 1; i * i <= n; ++i) {
                square_nums.add(i * i);
            }

            int count = 1;
            for (; count <= n; ++count) {
                if (is_divided_by(n, count, square_nums)) {
                    return count;
                }
            }
            return count;

        }

        protected boolean isSquare(int n) {
            int sq = (int) Math.sqrt(n);
            return n == sq * sq;
        }

        public int math_numSquares(int n) {
            // four-square and three-square theorems.
            while (n % 4 == 0) {
                n /= 4;
            }
            if (n % 8 == 7) {
                return 4;
            }

            if (this.isSquare(n)) {
                return 1;
            }
            // enumeration to check if the number can be decomposed into sum of two squares.
            for (int i = 1; i * i <= n; ++i) {

                if (this.isSquare(n - i * i)) {
                    return 2;
                }

            }
            // bottom case of three-square theorem.
            return 3;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
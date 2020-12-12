//
//Given a list of daily temperatures T, return a list such that, for each day in
// the input, tells you how many days you would have to wait until a warmer temper
//ature. If there is no future day for which this is possible, put 0 instead.
// 
//For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 7
//3], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
// 
//
// Note:
//The length of temperatures will be in the range [1, 30000].
//Each temperature will be an integer in the range [30, 100].
// Related Topics 栈 哈希表


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//Java：每日温度
public class P739DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new P739DailyTemperatures().new Solution();
        // TO TEST
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        solution.dailyTemperatures(T);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures2(int[] T) {
            int ans[] = new int[T.length];
            // next[t]表示t温度在T中下一次出现的位置
            int next[] = new int[101];
            Arrays.fill(next, Integer.MAX_VALUE);
            for (int i = T.length - 1; i >= 0; i--) {
                // 对当前温度，循环从比当前温度更高的温度t开始，每次warmer_index都初始化为
                int warmer_index = Integer.MAX_VALUE;
                for (int t = T[i] + 1; t < 101; t++) {
                    // warmer_index表示比T[i]温度高的温度在T中的位置，取[T[i]+1...100]
                    if (next[t] < warmer_index) {
                        warmer_index = next[t];
                    }
                }
                if (warmer_index < Integer.MAX_VALUE) {
                    ans[i] = warmer_index - i;
                }
                next[T[i]] = i;

            }
            return ans;
        }

        public int[] dailyTemperatures3(int[] T) {
            int length = T.length;
            int[] res = new int[length];
            //从右向左遍历
            for (int i = length - 2; i >= 0; i++) {
                for (int j = i + 1; j < length; j += res[j]) {
                    if (T[i] > T[j]) {
                        res[i] = j - 1;
                        // break保证了第一次遇到比T[i]大的值就计算res，不用遍历后面的值
                        break;
                    }
                    // i的右边res[j]等于0说明后面没有更大的值了，而T[i]<T[j]，则后面的值都比T[i]小
                    else if (res[j] == 0) {
                        res[i] = 0;
                        break;
                    }
                }
            }
            return res;
        }

        public int[] dailyTemperatures(int[] T) {
            int length = T.length;
            int[] res = new int[length];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < length; i++) {
                while (!stack.empty() && T[i] > T[stack.peek()]) {
                    int t = stack.pop();
                    res[t] = i - t;
                }
                stack.push(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
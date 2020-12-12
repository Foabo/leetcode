//Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
//
// Valid operators are +, -, *, /. Each operand may be an integer or another exp
//ression. 
//
// Note: 
//
// 
// Division between two integers should truncate toward zero. 
// The given RPN expression is always valid. That means the expression would alw
//ays evaluate to a result and there won't be any divide by zero operation. 
// 
//
// Example 1: 
//
// 
//Input: ["2", "1", "+", "3", "*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
// 
//
// Example 2: 
//
// 
//Input: ["4", "13", "5", "/", "+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
// 
//
// Example 3: 
//
// 
//Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//Output: 22
//Explanation: 
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
// 
// Related Topics 栈


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//Java：逆波兰表达式求值
public class P150EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution solution = new P150EvaluateReversePolishNotation().new Solution();
        // TO TEST
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(solution.evalRPN(tokens));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            Set<String> op = new HashSet<>();
            op.add("+");
            op.add("-");
            op.add("*");
            op.add("/");
            Stack<Integer> st = new Stack<>();
            for (String s : tokens) {
                if (op.contains(s)) {
                    int a = st.pop();
                    int b = st.pop();
                    if (s.equals("+")) {
                        a = a + b;
                    } else if (s.equals("-")) {
                        a = b - a;
                    } else if (s.equals("*")) {
                        a = b * a;
                    } else if (s.equals("/")) {
                        a = b / a;
                    }
                    st.push(a);
                } else {
                    int num = Integer.parseInt(String.valueOf(s));
                    st.push(num);
                }
            }
            return st.peek();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
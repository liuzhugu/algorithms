//实现一个基本的计算器来计算一个简单的字符串表达式的值。 
//
// 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 字符串

package leetcode.editor.cn;

import java.util.Stack;

//Java：227:基本计算器 II 2020/06/04
public class BasicCalculatorIi{
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
        //TO TEST
        solution.calculate("0-2147483647");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //遇到乘除优先算   加减的话直到遍历完才算
        public int calculate(String s) {
            Stack<Character> symbolStack = new Stack<>();
            Stack<Long> numStack = new Stack<>();
            long preNum = -1;
            //之前一个符号是否为乘除
            boolean flag = false;
            for (char c : s.toCharArray()) {
                //略过等号
                if (c == ' ') {
                    continue;
                }
                //先判断数字
                if (c - '0' >= 0 && c - '9' <= 0) {
                    if (preNum == -1) {
                        preNum = 0;
                    }
                    preNum = preNum * 10 + c - '0';
                    continue;
                }
                //非数字  那么把之前数字入栈
                if (preNum != -1) {
                    numStack.add(preNum);
                    preNum = -1;
                }
                //计算乘除
                if (flag) {
                    char symbol = symbolStack.pop();
                    long first = numStack.pop();
                    long second = numStack.pop();
                    if (symbol == '*') {
                        numStack.add(first * second);
                    } else {
                        numStack.add(second / first);
                    }
                    flag = false;
                }

                symbolStack.add(c);
                //碰到乘除了
                if (c == '*' || c == '/') {
                    flag = true;
                }
            }
            //处理手尾
            if (preNum != -1) {
                numStack.add(preNum);
            }
            if (flag) {
                char symbol = symbolStack.pop();
                long first = numStack.pop();
                long second = numStack.pop();
                if (symbol == '*') {
                    numStack.add(first * second);
                } else {
                    numStack.add(second / first);
                }
            }
            //从头开始顺序算
            Stack<Character> newSymbolStack = new Stack<>();
            while (! symbolStack.isEmpty()) {
                newSymbolStack.add(symbolStack.pop());
            }
            Stack<Long> newNumStack = new Stack<>();
            while (! numStack.isEmpty()) {
                newNumStack.add(numStack.pop());
            }
            while (! newSymbolStack.isEmpty()) {
                char symbol = newSymbolStack.pop();
                long first = newNumStack.pop();
                long second = newNumStack.pop();
                switch (symbol) {
                    case '+':
                        newNumStack.add(first + second);
                        break;
                    case '-':
                        newNumStack.add(first - second);
                        break;
                    case '*':
                        newNumStack.add(first * second);
                        break;
                    case '/':
                        newNumStack.add(first / second);
                        break;
                }
            }
            if (newNumStack.isEmpty()) {
                return 0;
            }
            String ans = String.valueOf(newNumStack.pop());
            return Integer.parseInt(ans);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;

import java.util.Stack;
/**
 * Created by liuzhugu on 2020/01/01.
 * 150. 逆波兰表达式求值
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 *      整数除法只保留整数部分。
 *      给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            int second,first;
            switch (str) {
                case "+":
                    second = stack.pop();
                    first = stack.pop();
                    stack.add(first + second);
                    break;
                case "-":
                    second = stack.pop();
                    first = stack.pop();
                    stack.add(first - second);
                    break;
                case "*":
                    second = stack.pop();
                    first = stack.pop();
                    stack.add(first * second);
                    break;
                case "/":
                    second = stack.pop();
                    first = stack.pop();
                    stack.add(first / second);
                    break;
                default:
                    stack.add(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}

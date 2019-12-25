package practice.leetcode;

import java.util.Stack;
/**
 * Created by liuzhugu on 2019/12/25.
 * 678. 有效的括号字符串
 *  给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。
 *  有效字符串具有如下规则：
 *      任何左括号 ( 必须有相应的右括号 )。
 *      任何右括号 ) 必须有相应的左括号 ( 。
 *      左括号 ( 必须在对应的右括号之前 )。
 *      * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 *      一个空字符串也被视为有效字符串。
 *  */
public class CheckValidString {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0;i < s.length();i ++) {
            char c = s.charAt(i);
            if (c == '('){
                left.add(i);
            }else if (c == '*') {
                star.add(i);
            }else {
                if (!left.empty()) {
                    left.pop();
                }else if (!star.empty()) {
                    star.pop();
                }else {
                    return false;
                }
            }
        }
        while (!left.empty()) {
            if (star.empty()) {
                return false;
            }
            //还要比较次序,星号只能消去在它之前的(
            if (left.peek() < star.peek()) {
                left.pop();
                star.pop();
            } else {
                return false;
            }
        }
        return true;
    }
}

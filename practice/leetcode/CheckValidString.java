package practice.leetcode;

import java.util.Stack;

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

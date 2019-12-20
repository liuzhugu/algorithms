package tool;

import java.util.Stack;

public class Transform {
    public static String toBinaryString(int i){
        Stack<Integer> stack = new Stack<>();
        while (i > 0) {
            stack.add(i % 2);
            i = i / 2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (! stack.empty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}

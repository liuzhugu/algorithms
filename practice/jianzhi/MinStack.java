package practice.jianzhi;

import java.util.Stack;

/**
 * Created by liuzhugu on 2020/03/06.
 * 面试题30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class MinStack {
    Stack<Integer> data;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.empty() || min.peek() > x) {
            min.push(x);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        if (data.size() <= 0 && min.size() <= 0)return;
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}

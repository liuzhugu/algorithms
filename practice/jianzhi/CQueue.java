package practice.jianzhi;

import java.util.Stack;

/**
 * Created by liuzhugu on 2020/03/06.
 * 面试题09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class CQueue {
    private Stack<Integer> first;
    private Stack<Integer> second;
    public CQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void appendTail(int value) {
        if (second != null) {
            move(second,first);
        }
        first.push(value);
    }

    public int deleteHead() {
        if (first.empty() && second.empty()) return -1;
        if (first != null) {
            move(first,second);
        }
        return second.pop();
    }

    private void move (Stack<Integer> first,Stack<Integer> second) {
        while (! first.empty()) {
            second.push(first.pop());
        }
    }
}

package practice.jianzhi;

import java.util.Stack;

/**
 * Created by liuzhugu on 2020/03/22.
 * 面试题06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.value);
            head = head.next;
        }
        int[] result = new int[]{};
        if (! stack.empty()) {
            result = new int[stack.size()];
            int index = 0;
            while (! stack.empty()) {
                result[index ++] = stack.pop();
            }
        }
        return result;
    }
}

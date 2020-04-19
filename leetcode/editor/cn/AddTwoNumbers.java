package leetcode.editor.cn;


import java.util.*;

/**
 * Created by liuzhugu on 2019/03/05.
 * 445. 两数相加 II
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        while (!stack1.empty() && !stack2.empty()) {
            int sum = carry + stack1.pop() + stack2.pop();
            stack.push(sum % 10);
            carry = sum/10;
        }
        while (stack1.empty() && ! stack2.empty()) {
            int sum = carry + stack2.pop();
            stack.push(sum % 10);
            carry = sum/10;
        }
        while (! stack1.empty() && stack2.empty()) {
            int sum = carry + stack1.pop();
            stack.push(sum % 10);
            carry = sum/10;
        }
        if (stack1.empty() && stack2.empty()) {
            while(carry != 0){
                stack.push(carry % 10);
                carry = carry/10;
            }
        }
        //根据栈构建链表
        //哨兵机制
        ListNode currentNode = new ListNode(-1);
        ListNode result = currentNode;
        while (! stack.empty()) {
            currentNode.next = new ListNode(stack.pop());
            currentNode = currentNode.next;
        }
        return result.next;
    }

}

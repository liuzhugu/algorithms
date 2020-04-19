package leetcode.editor.cn;

import leetcode.editor.cn.ListNode;

import java.util.Stack;
/**
 * Created by liuzhugu on 2020/01/06.
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null)return;
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head,newHead = null,newNode = null;
        while (node != null) {
            stack.push(new ListNode(node.val));
            node = node.next;
        }
        node = head;
        int index = 1,size = stack.size();
        while (index * 2 <= size) {
            ListNode tmp = node.next;
            if (newHead == null) {
                newHead = node;
            }else {
                newNode.next = node;
            }
            newNode = stack.pop();
            node.next = newNode;
            node = tmp;
            index ++;
        }
        if (index * 2 == size + 1) {
            if (newHead != null) {
                newNode.next = stack.pop();
            }else {
                newHead = stack.pop();
            }
        }
        head = newHead;
    }
}

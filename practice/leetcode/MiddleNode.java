package practice.leetcode;

/**
 * Created by liuzhugu on 2020/03/24。
 * 876. 链表的中间结点
 *  给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode pre = head,next = head;
        if (next == null || next.next == null) {
            return pre;
        }
        while (next.next != null) {
            next = next.next;
            if (next.next != null) {
                next = next.next;
            }
            pre = pre.next;
        }
        return pre;
    }
}

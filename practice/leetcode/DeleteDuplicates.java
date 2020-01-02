package practice.leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by liuzhugu on 2020/01/03.
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        List<ListNode> list = new ArrayList<>();
        boolean deleteTop = false;
        list.add(new ListNode(head.val));
        ListNode node = head.next;
        while (node != null) {
            if (node.val == list.get(list.size() - 1).val) {
                deleteTop = true;
            } else {
                if (deleteTop) {
                    list.remove(list.size() - 1);
                    deleteTop = false;
                }
                list.add(new ListNode(node.val));
            }
            node = node.next;
        }
        if (deleteTop) {
            list.remove(list.size() - 1);
        }
        head = null;
        ListNode pre = null;
        for (int i = 0;i < list.size();i ++) {
            ListNode listNode = list.get(i);
            if (head == null) {
                head = listNode;
            }else {
                pre.next = listNode;
            }
            pre = listNode;
        }
        return head;
    }
}

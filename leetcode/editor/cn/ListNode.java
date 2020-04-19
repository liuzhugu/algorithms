package leetcode.editor.cn;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode reverse(ListNode goal) {
        ListNode first = goal;
        if (first == null) {
            return null;
        }
        ListNode second = first.next;
        if (second == null) {
            return first;
        }
        ListNode third = second.next;
        if (third == null) {
            second.next = first;
        }
        first.next = null;
        do {
            second.next = first;
            first = second;
            second = third;
            third = third.next;
        }while(third != null);
        second.next = first;
        return second;
    }
}
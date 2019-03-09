package practice.leetcode;


/**
 * Created by liuzhugu on 2019/03/09.
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是
 * 节点编号的奇偶性，而不是节点的值的奇偶性。请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)
 * 时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head,oddNext = odd;
        if (odd == null) {
            return null;
        }
        ListNode even = odd.next,evenNext = even;
        if (even == null) {
            return odd;
        }
        ListNode next = even.next;
        boolean nextIsOdd = true;
        while (next != null) {
            //将节点轮流接到奇数或偶数节点
            if (nextIsOdd) {
                oddNext.next = next;
                oddNext = oddNext.next;
                //接完奇数到偶数
                nextIsOdd = false;
            }else {
                evenNext.next = next;
                evenNext = evenNext.next;
                //接完偶数到奇数
                nextIsOdd = true;
            }
            //步进
            next = next.next;
        }
        //清位
        oddNext.next = null;
        evenNext.next = null;
        //奇数队列的队尾下一个是偶数队列的队首
        oddNext.next = even;
        return odd;
    }
}

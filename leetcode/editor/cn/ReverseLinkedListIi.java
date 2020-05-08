//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表

package leetcode.editor.cn;
//Java：92:反转链表 II 2020/05/07
public class ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        //TO TEST
        solution.reverseBetween(LeetCodeTest.stringToListNode("[1,2,3,4,5]"),1,4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null) {
                return head;
            }
            //哨兵head
            ListNode headNode = new ListNode(-1);
            headNode.next = head;
            int l1 = m - 1,l2 = n;
            ListNode node1 = headNode,node2 = headNode;
            while (l1 > 0) {
                node1 = node1.next;
                l1 --;
            }
            while (l2 > 0) {
                node2 = node2.next;
                l2 --;
            }
            ListNode tmp = node2.next;
            //截断
            node2.next = null;
            node2 = tmp;
            node1.next = reverse(node1.next);
            tmp = node1.next;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node2;
            return headNode.next;
        }
        //反转列表
        private ListNode reverse(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode pre = head,next = head.next;
            head.next = null;
            while (next != null) {
                ListNode tmp = null;
                if (next.next != null) {
                    tmp = next.next;
                }
                next.next = pre;
                pre = next;
                next = tmp;
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
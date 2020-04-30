//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package leetcode.editor.cn;
//Java：21:合并两个有序链表 2020/04/30
public class MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //哨兵节点 返回其下一位
            ListNode newHead = new ListNode(-1),pre = newHead;
            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    pre.next = l2;
                    pre = pre.next;
                    l2 = l2.next;
                } else {
                    pre.next = l1;
                    pre = pre.next;
                    l1 = l1.next;
                }
            }
            if (l1 == null) {
                while (l2 != null) {
                    pre.next = l2;
                    pre = pre.next;
                    l2 = l2.next;
                }
            }
            if (l2 == null) {
                while (l1 != null) {
                    pre.next = l1;
                    pre = pre.next;
                    l1 = l1.next;
                }
            }
            return newHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
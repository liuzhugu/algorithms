//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针

package leetcode.editor.cn;
//Java：86:分隔链表
public class PartitionList{
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode partition(ListNode head, int x) {
            //哨兵节点
            ListNode dummy1 = new ListNode(-1);
            ListNode dummy2 = new ListNode(-1);
            ListNode p1 = dummy1,p2 = dummy2;
            while (head != null) {
                if (head.val < x) {
                    dummy1.next = head;
                    head = head.next;
                    dummy1 = dummy1.next;
                } else {
                    dummy2.next = head;
                    head = head.next;
                    dummy2 = dummy2.next;
                }
            }
            dummy1.next = p2.next;
            dummy2.next = null;
            return p1.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
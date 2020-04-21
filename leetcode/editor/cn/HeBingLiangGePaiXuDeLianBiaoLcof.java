//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法

package leetcode.editor.cn;
//Java：面试题25:合并两个排序的链表 双指针 2020/04/21
public class HeBingLiangGePaiXuDeLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode pre = null,next = null,head = null;
            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    next = l2;
                    l2 = l2.next;
                } else {
                    next = l1;
                    l1 = l1.next;
                }
                if (pre == null) {
                    pre = next;
                    head = pre;
                } else {
                    pre.next = next;
                    pre = next;
                }
            }
            if (l1 == null && l2 != null) {
                while (l2 != null) {
                    next = l2;
                    l2 = l2.next;
                    if (pre == null) {
                        pre = next;
                        head = pre;
                    } else {
                        pre.next = next;
                        pre = next;
                    }
                }
            }
            if (l1 != null && l2 == null) {
                while (l1 != null) {
                    next = l1;
                    l1 = l1.next;
                    if (pre == null) {
                        pre = next;
                        head = pre;
                    } else {
                        pre.next = next;
                        pre = next;
                    }
                }
            }
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
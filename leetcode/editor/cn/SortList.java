//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表

package leetcode.editor.cn;
//Java：148:排序链表  2020/04/30
public class SortList{
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        //TO TEST
        solution.sortList(LeetCodeTest.stringToListNode("[4,2,1,3]"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode sortList(ListNode head) {
            ListNode ans = merge(head);
            return ans;
        }
        //使用快慢指针  找到终点 从而切断中点
        private ListNode cut(ListNode head) {
            ListNode fast = head.next,slow = head;
            //没到结尾
            if (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                }
            }
            ListNode ans = slow.next;
            //截断
            slow.next = null;
            return ans;
        }
        private ListNode merge(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //先切 然后排序子链  最后才合并
            ListNode firstHead = head,secondHead = cut(head);
            //子链有序
            firstHead = merge(firstHead);
            secondHead = merge(secondHead);
            //合并
            ListNode first = firstHead,second = secondHead;
            //哨兵节点  返回时返回下一个节点  弃掉该节点
            ListNode newHead = new ListNode(-1),pre = newHead;
            while (first != null && second != null) {
                if (first.val > second.val) {
                    pre.next = second;
                    pre = pre.next;
                    second = second.next;
                } else {
                    pre.next = first;
                    pre = pre.next;
                    first = first.next;
                }
            }
            if (first == null) {
                while (second != null) {
                    pre.next = second;
                    pre = pre.next;
                    second = second.next;
                }
            }
            if (second == null) {
                while (first != null) {
                    pre.next = first;
                    pre = pre.next;
                    first = first.next;
                }
            }
            return newHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
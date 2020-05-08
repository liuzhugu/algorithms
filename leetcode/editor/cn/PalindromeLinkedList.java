//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针

package leetcode.editor.cn;
//Java：234:回文链表 2020/05/08
public class PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        //TO TEST
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        solution.isPalindrome(node1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            //快慢指针将原链表分为两半
            int count = 1;
            ListNode pre = head,next = head.next;
            while (next != null) {
                next = next.next;
                count ++;
                if (next != null) {
                    next = next.next;
                    count ++;
                }
                pre = pre.next;
            }
            if (count < 2) {
                return true;
            }
            //截断链表
            if (count % 2 == 1) {
                //pre多余 应该删掉
                next = pre.next;
                //将pre跟后面节点截断
                pre.next = next;
                ListNode tmp = head;
                while (tmp.next != pre) {
                    tmp = tmp.next;
                }
                //将pre和前面节点截断
                tmp.next = null;
            } else {
                next = pre;
                ListNode tmp = head;
                while (tmp.next != pre) {
                    tmp = tmp.next;
                }
                //截断
                tmp.next = null;
            }
            pre = head;
            //将后半段反转  比较两者是否相等
            next = reverse(next);
            while (pre != null && next != null) {
                if (pre.val == next.val) {
                    pre = pre.next;
                    next = next.next;
                } else {
                    return false;
                }
            }
            return true;
        }
        //反转链表
        private ListNode reverse(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode pre = head,next = head.next;
            //反转head的指向
            head.next = null;
            while (next != null) {
                ListNode tmp = next.next;
                next.next = pre;
                pre = next;
                next = tmp;
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
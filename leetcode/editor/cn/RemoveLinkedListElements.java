//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表

package leetcode.editor.cn;
//Java：203:移除链表元素 2020/05/31
public class RemoveLinkedListElements{
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
        //TO TEST
        solution.removeElements(LeetCodeTest.stringToListNode("[1,2,6,3,4,5,6]"),6);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode newHead = new ListNode(-1);
            newHead.next = head;
            ListNode pre = newHead,next = head;
            while (next != null) {
                if (next.val != val) {
                    pre.next = next;
                    pre = pre.next;
                }
                next = next.next;
            }
            pre.next = null;
            return newHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
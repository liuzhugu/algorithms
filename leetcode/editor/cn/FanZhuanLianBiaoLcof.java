//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表

package leetcode.editor.cn;

import java.util.Stack;

//Java：面试题24:反转链表 2020/04/22
public class FanZhuanLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //快慢指针  一边遍历
        public ListNode reverseList(ListNode head) {
            ListNode pre = null,next = head;
            while (next != null) {
                ListNode nextNext = next.next;
                if (pre == null) {
                    pre = next;
                    next = next.next;
                    //最后此时的pre是链表尾节点
                    pre.next = null;
                } else {
                    next.next = pre;
                    pre = next;
                    next = nextNext;
                }
            }
            return pre;
        }

        //用栈
//        public ListNode reverseList(ListNode head) {
//            //翻转用栈
//            Stack<ListNode> stack = new Stack<>();
//            while (head != null) {
//                stack.add(head);
//                head = head.next;
//            }
//            ListNode preNode = null,newHead = null;
//            while (! stack.empty()) {
//                ListNode temp = stack.pop();
//                if (preNode == null) {
//                    preNode = temp;
//                    newHead = temp;
//                } else {
//                    preNode.next = temp;
//                    preNode = preNode.next;
//                }
//            }
//            if (preNode != null) {
//                preNode.next = null;
//            }
//            return newHead;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
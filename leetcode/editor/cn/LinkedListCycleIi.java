//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 说明：不允许修改给定的链表。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//你是否可以不用额外空间解决此题？ 
// Related Topics 链表 双指针

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：142:环形链表 II 2020/04/30
public class LinkedListCycleIi{
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        //TO TEST
        ListNode first = new ListNode(1);
        //ListNode second = new ListNode(2);
        //first.next = second;
        //second.next = first;
        solution.detectCycle(first);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {
        //快慢指针  再多一个目标指针 用来判断回环  结束递归条件为快慢指针相等
        public ListNode detectCycle(ListNode head) {
            //先测试是否有回环
            ListNode pre = head,next = head;
            boolean cycle = true;
            while (pre != null) {
                if (pre.next == null) {
                    cycle = false;
                    break;
                }
                pre = pre.next;
                if (next == null) {
                    cycle = false;
                    break;
                } else {
                    next = next.next;
                    if (next == null) {
                        cycle = false;
                        break;
                    } else {
                        next = next.next;
                    }
                }
                if (pre == next) {
                    break;
                }
            }
            //有回环
            if (cycle) {
                pre = head;
                next = head;
                ListNode ans = head;
                while (ans != null) {
                    boolean flag = false;
                    do {
                        pre = pre.next;
                        next = next.next;
                        next = next.next;
                        if (pre == next) {
                            //终止条件为第二次相遇  此时pre从末尾回到第一个回环的地方
                            if (! flag) {
                                flag = true;
                            } else {
                                //如果到了第二次相遇还是pre还是没经过ans  那么ans肯定不是回环内
                                break;
                            }
                        }
                    } while (pre != ans);
                    if (pre == ans) {
                        return pre;
                    }
                    ans = ans.next;
                }
            }
            return null;
        }


//        public ListNode detectCycle(ListNode head) {
//            Set<ListNode> set = new HashSet<>();
//            while (head != null && ! set.contains(head)) {
//                set.add(head);
//                head = head.next;
//            }
//            return head;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
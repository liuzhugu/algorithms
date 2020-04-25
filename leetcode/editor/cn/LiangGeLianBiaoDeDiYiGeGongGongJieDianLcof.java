//输入两个链表，找出它们的第一个公共节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lis
//ts/ 
// 
// Related Topics 链表

package leetcode.editor.cn;
//Java：面试题52:两个链表的第一个公共节点 双指针 2020/04/23
public class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof().new Solution();
        //TO TEST
        ListNode node2 = new ListNode(1);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(8);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(5);
        ListNode headA = new ListNode(4);
        ListNode headB = new ListNode(5);
        headA.next = node2;
        node2.next = node6;
        node6.next = node7;
        node7.next = node8;
        headB.next = node4;
        node4.next = node5;
        node5.next = node6;
        solution.getIntersectionNode(headA,headB);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            //双指针
            ListNode first = headA,second = headB;
            //两个一起走  短的先抵达终点
            while (first != null && second != null) {
                first = first.next;
                second = second.next;
            }
            //让a变为更短的
            if (first != null) {
                second = first;
                ListNode tmp = headA;
                headA = headB;
                headB = tmp;
            }
            ListNode newSecond = headB;
            first = headA;
            //因为b更长  所以让b先走
            while (second != null) {
                second = second.next;
                newSecond = newSecond.next;
            }
            second = newSecond;
            //此时两者到终点的距离相等  因此一起走  相等的时候说明到达公共节点
            while (first != null && second != null) {
                if (first== second) {
                    break;
                }
                first = first.next;
                second = second.next;
            }
            return first;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
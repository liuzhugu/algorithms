package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuzhugu on 2019/12/26.
 * 1171. 从链表中删去总和值为零的连续节点
 * 给你一个链表的头节点head，请你编写代码，反复删去链表中由总和值为0的连续节点组成的序列，
 * 直到不存在这样的序列为止。删除完毕后，请你返回最终结果链表的头节点。
 * 你可以返回任何满足题目要求的答案。
 */
public class RemoveZeroSumSublists {
    //某一段序列总和为零 那么就是说其前后的前缀和相等
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        int sum = 0;
        Map<Integer,ListNode> map = new HashMap<>();
        //遍历求和
        ListNode cur = pre;
        while (cur != null) {
            sum = sum + cur.val;
            map.put(sum,cur);
            cur = cur.next;
        }

        cur = pre;
        sum = 0;
        //再遍历求和
        while (cur != null) {
            sum = sum + cur.val;
            //因为map相同key的多次赋值会覆盖之前的值
            //因此根据sum去取值会得到最后一次前缀和跟当前节点前缀和相同的节点
            //那么当前节点到那个节点之间的节点之和为零，因此直接连接两者
            //相当于在链表中删去这部分节点
            cur.next = map.get(sum).next;
            cur = cur.next;
        }
        return pre.next;
    }
}

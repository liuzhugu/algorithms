package leetcode.editor.cn;

import leetcode.editor.cn.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2019/12/06.
 * 1019. 链表中的下一个更大节点
 * 给出一个以头节点head作为第一个节点的链表。链表中的节点分别编号为:node_1,node_2,node_3,... 。
 * 每个节点都可能有下一个更大值(next larger value):对于node_i,如果其next_larger(node_i)是 
 * node_j.val,那么就有j>i且node_j.val > node_i.val,而j是可能的选项中最小的那个
 * 如果不存在这样的j,那么下一个更大值为0 
 */
public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int[] array = new int[nums.size()];
        int j = 0;
        for (int i : nums) {
            array[j++] = i;
        }
        int[] result = new int[array.length];
        result[array.length - 1] = 0;
        int max = array[array.length - 1];
        for (int i = array.length - 2; i >= 0;i --) {
            if (array[i] < array[i + 1]) {
                result[i] = array[i + 1];
            }else if (array[i] == array[i + 1]){
                result[i] = result[i + 1];
            }else {
                if (result[i + 1] > array[i]) {
                    result[i] = result[i + 1];
                }else if(result[i + 1] <= array[i] && array[i] < max) {
                    //遍历查找
                    int nextLarger;
                    for (int k = i + 1;k < array.length;k ++) {
                        if (array[k] > array[i]) {
                            result[i] = array[k];
                            break;
                        }
                    }
                }else {
                    result[i] = 0;
                }
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        return result;
    }
}

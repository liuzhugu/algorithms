//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法

package leetcode.editor.cn;
//Java：23:合并K个排序链表 2020/04/26
public class MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode result = null;
            if(lists == null || lists.length == 0){
                return result;
            }
            int n = lists.length;
            while(n > 1){
                int tmp = (n + 1) / 2;
                for(int i = 0;i < tmp;i ++){
                    //两两合并 从顶点开始  依次将两个链表合并往上
                    if((i + 1) * 2 > n){
                        lists[i] = lists[i * 2];
                    }else{
                        lists[i] = mergeTwoLists(lists[i * 2],lists[i * 2 + 1]);
                    }
                }
                n = tmp;
            }
            result = lists[0];
            return result;
        }
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = null,current = null;
            if(l1 == null){
                return l2;
            }
            if(l2 == null){
                return l1;
            }
            //步进
            while(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    if(result == null && current == null){
                        result = current = l1;
                        l1 = l1.next;
                    }else{
                        current.next = l1;
                        current = current.next;
                        l1 = l1.next;
                    }
                }else{
                    if(result == null && current==null){
                        result = current = l2;
                        l2 = l2.next;
                    }else{
                        current.next = l2;
                        current = current.next;
                        l2 = l2.next;
                    }
                }
            }
            if(l1 == null && l2 != null){
                while(l2 != null){
                    current.next = l2;
                    current = current.next;
                    l2 = l2.next;
                }
            }
            if(l2 == null && l1 != null){
                while(l1 != null){
                    current.next = l1;
                    current = current.next;
                    l1 = l1.next;
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
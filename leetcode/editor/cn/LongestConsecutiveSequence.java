//给定一个未排序的整数数组，找出最长连续序列的长度。 
//
// 要求算法的时间复杂度为 O(n)。 
//
// 示例: 
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。 
// Related Topics 并查集 数组

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：128:最长连续序列 2020/04/29
public class LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        //TO TEST
        solution.longestConsecutive(new int[]{0});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //递归找根节点
        int find(int i){
            //如果有根节点  那么继续递归  另外为了缩短遍历距离  让当前节点指向根节点
            int parent = i;
            while (parent != uf.get(parent)) {
                parent = uf.get(parent);
            }
            uf.put(i,parent);
            return parent;
        }
        int merge(int x, int y){
            //先找两者的共同父节点 如果已经两者有同样的跟节点  那么该连续序列已连通  可以直接返回
            x = find(x);
            y = find(y);
            //因为x在y前面 所以该序列起点是x
            if (x == y) return cnt.get(x);
            //如果没连通 但x和y是可以连通的 所以把他们连通起来  即y的根节点是x
            uf.put(y,x);
            //之前两者不连通  现在两者连通了 那么连通量相当于两者之和
            cnt.put(x,cnt.get(x) + cnt.get(y));
            return cnt.get(x);
        }
        private Map<Integer,Integer> uf = new HashMap<>(),cnt = new HashMap<>();
        int longestConsecutive(int[] nums) {
            if(nums == null ||nums.length == 0) return 0;
            //初始化
            for (int num : nums) {
                //当前节点的根节点是他自己
                uf.put(num,num);
                //当前节点之只自己连通
                cnt.put(num,1);
            }
            int ans = 1;
            for (int num : nums) {
                //如果有下一位  和它连接起来
                if (num != Integer.MAX_VALUE && uf.get(num + 1) != null) {
                    //求连接以后的长度
                    ans = Math.max(ans,merge(num,num + 1));
                }
            }
            return ans;
        }

//        public int longestConsecutive(int[] nums) {
//            Map<Integer,Node> map = new HashMap<>();
//            //建立联系
//            for (int num : nums) {
//                Node node = new Node(num);
//                if (map.containsKey(num - 1)) {
//                    Node preNode = map.get(num - 1);
//                    preNode.next = node;
//                }
//                if (map.containsKey(num + 1)) {
//                    Node nextNode = map.get(num + 1);
//                    node.next = nextNode;
//                }
//                map.put(num,node);
//            }
//            //输出最长的长度
//            int ans = 0;
//            for (Node node : map.values()) {
//                int count = 0;
//                while (node != null) {
//                    count ++;
//                    node = node.next;
//                }
//                ans = Math.max(ans,count);
//            }
//            return ans;
//        }
//        class Node {
//            int val;
//            Node next;
//            public Node(int val) {
//                this.val = val;
//            }
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
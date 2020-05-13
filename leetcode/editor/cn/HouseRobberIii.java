//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：337:打家劫舍 III   动态规划 2020/05/12
public class HouseRobberIii{
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
        //TO TEST
        solution.rob(LeetCodeTest.stringToTreeNode("[3,2,3,null,3,null,1]"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        //dp
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            visit(root,true);
            return selectMap.get(root) > noSelectMap.get(root) ? selectMap.get(root) : noSelectMap.get(root);
        }
        private Map<TreeNode,Integer> selectMap = new HashMap<>();
        private Map<TreeNode,Integer> noSelectMap = new HashMap<>();
        private int visit(TreeNode root,boolean canSelect) {
            if (root == null) {
                return 0;
            }
            if (! selectMap.containsKey(root)) {
                selectMap.put(root,0);
            }
            if (! noSelectMap.containsKey(root)) {
                noSelectMap.put(root,0);
            }
            //防止重复计算
            if (canSelect) {
                if (selectMap.get(root) != 0) {
                    return selectMap.get(root);
                }
            }
            if (! canSelect) {
                if (noSelectMap.get(root) != 0) {
                    return noSelectMap.get(root);
                }
            }
            int left = 0,right = 0,sum = 0;
            //该层能被选择
            if (canSelect) {
                //选择
                left = visit(root.left,false);
                right = visit(root.right,false);
                int selectSum = left + right + root.val;
                selectSum = Math.max(selectSum,selectMap.get(root));
                selectMap.put(root,selectSum);
                //不选
                left = visit(root.left,true);
                right = visit(root.right,true);
                int noSelectSum = left + right;
                noSelectSum = Math.max(noSelectSum,noSelectMap.get(root));
                noSelectMap.put(root,noSelectSum);
                //得到较大的
                sum = Math.max(selectSum,noSelectSum);
            }
            //不能选
            else {
                left = visit(root.left,true);
                right = visit(root.right,true);
                sum = left + right;
                sum = Math.max(sum,noSelectMap.get(root));
                noSelectMap.put(root,sum);
            }
            return sum;
        }

        //复杂度太高
//        public int rob(TreeNode root) {
//            max = Math.max(max,visit(root,true));
//            return max;
//        }
//        private int max = Integer.MIN_VALUE;
//        private int visit(TreeNode root,boolean canSelect) {
//            if (root == null) {
//                return 0;
//            }
//            int left = 0,right = 0,sum = 0;
//            //该层能被选择
//            if (canSelect) {
//                //选择
//                left = visit(root.left,false);
//                right = visit(root.right,false);
//                int selectSum = left + right + root.val;
//                max = Math.max(max,selectSum);
//                //不选
//                left = visit(root.left,true);
//                right = visit(root.right,true);
//                int noSelectSum = left + right;
//                max = Math.max(max,noSelectSum);
//                sum = Math.max(selectSum,noSelectSum);
//            }
//            //不能选
//            else {
//                left = visit(root.left,true);
//                right = visit(root.right,true);
//                sum = left + right;
//                max = Math.max(max,sum);
//            }
//            return sum;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
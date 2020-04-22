//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：面试题26:树的子结构 2020/04/22
public class ShuDeZiJieGouLcof{
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
        //TO TEST
        solution.isSubStructure(LeetCodeTest.stringToTreeNode("[3,4,5,1,2]"),LeetCodeTest
                .stringToTreeNode("[4,1]"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return false;
            }
            find(A,B.val);
            if (! list.isEmpty()) {
                //试试所有可能情况
                for (TreeNode node : list) {
                    if (visit(node,B)) {
                        return true;
                    }
                }
            }
            return false;
        }
        private boolean visit(TreeNode left,TreeNode right) {
            if (left == null) {
                return false;
            }
            //先比较值  再比较结构  并且是只比较右边有的结构
            //如果左边对不上 那么就是不满足条件
            if (left.val != right.val) {
                return false;
            }
            boolean ans = true;
            //递归比较子树
            if (right.left != null) {
                ans = ans && visit(left.left,right.left);
            }
            if (right.right != null) {
                ans = ans && visit(left.right,right.right);
            }
            return ans;
        }
        //根据值找节点
        private Set<TreeNode> list = new HashSet<>();
        private void find(TreeNode root,int val) {
            if (root.val == val) {
                list.add(root);
            }
            if (root.left != null) {
                find(root.left,val);
            }
            if (root.right != null) {
                find(root.right,val);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
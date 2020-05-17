//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节
//点值之和。 
//
// 
//
// 例如： 
//
// 输入: 原始二叉搜索树:
//              5
//            /   \
//           2     13
//
//输出: 转换为累加树:
//             18
//            /   \
//          20     13
// 
//
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
//um-tree/ 相同 
// Related Topics 树

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：538:把二叉搜索树转换为累加树 2020/05/17
public class ConvertBstToGreaterTree{
    public static void main(String[] args) {
        Solution solution = new ConvertBstToGreaterTree().new Solution();
        //TO TEST
        solution.convertBST(LeetCodeTest.stringToTreeNode("[5,2,13]"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            //得到前缀和
            inOrder(root);
            list.add(0);
            for (int i = list.size() - 2;i >= 0;i --) {
                list.set(i,list.get(i + 1) + list.get(i));
            }
            inSum(root);
            return root;
        }
        private List<Integer> list = new ArrayList<>();
        //中序序遍历  统计值  然后计算前缀和
        private void inOrder(TreeNode treeNode) {
            if (treeNode == null) {
                return;
            }
            inOrder(treeNode.left);
            list.add(treeNode.val);
            inOrder(treeNode.right);
        }
        private int index = 1;
        //加
        private void inSum(TreeNode treeNode) {
            if (treeNode == null) {
                return;
            }
            inSum(treeNode.left);
            treeNode.val = treeNode.val + list.get(index ++);
            inSum(treeNode.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
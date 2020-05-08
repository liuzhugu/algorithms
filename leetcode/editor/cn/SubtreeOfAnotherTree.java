//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：572:另一个树的子树 2020/05/08
public class SubtreeOfAnotherTree{
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            //找到所有值相同的节点  然后遍历访问
            find(s,t.val);
            if (list.isEmpty()) {
                return false;
            }
            for (int i = 0;i < list.size();i ++) {
                if (visit(list.get(i),t)) {
                    return true;
                }
            }
            return false;
        }
        private List<TreeNode> list = new ArrayList<>();
        private boolean visit(TreeNode first,TreeNode second) {
            if (first == null && second == null) {
                return true;
            }
            if (first == null || second == null) {
                return false;
            }
            if (first.val != second.val) {
                return false;
            }
            return visit(first.left,second.left) && visit(first.right,second.right);
        }
        private void find (TreeNode root,int target) {
            if (root == null) {
                return;
            }
            if (root.val == target) {
                list.add(root);
            }
            find(root.left,target);
            find(root.right,target);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
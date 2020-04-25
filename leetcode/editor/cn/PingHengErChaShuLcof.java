//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 1 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;
//Java：面试题55 - II:平衡二叉树  2020/04/23
public class PingHengErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new PingHengErChaShuLcof().new Solution();
        //TO TEST
        solution.isBalanced(LeetCodeTest.stringToTreeNode("[1,2,2,3,3,null,null,4,4]"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isBalanced(TreeNode root) {
            visit(root);
            return ans;
        }
        private boolean ans = true;
        private int visit(TreeNode root) {
            if (root == null) return 0;
            int left = visit(root.left) + 1,right = visit(root.right) + 1;
            if (Math.abs(left - right) > 1) {
                ans = false;
            }
            return left > right ? left : right;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;
//Java：124:二叉树中的最大路径和  深度优先遍历 2020/04/29
public class BinaryTreeMaximumPathSum{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        //TO TEST
        solution.maxPathSum(LeetCodeTest.stringToTreeNode("[-10,19,20,null,null,15,7]"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public int maxPathSum(TreeNode root) {
            int ans = visit(root);
            ans = Math.max(max,ans);
            return ans;
        }
        private int max = Integer.MIN_VALUE;
        private int visit(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = 0,right = 0;
            left = visit(root.left);
            right = visit(root.right);
            //只看该点和左右子树
            max = Math.max(max,left + right + root.val);
            //该点总和
            int sum = root.val;
            //该点和左子树总和
            sum = Math.max(sum,root.val + left);
            //该点和右子树总和
            sum = Math.max(sum,root.val + right);
            max = Math.max(max,sum);
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
//e/ 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;
//Java：面试题55 - I:二叉树的深度  深度遍历 2020/04/20
public class ErChaShuDeShenDuLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeShenDuLcof().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int maxDepth(TreeNode root) {
            //深度优先遍历
            visit(root,1);
            return maxDepth;
        }
        int maxDepth = 0;
        private void visit(TreeNode root,int depth) {
            if (root == null) return;
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            visit(root.left,depth + 1);
            visit(root.right,depth + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
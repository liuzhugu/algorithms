//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树

package leetcode.editor.cn;
//Java：617:合并二叉树 2020/05/17
public class MergeTwoBinaryTrees{
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
        //TO TEST
        solution.mergeTrees(LeetCodeTest.stringToTreeNode("[1,3,2,5]"),
                LeetCodeTest.stringToTreeNode("[2,1,3,null,4,null,7]"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            return visit(t1,t2);
        }
        private TreeNode visit(TreeNode t1,TreeNode t2) {
            //将t2对应部分移过来
            if (t1 == null) {
                return t2;
            }
            //下面的不用处理了
            if (t2 == null) {
                return t1;
            }
            t1.val = t1.val + t2.val;
            //递归合并
            t1.left = visit(t1.left,t2.left);
            t1.right = visit(t1.right,t2.right);
            return t1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
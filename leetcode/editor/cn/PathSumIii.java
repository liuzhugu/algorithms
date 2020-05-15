//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树

package leetcode.editor.cn;



//Java：437:路径总和 III 2020/05/15
public class PathSumIii{
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        //TO TEST
        solution.pathSum(LeetCodeTest.stringToTreeNode("[1,1]"),1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int pathSum(TreeNode root, int sum) {
            return pathSum(root, sum, new int[1000], 0);
        }
        private int count = 0;
        private int pathSum(TreeNode root,int target,int[] path,int index) {
            if (root == null) {
                return 0;
            }
            int sum = 0;
            int n = 0;
            path[index] = root.val;
            for (int i = index;i >= 0;i --) {
                sum = sum + path[i];
                if (sum == target) {
                    n ++;
                }
            }
            int nLeft = pathSum(root.left,target,path,index + 1);
            int nRight = pathSum(root.right,target,path,index + 1);
            return n + nLeft + nRight;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
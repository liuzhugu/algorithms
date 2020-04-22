//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
// 4 
// / \ 
// 2 7 
// / \ / \ 
//1 3 6 9 
//镜像输出： 
//
// 4 
// / \ 
// 7 2 
// / \ / \ 
//9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：面试题27:二叉树的镜像 广度优先遍历  2020/04/22
public class ErChaShuDeJingXiangLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeJingXiangLcof().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            while (! list.isEmpty()) {
                List<TreeNode> nextList = new ArrayList<>();
                for (TreeNode node : list) {
                    if (node.left != null) {
                        nextList.add(node.left);
                    }
                    if (node.right != null) {
                        nextList.add(node.right);
                    }
                    //交换每个节点的左右节点
                    TreeNode tmp = node.left;
                    node.left = node.right;
                    node.right = tmp;
                }
                list.clear();
                list = nextList;
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
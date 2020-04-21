//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：199:二叉树的右视图  2020/04/22
public class BinaryTreeRightSideView{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            //优先访问右子树 右子树没有 才访问左边
            List<Integer> ans = new ArrayList<>();
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            ans.add(root.val);
            while (! list.isEmpty()) {
               List<TreeNode> nextList = new ArrayList<>();
               for (TreeNode node : list) {
                   if (node.left != null) {
                       nextList.add(node.left);
                   }
                   if (node.right != null) {
                       nextList.add(node.right);
                   }
               }
               //去下一层最右边的值
               ans.add(nextList.get(nextList.size() - 1).val);
               list.clear();
               list = nextList;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
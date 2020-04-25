//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：面试题54:二叉搜索树的第k大节点 中序遍历 2020/04/23
public class ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthLargest(TreeNode root, int k) {
            //二叉树的排序就是中序遍历的顺序
            inOrder(root);
            int ans = 0;
            if (root != null) {
                ans = list.get(list.size() - k);
            }
            return ans;
        }
        private List<Integer> list = new ArrayList<>();
        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
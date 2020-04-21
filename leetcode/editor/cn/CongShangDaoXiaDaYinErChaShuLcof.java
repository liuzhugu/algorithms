//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：面试题32 - I:从上到下打印二叉树 队列 2020/04/21
public class CongShangDaoXiaDaYinErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[]{};
            }
            List<TreeNode> list = new ArrayList<>();
            List<Integer> ans = new ArrayList<>();
            list.add(root);
            while (! list.isEmpty()) {
                List<TreeNode> nextList = new ArrayList<>();
                for (TreeNode node : list) {
                    ans.add(node.val);
                    if (node.left != null) {
                        nextList.add(node.left);
                    }
                    if (node.right != null) {
                        nextList.add(node.right);
                    }
                }
                list.clear();
                list = nextList;
            }
            int[] res = new int[ans.size()];
            for (int i = 0;i < ans.size();i ++) {
                res[i] = ans.get(i);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
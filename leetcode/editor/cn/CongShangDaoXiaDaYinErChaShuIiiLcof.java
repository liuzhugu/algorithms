//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
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

//Java：面试题32 - III:从上到下打印二叉树 III 2020/04/21
public class CongShangDaoXiaDaYinErChaShuIiiLcof{
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
        //TO TEST
        solution.levelOrder(LeetCodeTest.stringToTreeNode("[3,9,20,null,null,15,7]"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<TreeNode> list = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            list.add(root);
            int level = 0;
            while (! list.isEmpty()) {
                List<TreeNode> nextList = new ArrayList<>();
                List<Integer> tmp = new ArrayList<>();
                //逆序遍历
                for (int i = list.size() - 1;i >= 0;i --) {
                    TreeNode node = list.get(i);
                    tmp.add(node.val);
                    //
                    if (level % 2 == 0) {
                        if (node.left != null) {
                            nextList.add(node.left);
                        }
                        if (node.right != null) {
                            nextList.add(node.right);
                        }
                    } else {
                        if (node.right != null) {
                            nextList.add(node.right);
                        }
                        if (node.left != null) {
                            nextList.add(node.left);
                        }
                    }
                }
                ans.add(tmp);
                list.clear();
                list = nextList;
                level ++;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
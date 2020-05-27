//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。 
//
// 说明： 
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1 
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
//输出: 3 
//
// 进阶： 
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？ 
// Related Topics 树 二分查找

package leetcode.editor.cn;

import java.util.LinkedList;

//Java：230:二叉搜索树中第K小的元素 2020/05/23
public class KthSmallestElementInABst{
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABst().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            inOrder(root);
            return queue.get(k - 1);
        }
        //中序访问
        private void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);
            queue.add(root.val);
            inOrder(root.right);
        }
        LinkedList<Integer> queue = new LinkedList<>();
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
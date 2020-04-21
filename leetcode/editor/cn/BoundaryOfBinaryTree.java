//给定一棵二叉树，以逆时针顺序从根开始返回其边界。边界按顺序包括左边界、叶子结点和右边界而不包括重复的结点。 (结点的值可能重复) 
//
// 左边界的定义是从根到最左侧结点的路径。右边界的定义是从根到最右侧结点的路径。若根没有左子树或右子树，则根自身就是左边界或右边界。注意该定义只对输入的二叉树
//有效，而对子树无效。 
//
// 最左侧结点的定义是：在左子树存在时总是优先访问，如果不存在左子树则访问右子树。重复以上操作，首先抵达的结点就是最左侧结点。 
//
// 最右侧结点的定义方式相同，只是将左替换成右。 
//
// 示例 1 
//
// 输入:
//  1
//   \
//    2
//   / \
//  3   4
//
//输出:
//[1, 3, 4, 2]
//
//解析:
//根不存在左子树，故根自身即为左边界。
//叶子结点是3和4。
//右边界是1，2，4。注意逆时针顺序输出需要你输出时调整右边界顺序。
//以逆时针顺序无重复地排列边界，得到答案[1,3,4,2]。
// 
//
// 
//
// 示例 2 
//
// 输入:
//    ____1_____
//   /          \
//  2            3
// / \          / 
//4   5        6   
//   / \      / \
//  7   8    9  10  
//       
//输出:
//[1,2,4,7,8,9,10,6,3]
//
//解析:
//左边界是结点1,2,4。(根据定义，4是最左侧结点)
//叶子结点是结点4,7,8,9,10。
//右边界是结点1,3,6,10。(10是最右侧结点)
//以逆时针顺序无重复地排列边界，得到答案 [1,2,4,7,8,9,10,6,3]。
// 
//
// 
// Related Topics 树

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：545:二叉树的边界   2020/04/22
public class BoundaryOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new BoundaryOfBinaryTree().new Solution();
        //TO TEST
        solution.boundaryOfBinaryTree(new TreeNode(1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> ans = new ArrayList<>();
            if (root.left == null && root.right == null) {
                ans.add(root.val);
                return ans;
            }
            //左边界等于一直优先访问左节点
            TreeNode left = root;
            ans.add(left.val);
            left = left.left;
            while (left != null) {
                ans.add(left.val);
                if (left.left != null) {
                    left = left.left;
                } else if (left.left == null && left.right != null){
                    left = left.right;
                } else {
                    left = null;
                }
            }
            //叶子节点等于 后序访问 并且没有子树的节点的集合
            List<Integer> leaf = new ArrayList<>();
            postorder(root,leaf);
            //如果最左叶子节点归于左边界  最右叶子节点归于右边界  因此去掉这两个
            if (root.left != null) {
                leaf.remove(0);
            }
            ans.addAll(leaf);
            //右边界等于一直优先访问右节点 没有右节点才访问左节点  最后逆序
            List<Integer> rightList = new ArrayList<>();
            TreeNode right = root;
            rightList.add(right.val);
            right = right.right;
            while (right != null) {
                rightList.add(right.val);
                if (right.right != null) {
                    right = right.right;
                } else if (right.right == null && right.left != null){
                    right = right.left;
                } else {
                    right = null;
                }
            }
            //因为根节点归于左边界 因此去掉
            rightList.remove(0);
            //如果右边界不止根节点  那么删除最右节点 因为那属于叶子节点
            if (root.right != null) {
                rightList.remove(rightList.size() - 1);
            }
            //逆序
            List<Integer> tmp = new ArrayList<>();
            for (int i = rightList.size() - 1;i >= 0;i --) {
                tmp.add(rightList.get(i));
            }
            ans.addAll(tmp);
            return ans;
        }
        //后序
        private void postorder(TreeNode root,List<Integer> leaf) {
            if (root.left != null) {
                postorder(root.left,leaf);
            }
            if (root.right != null) {
                postorder(root.right,leaf);
            }
            if (root.left == null && root.right == null) {
                leaf.add(root.val);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
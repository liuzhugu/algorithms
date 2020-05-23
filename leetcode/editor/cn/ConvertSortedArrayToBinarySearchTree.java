//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;
//Java：108:将有序数组转换为二叉搜索树 2020/05/18
public class ConvertSortedArrayToBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        //TO TEST
        solution.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            TreeNode root = build(nums,0,nums.length - 1);
            return root;
        }
        private TreeNode build(int[] nums,int start,int end) {
            if (start > end) {
                return null;
            }
            if (start == end) {
                return new TreeNode(nums[start]);
            }
            //为了平衡  取中点作为跟节点
            int mid = (end + start + 1) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = build(nums,start,mid - 1);
            root.right = build(nums,mid + 1,end);
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;

/**
 * Created by liuzhugu on 2020/03/07.
 * 1302. 层数最深叶子节点的和
 *  给你一棵二叉树，请你返回层数最深的叶子节点的和。
 */
public class DeepestLeavesSum {
    private int maxDepth = 0,sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return sum;
        //后序遍历
        visit(root,0);
        return sum;
    }
    void visit(TreeNode root,int depth) {
        if (root.left != null) {
            visit(root.left,depth + 1);
        }
        if (root.right != null) {
            visit(root.right,depth + 1);
        }
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                sum = root.val;
            } else if (depth == maxDepth){
                sum = sum + root.val;
            }
            return;
        }
    }
}

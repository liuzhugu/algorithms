package practice.leetcode;


/**
 * Created by liuzhugu on 2020/03/09.
 * 543. 二叉树的直径
 *  给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 *  这条路径可能穿过根结点。
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        visit(root);
        return length;
    }
    //后序遍历
    private int length = 0;
    private int visit (TreeNode root) {
        if (root == null) return 0;
        //左子树最深加上右子树最深  即为经过改点的最长路径
        int leftDepth = 0,rightDepth = 0;
        leftDepth = visit(root.left);
        rightDepth = visit(root.right);
        length = Math.max(length,leftDepth + rightDepth + 1);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}

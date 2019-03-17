package practice.leetcode;


/**
 * Created by liuzhugu on 2019/03/11.
 * 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
 * 保证原始二叉搜索树中不存在新值。注意，可能存在多种有效的插入方式，
 * 只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left,val);
        }else if(val > root.val) {
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}
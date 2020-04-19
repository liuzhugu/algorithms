package leetcode.editor.cn;


/**
 * Created by liuzhugu on 2019/03/24.
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        //深度优先遍历
        deep(root,null);
    }
    private TreeNode deep(TreeNode root,TreeNode parent) {
        if (root != null) {
            if (parent != null) {
                parent.right = root;
            }
        }else {
            return null;
        }
        TreeNode lastNode = root;
        TreeNode left = root.left,right = root.right;
        root.left = null;
        root.right = null;
        if (left != null) {
            TreeNode leftLastNode = deep(left,root);
            if (leftLastNode != null) {
                lastNode = leftLastNode;
            }
            if (right != null) {
                TreeNode rightLastNode = deep(right,lastNode);
                if (rightLastNode != null) {
                    lastNode = rightLastNode;
                }
            }
        }else {
            if (right != null) {
                TreeNode rightLastNode = deep(right,lastNode);
                if (rightLastNode != null) {
                    lastNode = rightLastNode;
                }
            }
        }
        return lastNode;
    }
}

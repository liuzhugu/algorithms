package practice.leetcode;
/**
 * Created by liuzhugu on 2020/01/03.
 * 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度
 */
public class DeleteTreeNode {
    //前驱节点 左子树的最右节点
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
    //后继节点 右子树的最左节点
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        //二叉搜索
        if (root.val > key) {
            root.left = deleteNode(root.left,key);
        }else if (root.val < key) {
            root.right = deleteNode(root.right,key);
        }else {
            if (root.left == null && root.right == null) {
                root = null;
            }else if (root.right == null) {
                int newKey = predecessor(root);
                root.val = newKey;
                root.left = deleteNode(root.left,newKey);
            }else {
                int newKey = successor(root);
                root.val = newKey;
                root.right = deleteNode(root.right,newKey);
            }
        }
        return root;
    }

}

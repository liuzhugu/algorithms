package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2020/01/07.
 * 919. 完全二叉树插入器
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，结点数达到最大）的，并且所有的结点都尽可能地集中在左侧。设计一个用完全二叉树
 * 初始化的数据结构 CBTInserter，它支持以下几种操作：
 * CBTInserter(TreeNode root) 使用头结点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v) 将 TreeNode 插入到存在值为 node.val = v  的树中以使其保持完全二叉树的状态，
 *  并返回插入的 TreeNode 的父结点的值；
 * CBTInserter.get_root() 将返回树的头结点
 */
public class CBTInserter {
    private static int[] tree;
    //计数
    private static int count = 0;
    public CBTInserter(TreeNode root) {
        if (root == null) {
            tree = new int[16];
        }else {
            //广度遍历
            List<Integer> valList = new ArrayList<>();
            List<TreeNode> treeNodes = new ArrayList<>();
            treeNodes.add(root);
            while (! treeNodes.isEmpty()) {
                List<TreeNode> tmp = new ArrayList<>();
                for (TreeNode node : treeNodes) {
                    valList.add(node.val);
                    if (node.left != null) {
                        tmp.add(node.left);
                    }
                    if (node.right != null) {
                        tmp.add(node.right);
                    }
                }
                treeNodes = tmp;
            }
            int n = 0;
            while (Math.pow(2,n) <= valList.size()) {
                n ++;
            }
            int index = 0;
            tree = new int[(int)Math.pow(2,n)];
            for (int val : valList) {
                tree[index ++] = val;
                count ++;
            }
        }
    }
    private void grow() {
        if (count == tree.length) {
            int[] tmp = new int[count * 2];
            System.arraycopy(tree,0,tmp,0,tree.length);
            tree = tmp;
        }
    }

    public int insert(int v) {
        tree[count ++] = v;
        grow();
        if (count == 1) {
            return 0;
        }else {
            return tree[(count / 2) - 1];
        }
    }

    public TreeNode get_root() {
        if (count == 0) return null;
        //根据数据反向生成树
        int left = 0,right = 1,n = 1;
        List<TreeNode> nodes = new ArrayList<>();
        TreeNode root = null;
        do {
            for (;left < right;left ++) {
                if (nodes.isEmpty()) {
                    root = new TreeNode(tree[0]);
                    nodes.add(root);
                }else {
                    TreeNode parent = nodes.get((left - 1) / 2);
                    TreeNode node = new TreeNode(tree[left]);
                    if ((left + 1) % 2 == 0) {
                        //左子树
                        parent.left = node;
                    }else {
                        //右子树
                        parent.right = node;
                    }
                    nodes.add(node);
                }
            }
            left = right;
            int nextRight = right + (int) Math.pow(2,n);
            n ++;
            right = nextRight > count ? count : nextRight;
        }while (left < count);
        return root;
    }
}

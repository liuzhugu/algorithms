package practice.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2020/02/12.
 * 面试题68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestor {
    private  List<TreeNode> first = new ArrayList<>();
    private  List<TreeNode> second = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        preOrde(new ArrayList<>(),root,p,q);
        TreeNode result = null;
        int index = 0;
        while (index < first.size() && index < second.size()) {
            if (first.get(index).val == second.get(index).val) {
                result = first.get(index);
                index ++;
            }else {
                break;
            }
        }
        return result;
    }
    void preOrde(List<TreeNode> list,TreeNode root,TreeNode p,TreeNode q) {
        list.add(root);
        if (root.val == p.val) {
            first = new ArrayList<>(list);
        }
        if (root.val == q.val) {
            second = new ArrayList<>(list);
        }
        if (root.left != null) {
            preOrde(list,root.left,p,q);
        }
        if (root.right != null) {
            preOrde(list,root.right,p,q);
        }
        list.remove(root);
    }

}

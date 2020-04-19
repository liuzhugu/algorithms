package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2019/07/19.
 * 971. 翻转二叉树以匹配先序遍历
 * 给定一个有 N 个节点的二叉树，每个节点都有一个不同于其他节点且处于 {1, ..., N} 中的值。
 * 通过交换节点的左子节点和右子节点，可以翻转该二叉树中的节点。
 * 考虑从根节点开始的先序遍历报告的 N 值序列。将这一 N 值序列称为树的行程。
 * （回想一下，节点的先序遍历意味着我们报告当前节点的值，然后先序遍历左子节点，再先序遍历右子节点。）
 * 我们的目标是翻转最少的树中节点，以便树的行程与给定的行程 voyage 相匹配。 
 * 如果可以，则返回翻转的所有节点的值的列表。你可以按任何顺序返回答案。
 * 如果不能，则返回列表 [-1]。
 */

public class FlipMatchVoyage {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> result =  new ArrayList<>();
        preOrder(root,result,voyage);
        return result;
    }
    //先序遍历
    private static int index = 0;
    private void preOrder(TreeNode root, List<Integer> result,int[] voyage) {
        if(root != null) {
            //如果一样,继续递归
            if(root.val == voyage[index ++]) {
                //判断是否需要翻转
                if(root.left != null) {
                    if(root.left.val != voyage[index]) {
                        TreeNode tmp = root.left;
                        root.left = root.right;
                        root.right = tmp;
                        //该节点作为翻转节点之一
                        result.add(root.val);
                    }
                    preOrder(root.left,result,voyage);
                }
                if(root.right != null) {
                    preOrder(root.right,result,voyage);
                }
            }else{
                result.clear();
                result.add(-1);
                return;
            }
        }
    }
}

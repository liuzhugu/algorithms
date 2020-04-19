package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by liuzhugu on 2019/12/27.
 * 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 */
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        visit(root,0,result);
        return result;
    }
    void visit(TreeNode root,int high,List<Integer> result) {
        if (root == null)return;
        if (result.size() < high + 1) {
            result.add(root.val);
        }else {
            if (root.val > result.get(high)) {
                result.set(high,root.val);
            }
        }
        visit(root.left,high + 1,result);
        visit(root.right,high + 1,result);
    }
}

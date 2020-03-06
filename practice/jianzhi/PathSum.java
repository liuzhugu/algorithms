package practice.jianzhi;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    //先序遍历
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        visit(root,sum,new ArrayList<>(),0);
        return result;
    }
    void visit(TreeNode root,int goal,List<Integer> nodes,int sum) {
        if (sum + root.val > goal) return;
        nodes.add(root.val);
        sum = sum + root.val;
        if (root.left ==null && root.right == null && sum == goal) {
            result.add(new ArrayList<>(nodes));
            nodes.remove(nodes.size() - 1);
            return;
        }
        if (root.left != null) {
            visit(root.left,goal,nodes,sum);
        }
        if (root.right != null) {
            visit(root.right,goal,nodes,sum);
        }
        //删除最后一个节点
        nodes.remove(nodes.size() - 1);
    }
}

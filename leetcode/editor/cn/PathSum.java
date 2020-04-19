package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2019/12/15.
 * 813. 最大平均值和的分组
 * 我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。
 * 计算我们所能得到的最大分数是多少。注意我们必须使用 A 数组中的每一个数进行分组，
 * 并且分数不一定需要是整数
 */
public class PathSum {
    //先序遍历
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)return result;
        preOrder(root,new ArrayList<>(),0,sum);
        return result;
    }
    public void preOrder(TreeNode root, List<Integer> nums,int sum,int goal) {
        sum = sum + root.val;
        nums.add(root.val);
        if (root.left == null && root.right == null && sum == goal) {
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(nums);
            result.add(tmp);
        }
        if (root.left != null) {
            preOrder(root.left,nums,sum,goal);
        }
        if (root.right != null) {
            preOrder(root.right,nums,sum,goal);
        }
        nums.remove(nums.size() - 1);
    }
}

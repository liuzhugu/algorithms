package practice.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzhugu on 2019/03/11.
 * 508. 出现次数最多的子树元素和
 * 给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为
 * 根的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树元素和。
 * 如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）
 */
public class FindFrequentTreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[1];
        }
        List<Integer> sums = new ArrayList<>();
        getSum(root,sums);
        //统计各和出现次数
        Map<Integer,Integer> sumCount = new HashMap<>();
        for (Integer sum : sums) {
            Integer count = sumCount.get(sum);
            if (count == null) {
                count = 0;
            }
            sumCount.put(sum,count + 1);
        }
        int maxSum = 0;
        for (Map.Entry<Integer,Integer> count : sumCount.entrySet()) {
            if (count.getValue() > maxSum) {
                maxSum = count.getValue();
            }
        }
        List<Integer> maxSumList = new ArrayList<>();
        for (Map.Entry<Integer,Integer> count : sumCount.entrySet()) {
            if (count.getValue() == maxSum) {
                maxSumList.add(count.getKey());
            }
        }
        int[] result = new int[maxSumList.size()];
        for (int i = 0;i < maxSumList.size();i ++) {
            result[i] = maxSumList.get(i);
        }
        return result;
    }
    private int getSum(TreeNode root, List<Integer> sums) {
        int leftSum = 0,rightSum = 0;
        if (root.left != null) {
            leftSum = getSum(root.left,sums);
        }
        if (root.right != null) {
            rightSum = getSum(root.right,sums);
        }
        int sum = root.val + leftSum + rightSum;
        sums.add(sum);
        return sum;
    }
}

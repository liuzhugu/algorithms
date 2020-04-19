package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2019/03/21.
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
 * 并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 *
 */
public class CombinationSum3 {
    //回溯法
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0 || n == 0) {
            return new ArrayList<>();
        }
        List<Integer> nums = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        nextStep(nums,k,1,0,n,result);
        return result;
    }
    private void nextStep(List<Integer> nums,int size,int n,int sum,int goal,List<List<Integer>> result) {
        if (nums.size() == size && sum == goal) {
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(nums);
            result.add(tmp);
            return;
        }
        if ((sum + n) > goal || nums.size() > size || n > 9) {
            return;
        }
        //当前数不加入
        nextStep(nums,size,n + 1,sum,goal,result);
        //当前数加入
        nums.add(n);
        sum = sum + n;
        nextStep(nums,size,n + 1,sum,goal,result);
        nums.remove(new Integer(n));
        return;
    }
}

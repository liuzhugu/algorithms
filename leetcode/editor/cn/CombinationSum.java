//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：39:组合总和  回溯 2020/04/26
public class CombinationSum{
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        //TO TEST
        solution.combinationSum(new int[]{2,3,6,7},7);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            visit(candidates,0,ans,new ArrayList<>(),target);
            return ans;
        }
        private void visit (int[] candidates,int index,List<List<Integer>> ans,List<Integer> list,int balance) {
            if (balance == 0) {
                ans.add(new ArrayList<>(list));
            }
            if (index == candidates.length) {
                return;
            }
            for (int i = index;i < candidates.length;i ++) {
                if (balance < candidates[i]) {
                    break;
                }
                list.add(candidates[i]);
                visit(candidates,i,ans,list,balance - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
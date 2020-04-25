//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Java：46:全排列 2020/04/24
public class Permutations{
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                ans.add(new ArrayList<>());
                return ans;
            }
            visit(nums,0,ans);
            return ans;
        }
        private void visit(int[] nums,int index,List<List<Integer>> ans) {
            if (index == nums.length) {
                ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return;
            }
            //交换位置
            for (int i = index;i < nums.length;i ++) {
                //出现在该位置的只能是后面的字符  因为前面的字符已经确定位置不能动了
                swap(nums,index,i);
                visit(nums,index + 1,ans);
                //复位  继续其他情况的遍历
                swap(nums,i,index);
            }
        }
        private void swap(int[] nums,int start,int end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
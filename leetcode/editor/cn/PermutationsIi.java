//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

//Java：47:全排列 II 2020/04/24
public class PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        //TO TEST
        solution.permuteUnique(new int[]{1,1,2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
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
            //某个数字在该位置只能出现一次 否则重复了
            Set<Integer> set = new HashSet<>();
            for (int i = index;i < nums.length;i ++) {
                if (set.contains(nums[i])) {
                    continue;
                }
                //出现在该位置的只能是后面的字符  因为前面的字符已经确定位置不能动了
                swap(nums,index,i);
                visit(nums,index + 1,ans);
                //复位  继续其他情况的遍历
                swap(nums,i,index);
                set.add(nums[i]);
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
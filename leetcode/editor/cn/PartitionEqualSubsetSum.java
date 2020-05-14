//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划

package leetcode.editor.cn;

import java.util.*;

//Java：416:分割等和子集 2020/05/14
public class PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        //TO TEST
        solution.canPartition(new int[]{1,5,11,5});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //dp  0 - 1背包
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) {
                return true;
            }
            int sum = 0;
            for (int i = 0;i < nums.length;i ++) {
                sum = sum + nums[i];
            }
            if (sum % 2 != 0) {
                return false;
            }
            sum = sum / 2;
            int m = nums.length;
            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;
            for (int i = 0;i < m;i ++) {
                //必须从后往前  因为数字只能用一次
                //从前往后的话 那么该数字会被选多次
                //而从后往前只会用到其他数字的结果
                for (int j = sum;j >= 0;j --) {
                    if (j >= nums[i]) {
                        dp[j] = dp[j] || dp[j - nums[i]];
                    }
                }
            }
            return dp[sum];
        }

//        public boolean canPartition(int[] nums) {
//            if (nums == null || nums.length == 0) {
//                return true;
//            }
//            int sum = 0;
//            for (int i = 0;i < nums.length;i ++) {
//                sum = sum + nums[i];
//            }
//            if (sum % 2 != 0) {
//                return false;
//            }
//            sum = sum / 2;
//            Set<Integer> set = new HashSet<>();
//            set.add(0);
//            for (int i = 0;i < nums.length;i ++) {
//                Set<Integer> tmp = new HashSet<>();
//                tmp.addAll(set);
//                for (int num : set) {
//                    if (num + nums[i] == sum) {
//                        return true;
//                    }
//                    if (num + nums[i] < sum) {
//                        tmp.add(num + nums[i]);
//                    }
//                }
//                set = tmp;
//            }
//            return set.contains(sum);
//        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
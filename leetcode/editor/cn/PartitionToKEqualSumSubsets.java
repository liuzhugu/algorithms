//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 示例 1： 
//
// 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 
// Related Topics 递归 动态规划

package leetcode.editor.cn;

import java.util.Arrays;

//Java：698:划分为k个相等的子集   动态规划
public class PartitionToKEqualSumSubsets{
    public static void main(String[] args) {
        Solution solution = new PartitionToKEqualSumSubsets().new Solution();
        //TO TEST
        System.out.println(1 << 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //任意组合如果等于target  那么组成一组
        // 如果相加之和不等于target二十超过的话  那么这几个不能组成一组  继续试探
        //所以通过通过一个数表示不同组合   然后作为dp组下标  然后试探所有情况  完成对试探情况的备忘录
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);
            int sum = Arrays.stream(nums).sum();
            int target = sum / k;
            if (sum % k > 0 || nums[n - 1] > target) {
                return false;
            }

            boolean[] dp = new boolean[1 << n];
            dp[0] = true;
            int[] total = new int[1 << n];

            // n个位置  第i位为1的时候  表示第i位被选择
            //所以每个state表示整个数组已被选中的状态
            for (int state = 0;state < (1 << n);state ++) {
                //从该状态符合条件    那么在该状态下推及下一个状态
                if (!dp[state]) {
                    continue;
                }
                //继续从数组中选中数   发现超越target  那么去掉  因为不满足条件   进行裁枝
                for (int i = 0;i < n;i ++) {
                    int future = state | (1 << i);
                    //   如果该数未被选    而且   该组合未被计算
                    if (state != future  &&   !dp[future]) {
                        //未越界
                        if (nums[i] <= target - (total[state] % target)) {
                            dp[future] = true;
                            total[future] = total[state] + nums[i];
                        }
                        //越界的话  后面情况不用处理了
                        else {
                            break;
                        }
                    }
                }
            }
            return dp[(1 << n) - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 示例 1: 
//
// 输入: nums: [1, 1, 1, 1, 1], S: 3
//输出: 5
//解释: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 注意: 
//
// 
// 数组非空，且长度不会超过20。 
// 初始的数组的和不会超过1000。 
// 保证返回的最终结果能被32位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划

package leetcode.editor.cn;
//Java：494:目标和 2020/05/17
public class TargetSum{
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        //TO TEST
        solution.findTargetSumWays(new int[]{0,0,0,0,0,0,0,1},1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int i = 0;i < nums.length;i ++) {
                sum = sum + nums[i];
            }
            if (S > sum || S < -sum) {
                return 0;
            }
            int m = nums.length;
            int[][] dp = new int[m][2 * sum + 1];
            for (int i = 0;i < m;i ++) {
                for (int j = -sum; j <= sum; j++) {
                    dp[i][j + sum] = (int)Math.pow(10,6);
                }
            }
            dp[0][- nums[0] + sum] = 0;
            dp[0][nums[0] + sum] = 0;
            dp[0][- nums[0] + sum] ++;
            dp[0][nums[0] + sum] ++;
            for (int i = 1;i < m;i ++) {
                for (int j = - sum;j <= sum;j ++) {
                    if (dp[i - 1][j + sum] != (int)Math.pow(10,6)) {
                        if (dp[i][j - nums[i] + sum] == (int)Math.pow(10,6)) {
                            dp[i][j - nums[i] + sum] = 0;
                        }
                        if (dp[i][j + nums[i] + sum] == (int)Math.pow(10,6)) {
                            dp[i][j + nums[i] + sum] = 0;
                        }
                        //从dp[i - 1][j] 可以到达 dp[i][j - nums[i]] 和 dp[i][j + nums[i]]
                        dp[i][j - nums[i] + sum] = dp[i][j - nums[i] + sum] + dp[i - 1][j + sum];
                        dp[i][j + nums[i] + sum] = dp[i][j + nums[i] + sum] + dp[i - 1][j + sum];
                    }
                }
            }
            return dp[m - 1][S + sum] == (int)Math.pow(10,6) ? 0 : dp[m - 1][S + sum];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
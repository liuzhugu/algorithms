//输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划

package leetcode.editor.cn;
//Java：面试题42:连续子数组的最大和  动态规划 2020/04/22
public class LianXuZiShuZuDeZuiDaHeLcof{
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int m = nums.length,ans = Integer.MIN_VALUE;
            int[] dp = new int[m + 1];
            //初始化
            dp[0] = 0;
            for (int i = 1;i <= m;i ++) {
                dp[i] = Math.max(dp[i - 1] + nums[i - 1],nums[i - 1]);
            }
            for (int i = m;i >= 1;i --) {
                dp[i] = nums[i - 1];
                if (i < m && dp[i + 1] > 0) {
                    dp[i] = dp[i] + dp[i + 1];
                }
                if (dp[i - 1] > 0) {
                    ans = Math.max(ans,dp[i] + dp[i - 1]);
                } else {
                    ans = Math.max(ans,dp[i]);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
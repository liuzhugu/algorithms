//有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 
//left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 说明: 
//
// 
// 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。 
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 
// 
//
// 示例: 
//
// 输入: [3,1,5,8]
//输出: 167 
//解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// 
// Related Topics 分治算法 动态规划

package leetcode.editor.cn;
//Java：312:戳气球 分治  先戳两边再戳中间  增加哨兵作为边界  2020/05/12
public class BurstBalloons{
    public static void main(String[] args) {
        Solution solution = new BurstBalloons().new Solution();
        //TO TEST
        solution.maxCoins(new int[]{3,1,5,8});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划
        //我们先戳中间  再戳两边  最后剩下中间那个气球和两个边界没戳
        //因为我们一开始加上了两个虚拟边界  因此戳最后三个气球 其实相等于只戳最后那个
        public int maxCoins(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            //因为边界不戳  所以加上虚拟边界
            int n = nums.length + 2;
            int[] newNums = new int[n];
            for (int i = 1;i <= nums.length;i ++) {
                newNums[i] = nums[i - 1];
            }
            newNums[0] = newNums[n - 1] = 1;
            //dp table
            int[][] dp = new int[n][n];
            //i为左边界 j为右边界
            for (int i = n - 2;i >= 0;i --) {
                for (int j = i + 2;j < n;j ++) {
                    //在 i 和 j 之间选择气球来戳爆
                    for (int k = i + 1;k < j;k ++) {
                        dp[i][j] = Math.max(dp[i][j],
                                //第k个气球最后戳爆 然后两边的边界留给他  因此最后
                                //戳爆第k个气球获得的金币为newNums[i] * newNums[k] * newNums[j]
                                dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j]);
                    }
                }
            }
            return dp[0][n - 1];
        }

//        //回溯法 超时
//        public int maxCoins(int[] nums) {
//            if (nums == null || nums.length == 0) {
//                return 0;
//            }
//            //从每个气球开始做递归回溯
//            visit(nums,0);
//            return max;
//        }
//        private int max = Integer.MIN_VALUE;
//        private void visit(int[] nums,int coins) {
//            //找一个来戳破
//            for (int i = 0;i < nums.length;i ++) {
//                if (nums[i] == -1) continue;
//                //往左边找未戳破的
//                int left = i - 1;
//                while (left >= 0 && nums[left] == -1) {
//                    left --;
//                }
//                if (left < 0) {
//                    left = 1;
//                } else {
//                    left = nums[left];
//                }
//                //往右边找未戳破的
//                int right = i + 1;
//                while (right < nums.length && nums[right] == -1) {
//                    right ++;
//                }
//                if (right == nums.length) {
//                    right = 1;
//                } else {
//                    right = nums[right];
//                }
//                int sum = coins + left * nums[i] * right;
//                max = Math.max(max,sum);
//                //保存现状
//                int tmp = nums[i];
//                nums[i] = -1;
//                visit(nums,sum);
//                //恢复现场
//                nums[i] = tmp;
//            }
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
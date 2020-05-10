//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划

package leetcode.editor.cn;
//Java：309:最佳买卖股票时机含冷冻期 2020/05/09
public class BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
        //TO TEST
        solution.maxProfit(new int[]{1,2,3,0,2,3,5});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            //第一维为交易天数
            // 第二维为交易状态  0 买 1 卖 2 冻结
            // 第三维为买卖次数  要么为0要么为1  不能为2
            int[][][] dp = new int[n + 1][3][2];
            //第一天不能卖
            dp[0][1][0] = Integer.MIN_VALUE;
            //第一天不可能为冻结且买了
            dp[0][2][1] = Integer.MIN_VALUE;
            dp[0][0][1] = Integer.MIN_VALUE;
            //初始化 第一天没得卖  前两天没得冻结
            for (int i = 1;i <= n;i ++) {
                int price = prices[i - 1];
                //本来有六种状态   没有买了又买 卖了没冻结就买 没买就卖

                //这天想买的话 前一天必须冻结
                dp[i][0][1] = dp[i - 1][2][0] - price;
                //这天想卖的话 前一天必须是 买 或者 冻结且买了 了
                dp[i][1][0] = Math.max(dp[i - 1][0][1],dp[i - 1][2][1]) + price;
                //如果想 冻结且没买 的话   那么之前只能是 冻结且没买 或者 卖了
                dp[i][2][0] = Math.max(dp[i - 1][2][0],dp[i - 1][1][0]);
                //如果想 冻结且买了 的话   那么之前只能是 冻结且买了 或者 买了
                dp[i][2][1] = Math.max(dp[i - 1][2][1],dp[i - 1][0][1]);
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0;i < 3;i ++) {
                for (int j = 0;j < 2;j ++) {
                    max = Math.max(max,dp[n][i][j]);
                }
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
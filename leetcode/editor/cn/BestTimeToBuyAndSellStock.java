//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划

package leetcode.editor.cn;
//Java：121:买卖股票的最佳时机 2020/05/09
public class BestTimeToBuyAndSellStock{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        //TO TEST
        solution.maxProfit(new int[]{7,1,5,3,6,4});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            //三维  第一维天数
            // 第二维状态 0 买 1 卖 2无操作
            // 第三位买卖次数 0  1  2
            int n = prices.length;
            int[][][] dp = new int[n + 1][3][3];
            //初始化
            //没买不能卖
            dp[0][0][1] = Integer.MIN_VALUE;
            dp[0][2][1] = Integer.MIN_VALUE;
            //一开始不可能卖过的
            dp[0][1][2] = Integer.MIN_VALUE;
            dp[0][2][2] = Integer.MIN_VALUE;
            for (int i = 1;i <= n;i ++) {
                int price = prices[i - 1];
                //之前没买过
                dp[i][0][1] = dp[i - 1][2][0] - price;
                //想卖的话 那么前一天 买过 或者无操作但买过
                dp[i][1][2] = Math.max(dp[i - 1][0][1],dp[i - 1][2][1]) + price;
                //无操作的话 之前也必须无操作
                dp[i][2][0] = dp[i - 1][2][0];
                //无操作但买过的话  那么之前 必须买过 或者 无操作但买过
                dp[i][2][1] = Math.max(dp[i - 1][0][1],dp[i - 1][2][1]);
                //无操作 但卖过    那么之前 必须卖过  或者无操作但卖过
                dp[i][2][2] = Math.max(dp[i - 1][1][2],dp[i - 1][2][2]);

            }
            int max = Integer.MIN_VALUE;
            for (int i = 0;i < 3;i ++) {
                for (int j = 0;j < 3;j ++) {
                    max = Math.max(max,dp[n][i][j]);
                }
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
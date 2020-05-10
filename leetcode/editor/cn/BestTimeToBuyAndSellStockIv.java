//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [2,4,1], k = 2
//输出: 2
//解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
// 
//
// 示例 2: 
//
// 输入: [3,2,6,5,0,3], k = 2
//输出: 7
//解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。
// 
// Related Topics 动态规划

package leetcode.editor.cn;
//Java：188:买卖股票的最佳时机 IV 2020/05/10
public class BestTimeToBuyAndSellStockIv{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            //三维  第一维天数
            // 第二维买卖次数
            // 第三维当前状态   状态要么是持有  要么是没持有
            int n = prices.length;
            if (k > n / 2) {
                return maxProfit(prices);
            }
            int[][][] dp = new int[n + 1][k + 1][2];
            //大数
            int NUM = (int)Math.pow(10,6);
            //先买才能卖
            for (int i = 0;i <= k;i ++) {
                dp[0][i][1] = - NUM;
            }
            for (int i = 1;i <= n;i ++) {
                int price = prices[i - 1];
                for (int j = k;j >= 1;j --) {
                    //如果当前持有的话  那么之前已经交易那么多次数且持有了  或者之前交易了那么多次数且持有
                    dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j][1] + price);
                    //如果当前没持有的话  那么之前已经交易那么多次数且没持有了  或者之前交易少了一次且未持有
                    dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j - 1][0] - price);
                }
            }
            return dp[n][k][0];
        }
        //俩维
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            //俩维 第一维天数
            // 第二维状态 0 买 1 卖
            int n = prices.length;
            int[][] dp = new int[n + 1][2];
            //大数
            int NUM = (int)Math.pow(10,6);
            dp[0][1] = - NUM;
            for (int i = 1;i <= n;i ++) {
                int price = prices[i - 1];
                dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + price);
                dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - price);
            }
            return dp[n][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
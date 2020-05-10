//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [3,3,5,0,0,3,1,4]
//输出: 6
//解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1] 
//输出: 0 
//解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。 
// Related Topics 数组 动态规划

package leetcode.editor.cn;
//Java：123:买卖股票的最佳时机 III 2020/05/09
public class BestTimeToBuyAndSellStockIii{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
        //TO TEST
        solution.maxProfit(new int[]{1,4,2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][][] dp = new int[n + 1][3][2];
            for (int i = 1;i <= n;i ++) {
                int price = prices[i - 1];
                int NUM = (int)Math.pow(10,6);
                //BASE CASE
                dp[0][0][1] = - NUM;
                dp[0][1][1] = - NUM;
                dp[0][2][1] = - NUM;
                for (int j = 1;j < 3;j ++) {
                    //状态转移方程   只关注状态转移   而不关注中间操作
                    dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j][1] + price);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j - 1][0] - price);
                }
            }
            return dp[n][2][0];
        }
//        public int maxProfit(int[] prices) {
//            if (prices == null || prices.length == 0) {
//                return 0;
//            }
//            //三维  第一维天数
//            // 第二维状态 0 买 1 卖 无操作
//            // 第三位买卖次数 0 1 2
//            int n = prices.length;
//            int[][][] dp = new int[n + 1][3][5];
//            //大数
//            int NUM = (int)Math.pow(10,6);
//            //先买才能卖
//            dp[0][0][1] = - NUM;
//            dp[0][1][1] =  - NUM;
//            dp[0][0][2] =  - NUM;
//            dp[0][1][2] =  - NUM;
//            dp[0][2][1] =  - NUM;
//            dp[0][2][2] =  - NUM;
//            dp[0][2][3] =  - NUM;
//            dp[0][2][4] =  - NUM;
//
//            for (int i = 1;i <= n;i ++) {
//                int price = prices[i - 1];
//                //第一想买的话
//                //之前无操作
//                if (dp[i - 1][2][0] ==  - NUM) {
//                    dp[i][0][1] =  - price;
//                } else {
//                    dp[i][0][1] = dp[i - 1][2][0] - price;
//                }
//
//
//                //第二次想买的话
//                //之前无操作但买卖过一次
//                dp[i][0][2] = dp[i - 1][2][2];
//                //之前卖过一次
//                dp[i][0][2] = Math.max(dp[i][0][2],dp[i - 1][1][1]);
//                if (dp[i][0][2] !=  - NUM) {
//                    dp[i][0][2] = dp[i][0][2] - price;
//                }
//
//                //第一次想卖的话
//                //之前无操作但买过一次
//                dp[i][1][1] = dp[i - 1][2][1];
//                //之前买过
//                dp[i][1][1] = Math.max(dp[i][1][1],dp[i - 1][0][1]);
//                dp[i][1][1] = dp[i][1][1] + price;
//
//                //第二次想卖的话
//                //之前无操作但买过第二次
//                dp[i][1][2] = dp[i - 1][2][3];
//                //之前第二次买
//                dp[i][1][2] = Math.max(dp[i][1][2],dp[i - 1][0][2]);
//                dp[i][1][2] = dp[i][1][2] + price;
//
//                //无操作
//                dp[i][2][0] = dp[i - 1][2][0];
//                //无操作但买过一次 那么它之前是 无操作但买过一次 或 买过一次
//                dp[i][2][1] = Math.max(dp[i - 1][2][1],dp[i - 1][0][1]);
//                //无操作但买卖过一次 那么它之前是 无操作但买卖过一次 或 卖过一次
//                dp[i][2][2] = Math.max(dp[i - 1][2][2],dp[i - 1][1][1]);
//                //之前无操作但买过第二次
//                dp[i][2][3] = Math.max(dp[i - 1][2][3],dp[i - 1][0][2]);
//                //之前无操作但买卖过第二次
//                dp[i][2][4] = Math.max(dp[i - 1][2][4],dp[i - 1][1][2]);
//            }
//            int max = Integer.MIN_VALUE;
//            for (int i = 0;i < 3;i ++) {
//                for (int j = 0;j < 5;j ++) {
//                    max = Math.max(max,dp[n][i][j]);
//                }
//            }
//            return max;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
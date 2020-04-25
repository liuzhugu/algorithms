//硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007) 
//
// 示例1: 
//
// 
// 输入: n = 5
// 输出：2
// 解释: 有两种方式可以凑成总金额:
//5=5
//5=1+1+1+1+1
// 
//
// 示例2: 
//
// 
// 输入: n = 10
// 输出：4
// 解释: 有四种方式可以凑成总金额:
//10=10
//10=5+5
//10=5+1+1+1+1+1
//10=1+1+1+1+1+1+1+1+1+1
// 
//
// 说明： 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= n (总金额) <= 1000000 
// 
// Related Topics 动态规划

package leetcode.editor.cn;
//Java：面试题 08.11:硬币  动态规划 2020/04/23
public class CoinLcci{
    public static void main(String[] args) {
        Solution solution = new CoinLcci().new Solution();
        //TO TEST
        solution.waysToChange(1000000);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToChange(int n) {
            int[] dp = new int[n + 1];
            int[] coins = {1,5,10,25};

            //只选1分硬币
            for(int i = 0;i <= n;i ++)
                dp[i] = 1;


            //每次找考虑一种币值情况  最终的结果等于所有情况的叠加
            //不能一次考虑多种币值  否则会漏掉情况
            for (int i = 1;i < coins.length;i ++) {
                for (int j = 1;j <= n;j ++) {
                    if (j >= coins[i]) {
                        dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
                    }
                }
            }
            return dp[n];
        }

//        public int waysToChange(int n) {
//            int[] dp = new int[n + 1];
//            dp[0] = 0;
//            for (int i = 1;i <= n;i ++) {
//                dp[i] = dp[i - 1] + 1;
//                if (i >= 5) {
//                    dp[i] = (dp[i] + dp[i - 5] + 1) % 1000000007 ;
//                }
//                if (i >= 10) {
//                    dp[i] = (dp[i] + dp[i - 10] + 1) % 1000000007;
//                }
//                if (i >= 25) {
//                    dp[i] = (dp[i] + dp[i - 25] + 1) % 1000000007;
//                }
//            }
//            return dp[n];
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
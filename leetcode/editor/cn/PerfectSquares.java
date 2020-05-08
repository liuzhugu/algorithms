//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划

package leetcode.editor.cn;

import java.util.*;

//Java：279:完全平方数 2020/05/08
public class PerfectSquares{
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        //TO TEST
        solution.numSquares(123456);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            int maxSquare = (int)Math.sqrt(n) + 1;
            int[] squares = new int[maxSquare];
            for (int i = 1;i < maxSquare;i ++) {
                squares[i] = i * i;
            }
            //初始化
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1;i <= n;i ++) {
                for (int j = 1;j < maxSquare;j ++) {
                    if (i < squares[j]) {
                        break;
                    }
                    dp[i] = Math.min(dp[i],dp[i - squares[j]] + 1);
                }
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
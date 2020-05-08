//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;
//Java：91:解码方法 2020/05/07
public class DecodeWays{
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int m = s.length();
            int[] dp = new int[m + 1];
            dp[0] = 1;
            char[] c1 = s.toCharArray();
            for (int i = 1;i <= m;i ++) {
                int num = c1[i - 1] - '0';
                if (num > 0 && num < 10) {
                    dp[i] = dp[i - 1];
                }
                if (i > 1) {
                    num = num + 10 * (c1[i - 2] - '0');
                    if (num < 27 && num >= 10) {
                        dp[i] = dp[i] + dp[i - 2];
                    }
                }
            }
            return dp[m];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
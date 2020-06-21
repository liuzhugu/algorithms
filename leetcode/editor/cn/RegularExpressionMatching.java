//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
// Related Topics 字符串 动态规划 回溯算法

package leetcode.editor.cn;
//Java：10:正则表达式匹配
public class RegularExpressionMatching{
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            if ((s == null || s.length() == 0) &&  (p == null || p.length() == 0)) {
                return true;
            }
            int m = s.length(),n = p.length();
            char[] c1 = s.toCharArray(),c2 = p.toCharArray();
            boolean[][] dp = new boolean[m + 1][n + 1];
            //初始化
            dp[0][0] = true;
            //1.如果模式串为空  除非目标串也为空  否则不可能匹配
            //2.如果目标串为空  因为 * 如果取0个前字符  相当于把前一个字符消去  因此可以和空字符串匹配
            for (int i = 1;i <= n;i ++) {
                //p[j-1]为 * 可以把j-2和j-1处的字符删去，只有[0,j-3]都为true才可以
                //因此dp[j-2]也要为true，才可以说明前j个为true
                if(c2[i - 1] == '*' && dp[0][i - 2])
                    dp[0][i] = true;

            }
            //递推
            for (int i = 1;i <= m;i ++) {
                for (int j = 1;j <= n;j ++) {
                    //如果两边相应字符相同或者模式串对应为 . 那么匹配
                    if (c1[i - 1] == c2[j - 1] || c2[j - 1] == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    //出现 * 要追溯回之前
                    else if (c2[j - 1] == '*') {
                        if (j >= 2) {
                            // * 匹配 0 个前字符 相当于删掉c2[j - 1]和c2[j - 2](即 * 及 * 前面那个字符)
                            dp[i][j] = dp[i][j] || dp[i][j - 2];
                            // * 匹配 1 个前字符  相当于拿c2[j - 1]和c1[i - 1]比较
                            // 因此c1[i - 1]相对于的是在 * 号右边拷贝的c2[j - 2]
                            if (c1[i - 1] == c2[j - 2] || c2[j - 2] == '.') {
                                dp[i][j] = dp[i][j] || dp[i - 1][j];
                            }
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
            return dp[m][n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配
//是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。 
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
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
// 
// Related Topics 动态规划

package leetcode.editor.cn;
//Java：面试题19:正则表达式匹配 动态规划 2020/04/21
public class ZhengZeBiaoDaShiPiPeiLcof{
    public static void main(String[] args) {
        Solution solution = new ZhengZeBiaoDaShiPiPeiLcof().new Solution();
        //TO TEST
        System.out.println(solution.isMatch("aaba","ab*a*c*a"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            int m = s.length(),n = p.length();
            char[] c1 = s.toCharArray(),c2 = p.toCharArray();
            boolean[][] dp = new boolean[m + 1][n + 1];
            //初始化
            dp[0][0] = true;
            for (int j = 1;j <= n;j ++) {
                //p[j-1]为 * 可以把j-2和j-1处的字符删去，只有[0,j-3]都为true才可以
                //因此dp[j-2]也要为true，才可以说明前j个为true
                if(c2[j - 1] == '*' && dp[0][j - 2])
                    dp[0][j] = true;

            }
            //递推
            for (int i = 1;i <= m;i ++) {
                for (int j = 1;j <= n;j ++) {
                    //如果两边相应字符相同或者模式串对应为 ? 那么匹配
                    if (c1[i - 1] == c2[j - 1] || c2[j - 1] == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (c2[j - 1] == '*') {
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
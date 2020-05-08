//给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。 
//
// 下图是字符串 s1 = "great" 的一种可能的表示形式。 
//
//     great
//   /    \
//  gr    eat
// / \    /  \
//g   r  e   at
//           / \
//          a   t
// 
//
// 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。 
//
// 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。 
//
//     rgeat
//   /    \
//  rg    eat
// / \    /  \
//r   g  e   at
//           / \
//          a   t
// 
//
// 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。 
//
// 同样地，如果我们继续交换节点 "eat" 和 "at" 的子节点，将会产生另一个新的扰乱字符串 "rgtae" 。 
//
//     rgtae
//   /    \
//  rg    tae
// / \    /  \
//r   g  ta  e
//       / \
//      t   a
// 
//
// 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。 
//
// 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。 
//
// 示例 1: 
//
// 输入: s1 = "great", s2 = "rgeat"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s1 = "abcde", s2 = "caebd"
//输出: false 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;
//Java：87:扰乱字符串
public class ScrambleString{
    public static void main(String[] args) {
        Solution solution = new ScrambleString().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isScramble(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();
            if (m != n) {
                return false;
            }
            char[] c1 = s1.toCharArray(),c2 = s2.toCharArray();
            boolean[][][] dp = new boolean[m][m][m + 1];
            //处理单个字符清理
            for (int i = 0;i < m;i ++) {
                for (int j = 0;j < m;j ++) {
                    dp[i][j][1] = c1[i] == c2[j];
                }
            }
            //然后由单个字符情况扩展至两个直到全部长度

            //截取总长度
            for (int len = 2;len <= m;len ++) {
                //在S中的位置
                for (int i = 0;i <= m - len;i ++) {
                    //在T中的位置
                    for (int j = 0; j <= m - len; j++) {
                        //截断的长度 S在该处被截断为S1和S2  T被截断为T1和T2
                        for (int k = 1;k < len;k ++) {
                            //让S1对应T1 S2对应T2
                            if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                                dp[i][j][len] = true;
                                break;
                            }
                            //让S1对应T2 S2对应T1
                            if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                                dp[i][j][len] = true;
                                break;
                            }
                        }
                    }
                }
            }
            //题目要求的是从各自起始位置截取m长度的结果
            return dp[0][0][m];
        }

        //两个字符串  至少俩维   截取不同长度 又需一维  因此三维
//        public boolean isScramble(String s1, String s2) {
//            if (s1.length() != s2.length()) {
//                return false;
//            }
//            int m = s1.length();
//            char[] c1 = s1.toCharArray(),c2 = s2.toCharArray();
//            boolean[][][] dp = new boolean[m][m][m + 1];
//            //单个字符的情况
//            for (int i = 0;i < m;i ++) {
//                for (int j = 0;j < m;j ++) {
//                    //因为只看一个字符  所以相等就行
//                    dp[i][j][1] = c1[i] == c2[j];
//                }
//            }
//
//            for (int len = 2;len <= m;len ++) {
//                //在S中的起始位置
//                for (int i = 0;i <= m - len;i ++) {
//                    //在T中的起始位置
//                    for (int j = 0;j <= m - len;j ++) {
//                        //截取长度
//                        for (int k = 1;k < len;k ++) {
//                            // S1 -> T1  S2 -> T2
//                            if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
//                                dp[i][j][len] = true;
//                                break;
//                            }
//                            //S1 -> T2  S2 -> T1
//                            if (dp[i][len - k + j][k] && dp[i + k][j][len - k]) {
//                                dp[i][j][len] = true;
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//            return dp[0][0][m];
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
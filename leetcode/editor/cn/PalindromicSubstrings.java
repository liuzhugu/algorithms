//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;
//Java：647:回文子串 2020/05/14
public class PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        //TO TEST
        solution.countSubstrings("aaa");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //马拉车法
        public int countSubstrings(String S) {
            char[] A = new char[2 * S.length() + 3];
            A[0] = '@';
            A[1] = '#';
            A[A.length - 1] = '$';
            int t = 2;
            for (char c: S.toCharArray()) {
                A[t++] = c;
                A[t++] = '#';
            }

            int[] Z = new int[A.length];

            int center = 0, mx = 0;
            for (int i = 1; i < Z.length - 1; ++i) {
                if (i < mx)
                    Z[i] = Math.min(mx - i, Z[2 * center - i]);
                while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                    Z[i]++;
                if (i + Z[i] > mx) {
                    center = i;
                    mx = i + Z[i];
                }
            }
            int ans = 0;
            for (int v: Z) ans += (v + 1) / 2;
            return ans;
        }
//        public int countSubstrings(String S) {
//            //每个位置作为回文字符串中心 或 左边界来穷举
//            int m = S.length();
//            char[] chars = S.toCharArray();
//            int ans = 0;
//            for (int center = 0;center < 2 * m;center ++) {
//                int left = center / 2,right = (center + 1) / 2;
//                while (left >= 0 && right < m) {
//                    if (chars[left] == chars[right]) {
//                        ans ++;
//                        left --;
//                        right ++;
//                    } else {
//                        break;
//                    }
//                }
//            }
//            return ans;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
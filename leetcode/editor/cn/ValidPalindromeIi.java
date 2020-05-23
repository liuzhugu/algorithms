//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串

package leetcode.editor.cn;
//Java：680:验证回文字符串 Ⅱ
public class ValidPalindromeIi{
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
        //TO TEST
        solution.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //双指针
        public boolean validPalindrome(String s) {
            int left = 0,right = s.length() - 1;
            boolean hasSkip = false;
            char[] chars = s.toCharArray();
            while (left < right) {
                if (chars[left] == chars[right]) {
                    left ++;
                    right --;
                    continue;
                } else {
                    boolean flag1 = true, flag2 = true;
                    for (int i = left, j = right - 1; i < j; i++, j--) {
                        char c3 = s.charAt(i), c4 = s.charAt(j);
                        if (c3 != c4) {
                            flag1 = false;
                            break;
                        }
                    }
                    for (int i = left + 1, j = right; i < j; i++, j--) {
                        char c3 = s.charAt(i), c4 = s.charAt(j);
                        if (c3 != c4) {
                            flag2 = false;
                            break;
                        }
                    }
                    return flag1 || flag2;
                }
            }
            return true;
        }

        //超时
//        public boolean validPalindrome(String s) {
//            for (int i = 0;i < s.length();i ++) {
//                boolean ans = false;
//                if (i == 0) {
//                    ans = judge(s.substring(1,s.length()));
//                } else if (i == s.length() - 1) {
//                    ans = judge(s.substring(0,s.length() - 1));
//                } else {
//                    ans = judge(s.substring(0,i) + s.substring(i + 1,s.length()));
//                }
//                if (ans) {
//                    return ans;
//                }
//            }
//            return false;
//        }
//        private boolean judge(String s) {
//            int left = 0,right = s.length() - 1;
//            while (left < right) {
//                if (s.charAt(left) != s.charAt(right)) {
//                    return false;
//                }
//                left ++;
//                right --;
//            }
//            return true;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
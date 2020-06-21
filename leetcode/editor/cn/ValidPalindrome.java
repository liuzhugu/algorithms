//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "bA man, a plan,!!! a canal: Panamab"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串

package leetcode.editor.cn;
//Java：125:验证回文串 2020/05/18
public class ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        //TO TEST
        solution.isPalindrome("A man, a plan, a canal: Panama");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.length() == 0){
                return true;
            }
            //去掉多余字符
            int pre = 0,next = 0,m = s.length();
            char[] chars = s.toCharArray();
            while (next != m) {
                if (valid(chars[next])) {
                    //大写转换为小写
                    if (chars[next] - 'A' >= 0 && chars[next] - 'A' < 26) {
                        chars[next] = (char) (chars[next] - 'A' + 'a');
                    }
                    chars[pre] = chars[next];
                    pre ++;
                }
                next ++;
            }
            s = new String(chars);
            s = s.substring(0,pre);
            if (s == null || s.length() == 0){
                return true;
            }
            int left = (s.length() - 1) / 2,right = (s.length()) / 2;
            chars = s.toCharArray();
            while (left >= 0 && right < s.length() && chars[left] == chars[right]) {
                left --;
                right ++;
            }
            return left < 0;
        }
        private boolean valid(char c) {
            if (c - '0' >= 0 && c - '0' <= 9) {
                return true;
            }
            if (c - 'a' >= 0 && c - 'a' < 26) {
                return true;
            }
            if (c - 'A' >= 0 && c - 'A' < 26) {
                return true;
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
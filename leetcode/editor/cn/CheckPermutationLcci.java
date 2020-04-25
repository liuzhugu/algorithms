//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
// Related Topics 数组 字符串

package leetcode.editor.cn;
//Java：面试题 01.02:判定是否互为字符重排 2020/04/23
public class CheckPermutationLcci{
    public static void main(String[] args) {
        Solution solution = new CheckPermutationLcci().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1 == null && s2 == null) {
                return true;
            }
            if (s1 == null || s2 == null) {
                return false;
            }
            int[] mark1 = new int[26];
            int[] mark2 = new int[26];
            if (s1.length() != s2.length()) {
                return false;
            }
            for (char c : s1.toCharArray()) {
                mark1[c - 'a'] ++;
            }
            for (char c : s2.toCharArray()) {
                mark2[c - 'a'] ++;
            }
            for (int i = 0;i < 26;i ++) {
                if (mark1[i] != mark2[i]) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
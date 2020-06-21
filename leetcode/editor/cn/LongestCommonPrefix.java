//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

package leetcode.editor.cn;
//Java：14:最长公共前缀 2020/06/15
public class LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String common = strs[0];
            for (int i = 1;i < strs.length;i ++) {
                if (common.length() == 0) {
                    break;
                }
                //找出前缀
                int index = 0;
                while (index < common.length() && index < strs[i].length()) {
                    if (common.charAt(index) != strs[i].charAt(index)) {
                        break;
                    }
                    index ++;
                }
                common = common.substring(0,index);
            }
            return common;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
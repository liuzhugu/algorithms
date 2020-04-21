//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//

package leetcode.editor.cn;
//Java：面试题05:替换空格 2020/04/21
public class TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = s.toCharArray();
            for (int i = 0;i < chars.length;i ++) {
                if (chars[i] == ' ') {
                    stringBuilder.append("%20");
                } else {
                    stringBuilder.append(chars[i]);
                }
            }
            return stringBuilder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
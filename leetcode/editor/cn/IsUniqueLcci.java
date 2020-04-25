//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 输入: s = "abc"
//输出: true
// 
//
// 限制： 
// 
// 0 <= len(s) <= 100 
// 如果你不使用额外的数据结构，会很加分。 
// 
// Related Topics 数组

package leetcode.editor.cn;
//Java：面试题 01.01:判定字符是否唯一 2020/04/23
public class IsUniqueLcci{
    public static void main(String[] args) {
        Solution solution = new IsUniqueLcci().new Solution();
        //TO TEST
        solution.isUnique("leetcode");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUnique(String astr) {
            //位运算  用一个书代替bool数组
            int mark = 0;
            for (char c : astr.toCharArray()) {
                int movBit = 1 << c - 'a';
                if ((mark & movBit) != 0) {
                    return false;
                } else {
                    mark = mark | movBit;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
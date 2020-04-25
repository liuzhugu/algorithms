//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。 
//
// 示例1: 
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
// 
//
// 示例2: 
//
//  输入：s1 = "aa", "aba"
// 输出：False
// 
//
// 
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 100000]范围内。 
// 
//
// 说明: 
//
// 
// 你能只调用一次检查子串的方法吗？ 
// 
// Related Topics 字符串

package leetcode.editor.cn;
//Java：面试题 01.09:字符串轮转 2020/04/24
public class StringRotationLcci{
    public static void main(String[] args) {
        Solution solution = new StringRotationLcci().new Solution();
        //TO TEST
        solution.isFlipedString("waterbottle","elttobretaw");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            //先找到旋转的位置
            int first = 0,second = 0;
            while (true) {
                while (second < s2.length() && s1.charAt(first) != s2.charAt(second)) {
                    second ++;
                }
                //找不到相同的
                if (second == s2.length()) {
                    return false;
                }
                //保存此时相等的位置 如果之后比较失败  从这里的下一步开始继续
                int preFirst = first ++;
                int preSecond = second ++;
                //开始比较
                while (first < s1.length() && second < s2.length()) {
                    if (s1.charAt(first) != s2.charAt(second)) {
                        break;
                    }
                    first ++;
                    second ++;
                }
                if (second == s2.length()) {
                    //比较另外一部分
                    second = 0;
                    while (first < s1.length() && second < s2.length()) {
                        if (s1.charAt(first) != s2.charAt(second)) {
                            break;
                        }
                        first ++;
                        second ++;
                    }
                    if (first == s1.length()) {
                        return true;
                    }
                    //失败  从头开始比较
                    first = preFirst;
                    second = preSecond;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;
//Java：面试题 01.05:一次编辑  2020/04/23
public class OneAwayLcci{
    public static void main(String[] args) {
        Solution solution = new OneAwayLcci().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean oneEditAway(String first, String second) {
            if (first == null && second == null) {
                return true;
            }
            if (first.length() < second.length()) {
                String tmp = second;
                second = first;
                first = tmp;
            }
            //长度不符合
            if (first.length() - second.length() > 1) {
                return false;
            }
            boolean skip = false;
            int index1 = 0,index2 = 0;
            while (index1 < first.length() && index2 < second.length()) {
                if (first.charAt(index1) == second.charAt(index2)) {
                    index1 ++;
                    index2 ++;
                    continue;
                }
                //不匹配
                if (! skip) {
                    //判断是应该增 删还是改

                    //改
                    if (first.length() == second.length()) {
                        skip = true;
                        index1 ++;
                        index2 ++;
                    } else {
                        //删掉first对应字符和在second增加相同字符效果一样
                        skip = true;
                        index1 ++;
                    }
                } else {
                    //不匹配又不能改了
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
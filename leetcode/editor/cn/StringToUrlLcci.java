//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，
//请使用字符数组实现，以便直接在数组上操作。） 
//
// 示例1: 
//
//  输入："Mr John Smith    ", 13
// 输出："Mr%20John%20Smith"
// 
//
// 示例2: 
//
//  输入："               ", 5
// 输出："%20%20%20%20%20"
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 500000]范围内。 
// 
// Related Topics 字符串

package leetcode.editor.cn;
//Java：面试题 01.03:URL化  2020/04/23
public class StringToUrlLcci{
    public static void main(String[] args) {
        Solution solution = new StringToUrlLcci().new Solution();
        //TO TEST
        solution.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ",13);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpaces(String S, int length) {
            //因为要原地 那么覆盖掉
            char[] chars = S.toCharArray();
            int count = 0;
            for (int i = 0;i < length;i ++) {
                if (chars[i] == ' ') {
                    count ++;
                }
            }
            int pre = length - 1,next = pre + count * 2;
            char[] ans = new char[next + 1];
            while (pre >= 0) {
                if (chars[pre] == ' ') {
                    pre --;
                    //补上%20
                    ans[next --] = '0';
                    ans[next --] = '2';
                    ans[next --] = '%';
                } else {
                    ans[next --] = chars[pre --];
                }
            }
            return String.valueOf(ans);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.*;

//Java：面试题38:字符串的排列
public class ZiFuChuanDePaiLieLcof{
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String s) {
            if (s == null || s.length() == 0) {
                return null;
            }
            chars = s.toCharArray();
            dfs(0);
            return res.toArray(new String[res.size()]);
        }
        char[] chars;
        List<String> res = new LinkedList<>();
        private void dfs (int index) {
            //所有位置已经固定
            if (index == chars.length - 1) {
                res.add(String.valueOf(chars));
                return;
            }
            //和后面的交换位置  因为前面已经固定
            //每个位置 所有字符只能出现一次
            Set<Character> set = new HashSet<>();
            for (int j = index;j < chars.length;j ++) {
                //已存在
                if (set.contains(chars[j])) {
                    continue;
                }
                set.add(chars[j]);
                swap(index,j);
                //固定index + 1位置
                dfs(index + 1);
                //换回来 尝试其他可能
                swap(j,index);
            }
        }
        private void swap(int i,int j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
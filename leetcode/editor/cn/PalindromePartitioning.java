//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：131:分割回文串 2020/05/18
public class PalindromePartitioning{
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        //TO TEST
        solution.partition("aab");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            if (s == null || s.length() == 0) {
                ans.add(new ArrayList<>());
                return ans;
            }
            int m = s.length();
            char[] chars = s.toCharArray();
            dp = new boolean[m][m];
            //判断字符串是否为回文  每个字符作为回文字符串中心或者两边
            for (int i = 0;i < 2 * m - 1;i ++) {
                int left = i / 2,right = (i + 1) / 2;
                while (left >= 0 && right < m && chars[left] == chars[right]) {
                    dp[left][right] = true;
                    left --;
                    right ++;
                }
            }
            //切分字符串
            for (int i = 0;i < m;i ++) {
                if (dp[0][i]) {
                    List<String> list = new ArrayList<>();
                    list.add(s.substring(0,i + 1));
                    //截取后面的长度
                    visit(s,list,i + 1,m);
                }
            }
            return ans;
        }
        private List<List<String>> ans = new ArrayList<>();
        boolean[][] dp;
        private void visit(String s,List<String> list,int start,int length) {
            if (start == length) {
                ans.add(new ArrayList<>(list));
                return;
            }
            for (int i = start;i < length;i ++) {
                if (dp[start][i]) {
                    list.add(s.substring(start,i + 1));
                    visit(s,list,i + 1,length);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
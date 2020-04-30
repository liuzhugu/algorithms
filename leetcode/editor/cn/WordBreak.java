//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：139:单词拆分 2020/04/29
public class WordBreak{
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        //TO TEST
        List<String> list = new ArrayList<>();
        list.add("dog");
        list.add("s");
        list.add("gs");
        solution.wordBreak("dogs",list);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
            Set<String> set = new HashSet<>();
            Set<Character> headChar = new HashSet<>();
            for (String str : wordDict) {
                int len = str.length();
                min = Math.min(min,len);
                max = Math.max(max,len);
                headChar.add(str.charAt(0));
                set.add(str);
            }
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = min;i <= s.length();i ++) {
                //试探不同长度
                for (int j = min;i >= j && j <= max;j ++) {
                    //首字符在字典里
                    if (headChar.contains(s.charAt(i - j))) {
                        String str = s.substring(i - j,i);
                        if (set.contains(str)) {
                            //只要有一种情况就可以
                            dp[i] = dp[i - j] | dp[i];
                        }
                    }
                }
            }
            return dp[s.length()];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
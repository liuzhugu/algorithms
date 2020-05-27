//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。 
//
// 说明： 
//
// 
// 分隔时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// 示例 2： 
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
// 
// Related Topics 动态规划 回溯算法

package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.*;

//Java：140:单词拆分 II 2020/05/24
public class WordBreakIi{
    public static void main(String[] args) {
        Solution solution = new WordBreakIi().new Solution();
        //TO TEST
        String[] strings = new String[]{"cat","cats","and","sand","dog"};
        List<String> wordDict = Arrays.asList(strings);
        solution.wordBreak("catsanddog",wordDict);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0 || wordDict.isEmpty()) {
                return new ArrayList<>();
            }
            Set<String> strings = new HashSet<>(wordDict);
            for (String str : wordDict) {
                lengths.add(str.length());
            }
            return visit(s,strings);
        }
        Set<Integer> lengths = new HashSet<>();
        Map<String,List<String>> cache = new HashMap<>();
        private List<String> visit(String s,Set<String> wordDict) {
            if (cache.containsKey(s)) {
                return cache.get(s);
            }
            List<String> list = new ArrayList<>();
            //递归终止条件
            if (s.length() == 0) {
                list.add("");
                return list;
            }
            for (int length : lengths) {
                //过长
                if (length > s.length()) {
                    break;
                }
                String str = s.substring(0,length);
                if (wordDict.contains(str)) {
                    List<String> preList = visit(s.substring(length),wordDict);
                    for (String tmp : preList) {
                        list.add(str + (tmp.isEmpty() ? "" : " " + tmp));
                    }
                }
            }
            cache.put(s,list);
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
// 
// Related Topics 哈希表 双指针 字符串

package leetcode.editor.cn;

import java.util.*;

//Java：30:串联所有单词的子串 2020/04/26
public class SubstringWithConcatenationOfAllWords{
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        //TO TEST
        solution.findSubstring("barfoothefoobarman",new String[]{"foo","bar"});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            if (s == null || s.length() == 0 || words == null || words.length == 0) {
                return new ArrayList<>();
            }
            List<Integer> ans = new ArrayList<>();
            Map<String,Integer> map = new HashMap<>();
            //所有单词首字符
            Set<Character> set = new HashSet<>();
            for (String str : words) {
                set.add(str.charAt(0));
                map.put(str,map.getOrDefault(str,0) + 1);
            }
            int m = words[0].length();
            for (int i = 0;i < s.length();i ++) {
                //首字符就不合适
                if (! set.contains(s.charAt(i))) {
                    continue;
                }
                //剩余长度是否足够找子串
                if (s.length() - i < m * words.length) {
                    break;
                }
                int count = words.length;
                Map<String,Integer> tmp = new HashMap<>(map);
                //开始找
                while (count > 0) {
                    String str = s.substring(i + (words.length - count) * m,i + (words.length - count + 1) * m);
                    //不匹配
                    if (tmp.get(str) == null || tmp.get(str) == 0) {
                        break;
                    } else {
                        tmp.put(str,tmp.get(str) - 1);
                    }
                    count --;
                }
                if (count == 0) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
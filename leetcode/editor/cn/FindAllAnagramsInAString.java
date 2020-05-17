//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：438:找到字符串中所有字母异位词 2020/05/16
public class FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        //TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //滑动窗口
        public List<Integer> findAnagrams(String s, String p) {
            if (s == null || s.length() == 0 || s.length() < p.length()) {
                return new ArrayList<>();
            }
            Map<Character,Integer> target = new HashMap<>();
            for (char c : p.toCharArray()) {
                target.put(c,target.getOrDefault(c,0) + 1);
            }
            int size = target.size();
            int m = s.length(),n = p.length();
            char[] c1 = s.toCharArray(),c2 = p.toCharArray();
            //初始化窗口
            int count = 0;
            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0;i < n;i ++) {
                map.put(c1[i],map.getOrDefault(c1[i],0) + 1);
                if (map.get(c1[i]).equals(target.get(c1[i]))) {
                    count ++;
                }
            }
            List<Integer> ans = new ArrayList<>();
            if (count == size) {
                ans.add(0);
            }
            for (int i = n;i < m;i ++) {
                char c = c1[i];
                map.put(c,map.getOrDefault(c,0) + 1);
                //入
                if (map.get(c).equals(target.get(c))) {
                    count ++;
                }
                c = c1[i - n];
                //出
                if (map.get(c).equals(target.get(c))) {
                    count --;
                }
                map.put(c,map.get(c) - 1);
                //满足条件
                if (count == size) {
                    ans.add(i - n + 1);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package leetcode.editor.cn;

import java.util.*;

//Java：76:最小覆盖子串  滑动窗口 2020/04/27
public class MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        //TO TEST
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String t = input.nextLine();
        solution.minWindow(s,t);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            String result = "";
            if (s == null || s.length() == 0 || s.length() < t.length()) {
                return result;
            }
            //初始化  从头找出包含t的字符串作为窗口
            Map<Character, Integer> mapT = new HashMap<>();
            for (char c : t.toCharArray()) {
                mapT.put(c, mapT.getOrDefault(c, 0) + 1);
            }
            Map<Character, Integer> mapS = new HashMap<>();
            int left = 0;
            int right = 0;
            int match = 0;
            int minLen = Integer.MAX_VALUE;
            for (; right < s.length(); right++) {
                Character rightChar = s.charAt(right);
                if (mapT.containsKey(rightChar)) {
                    mapS.put(rightChar, mapS.getOrDefault(rightChar, 0) + 1);
                    if (mapT.get(rightChar).equals(mapS.get(rightChar))) {
                        match++;
                    }
                }
                //满足条件  开始滑动窗口
                while (match == mapT.keySet().size()) {
                    if ((right - left + 1) < minLen) {
                        minLen = right - left + 1;
                        result = s.substring(left,right + 1);
                    }
                    Character leftChar = s.charAt(left);
                    //不能再小了 小了就无法满足条件了
                    if (mapT.containsKey(leftChar)) {
                        if (mapS.get(leftChar).equals(mapT.get(leftChar))) {
                            match --;
                        }
                        mapS.put(leftChar,mapS.get(leftChar) - 1);
                    }
                    left ++;
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
//给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "eleetminicoworoep"
//输出：13
//解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcodeisgreat"
//输出：5
//解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
// 
//
// 示例 3： 
//
// 
//输入：s = "bcbcbc"
//输出：6
//解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 x 10^5 
// s 只包含小写英文字母。 
// 
// Related Topics 字符串

package leetcode.editor.cn;

import java.util.*;

//Java：1371:每个元音包含偶数次的最长子字符串
public class FindTheLongestSubstringContainingVowelsInEvenCounts{
    public static void main(String[] args) {
        Solution solution = new FindTheLongestSubstringContainingVowelsInEvenCounts().new Solution();
        //TO TEST
        solution.findTheLongestSubstring("eleetminicoworoep");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTheLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            Set<Character> set = new HashSet<Character>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            Map<Character,Integer> map = new HashMap<>();
            map.put('a',0);
            map.put('e',1);
            map.put('i',2);
            map.put('o',3);
            map.put('u',4);
            int m = s.length();
            int[][] pre = new int[m + 1][5];
            for (int i = 1;i <= m;i ++) {
                pre[i] = pre[i - 1].clone();
                char c = s.charAt(i - 1);
                if (set.contains(c)) {
                    pre[i][map.get(c)] ++;
                }
            }
            int size = 0;
            while (size < s.length()) {
                for (int i = 0;i <= size & i <= m - size;i ++) {
                    int[] head = pre[i];
                    int[] tail = pre[m - size + i];
                    boolean ans = true;
                    for (int j = 0;j < 5;j ++) {
                        if ((tail[j] - head[j]) % 2 != 0) {
                            ans = false;
                        }
                    }
                    if (ans) {
                        return m - size;
                    }
                }
                size ++;
            }
            return 0;
        }
        //滑动窗口  超时
//        public int findTheLongestSubstring(String s) {
//            int size = 0;
//            while (size < s.length()) {
//                for (int i = 0;i <= size;i ++) {
//                    if (check(s.substring(i,s.length() - size + i))) {
//                        return s.length() - size;
//                    }
//                }
//                size ++;
//            }
//            return 0;
//        }
//        private boolean check(String s) {
//            Set<Character> set = new HashSet<Character>();
//            set.add('a');
//            set.add('e');
//            set.add('i');
//            set.add('o');
//            set.add('u');
//            Map<Character,Integer> map = new HashMap<>();
//            map.put('a',0);
//            map.put('e',0);
//            map.put('o',0);
//            map.put('i',0);
//            map.put('u',0);
//            for (char c : s.toCharArray()) {
//                if (set.contains(c)) {
//                    map.put(c,map.get(c) + 1);
//                }
//            }
//            if (map.get('a') % 2 != 0) {
//                return false;
//            }
//            if (map.get('e') % 2 != 0) {
//                return false;
//            }
//            if (map.get('i') % 2 != 0) {
//                return false;
//            }
//            if (map.get('o') % 2 != 0) {
//                return false;
//            }
//            if (map.get('u') % 2 != 0) {
//                return false;
//            }
//            return true;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
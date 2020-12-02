//找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。 
//
// 示例 1: 
//
// 
//输入:
//s = "aaabb", k = 3
//
//输出:
//3
//
//最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2: 
//
// 
//输入:
//s = "ababbc", k = 2
//
//输出:
//5
//
//最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
// 
//

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：395:至少有K个重复字符的最长子串   2020/06/24
public class LongestSubstringWithAtLeastKRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        //TO TEST
        solution.longestSubstring("aaabb",3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubstring(String s, int k) {
            int len = s.length();
            if (len == 0 || k > len) return 0;
            if (k < 2) return len;

            return count(s.toCharArray(), k, 0, len - 1);

        }
        private int count(char[] chars,int k,int left,int right) {
            //长度过小
            if (right - left + 1 < k) {
                return 0;
            }
            int[] count = new int[26];  //  26个字母
            //  统计出现频次
            for (int i = left; i <= right; ++i) {
                count[chars[i] - 'a'] ++;
            }
            //如果左边出现次数小于k  那么该字符不应该出现在最终字符串中  去掉
            while (right - left + 1 >= k && count[chars[left] - 'a'] < k) {
                left ++;
            }
            //右边同理
            while (right - left + 1 >= k && count[chars[right] - 'a'] < k) {
                right --;
            }
            //两边都大于k  那么校验中间的字符  剩下的字符串中 出现次数小于k的都应该去掉
            for (int i = left; i <= right; ++i) {
                //如果还有其他小于k的  那么它在后续的遍历中还会被去掉  因此从遇到的第一个就可以其开始了
                if (count[chars[i] - 'a'] < k) {
                    return Math.max(count(chars,k,left,i - 1),
                            count(chars,k,i + 1,right));
                }
            }
            return right - left + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
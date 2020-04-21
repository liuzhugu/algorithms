//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：面试题48:最长不含重复字符的子字符串 滑动窗口 2020/04/21
public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        //TO TEST
        solution.lengthOfLongestSubstring("pwwkew");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int count = 0,sum = 0,preNoRepeat = 0,ans = 0;
            Map<Character,Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            for (int i = 0;i < chars.length;i ++) {
                //计数
                map.put(chars[i],map.getOrDefault(chars[i],0) + 1);
                sum ++;
                if (map.get(chars[i]) == 1) {
                    count ++;
                } else {
                    //左边有元素要出窗口
                    while (preNoRepeat < i && map.get(chars[i]) > 1) {
                        map.put(chars[preNoRepeat],map.getOrDefault(chars[preNoRepeat],0) - 1);
                        if (map.get(chars[preNoRepeat]) == 0) {
                            count --;
                        }
                        sum --;
                        preNoRepeat ++;
                    }
                }
                //此时元素都不重复
                if (sum == count) {
                    ans = Math.max(ans,i - preNoRepeat + 1);
                    //因为求最多  因此往左边滑动窗口
                    for (int j = preNoRepeat - 1;j >= 0;j --) {
                        //已有 不能滑动 否则重复
                        if (map.get(chars[j]) == 1) {
                            break;
                        }
                        ans = Math.max(ans,i - j + 1);
                        map.put(chars[j],map.get(chars[j]) + 1);
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
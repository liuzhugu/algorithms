//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 哈希表 字符串

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：面试题 01.04:回文排列   2020/04/23
public class PalindromePermutationLcci{
    public static void main(String[] args) {
        Solution solution = new PalindromePermutationLcci().new Solution();
        //TO TEST
        System.out.println(solution.canPermutePalindrome("aaccddf"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPermutePalindrome(String s) {
            Map<Character,Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c,map.getOrDefault(c,0) + 1);
            }
            //回文排列只能有一个字符出现字数为单数
            boolean exit = false;
            for (int value : map.values()) {
                if (value % 2 == 1) {
                    if (exit) {
                        return false;
                    } else {
                        exit = true;
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
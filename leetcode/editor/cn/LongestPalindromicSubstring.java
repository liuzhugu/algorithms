//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;
//Java：5:最长回文子串
public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if(s.length() == 0 || s == null){
                return "";
            }
            if(s.indexOf('\"') > -1){
                s = s.substring(3,s.length() - 3);
            }
            if(s.length() == 1){
                return s;
            }
            char[] chars = s.toCharArray();
            if(s.length() == 2){
                if(chars[0] == chars[1]){
                    return s;
                }else{
                    return chars[0] + "";
                }
            }
            int maxLength = 0;
            String result = "";
            for(int i = 1;i < chars.length - 1;i ++){
                int left = 0,right = 0;
                //像两边试探 如果 两边字符相等  扩大范围
                if(chars[i + 1] == chars[i] && chars[i] == chars[i - 1]){
                    right = i + 1;
                    left = i - 1;
                    while(chars[left] == chars[right]){
                        if((right - left + 1) > maxLength){
                            maxLength = right - left + 1;
                            result = s.substring(left,right + 1);
                        }
                        left --;
                        right ++;
                        if(left < 0 || right > s.length() - 1){
                            break;
                        }
                    }
                }
                //往左边试探
                if(chars[i] == chars[i-1]){
                    right = i;
                    left = i - 1;
                    while(chars[left] == chars[right]){
                        if((right - left + 1) > maxLength){
                            maxLength = right - left + 1;
                            result = s.substring(left,right + 1);
                        }
                        left --;
                        right ++;
                        if(left < 0|| right > s.length() - 1){
                            break;
                        }
                    }
                }
                //往右边试探
                if(chars[i + 1] == chars[i]){
                    left = i;
                    right = i+1;
                    while(chars[left] == chars[right]){
                        if((right - left + 1) > maxLength){
                            maxLength = right - left + 1;
                            result = s.substring(left,right + 1);
                        }
                        left --;
                        right ++;
                        if(left < 0 || right > s.length() - 1){
                            break;
                        }
                    }
                }
                if(left == 0 && right == 0){
                    left = right = i;
                    while(chars[left] == chars[right]){
                        if((right - left + 1) > maxLength){
                            maxLength = right - left + 1;
                            result = s.substring(left,right + 1);
                        }
                        left --;
                        right ++;
                        if(left < 0 || right > s.length() - 1){
                            break;
                        }
                    }
                }

            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
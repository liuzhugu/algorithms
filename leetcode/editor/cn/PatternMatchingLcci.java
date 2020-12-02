//你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatg
//o"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相
//同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。 
// 示例 1： 
// 输入： pattern = "abba", value = "dogcatcatdog"
//输出： true
// 
// 示例 2： 
// 输入： pattern = "abba", value = "dogcatcatfish"
//输出： false
// 
// 示例 3： 
// 输入： pattern = "aaaa", value = "dogcatcatdog"
//输出： false
// 
// 示例 4： 
// 输入： pattern = "abba", value = "dogdogdogdog"
//输出： true
//解释： "a"="dogdog",b=""，反之也符合规则
// 
// 提示： 
// 
// 0 <= len(pattern) <= 1000 
// 0 <= len(value) <= 1000 
// 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。 
// 
// Related Topics 字符串

package leetcode.editor.cn;
//Java：面试题 16.18:模式匹配
public class PatternMatchingLcci{
    public static void main(String[] args) {
        Solution solution = new PatternMatchingLcci().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean patternMatching(String pattern, String value) {
            if (pattern.equals("a") || pattern.equals("b")) {
                return true;
            }
            if (pattern.length() == 0) {
                return value.length() == 0;
            }
            if (value.length() == 0) {
                boolean aExist = false;
                boolean bExist = false;
                for (char c : pattern.toCharArray()) {
                    if (c == 'a') {
                        aExist = true;
                    } else {
                        bExist = true;
                    }
                }
                //两种皆存在  那么不匹配
                if (aExist && bExist) {
                    return false;
                } else {
                    return true;
                }
            }
            int aCount = 0;
            int bCount = 0;
            for (char c : pattern.toCharArray()) {
                if (c == 'a') {
                    aCount ++;
                } else {
                    bCount ++;
                }
            }
            //只有一种
            if (aCount * bCount == 0) {
                int count = aCount == 0 ? bCount : aCount;
                if (value.length() % count != 0) {
                    return false;
                }
                int index = 0,len = value.length() / count;
                String str = value.substring(0,len);
                while (index < value.length()) {
                    if (! str.equals(value.substring(index,len))) {
                        return false;
                    }
                    str = value.substring(index,len);
                    index = index + len;
                }
                return true;
            }
            //两种都有  那么穷举
            for (int i = 0;i < value.length() / aCount;i ++) {
                int j = (value.length() - i * aCount) / bCount;
                if (i * aCount + j * bCount == value.length()) {
                    //验证是否符合
                    String a = null;
                    String b = null;
                    int index = 0;
                    for (char c : pattern.toCharArray()) {
                        if (c == 'a') {
                            if (a == null) {
                                a = value.substring(index,i);
                            } else {
                                if (! a.equals(value.substring(index,i))) {
                                    return false;
                                }
                                a = value.substring(index,i);
                            }
                            index = index + i;
                        } else {
                            if (b == null) {
                                b = value.substring(index,j);
                            } else {
                                if (! b.equals(value.substring(index,j))) {
                                    return false;
                                }
                                b = value.substring(index,j);
                            }
                            index = index + j;
                        }
                        return true;
                    }
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
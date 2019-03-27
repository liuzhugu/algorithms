package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuzhugu on 2019/03/26.
 *  767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * S只包含小写字母并且长度在[1,500]区间内。
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        Map<Character,Integer> charMap = new HashMap<>();
        for (char c : S.toCharArray()) {
            charMap.put(c,charMap.getOrDefault(c,0) + 1);
        }
        char[] chars = new char[charMap.size()];
        int index = 0;
        for (Map.Entry<Character,Integer> entry : charMap.entrySet()) {
            chars[index ++] = entry.getKey();
        }
        String result = nextStep("",S.length(),0,charMap,chars);
        return result.length() == S.length() ? result : "";
    }
    private String nextStep(String s,int n, int index, Map<Character,Integer> charMap,char[] chars) {
        if (index > n) {
            return s;
        }
        for (int i = 0;i < chars.length;i ++) {
            if ((s.length() == 0) || (s.charAt(s.length() - 1) != chars[i]  && charMap.get(chars[i]) > 0)) {
                charMap.put(chars[i],charMap.get(chars[i]) - 1);
                String str = nextStep(s + chars[i],n,index + 1,charMap,chars);
                if (str.length() == n) {
                    return str;
                }
                charMap.put(chars[i],charMap.get(chars[i]) + 1);
            }
        }
        return s;
    }
}

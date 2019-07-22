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


    //每次取次数最多和次多的两个字符来放
    public String reorganizeString(String S) {
        Map<Character,Integer> charMap = new HashMap<>();
        for (char c : S.toCharArray()) {
            charMap.put(c,charMap.getOrDefault(c,0) + 1);
        }
        char[] chars = new char[S.length()];
        for (int i = 0;i < chars.length;i ++) {
            chars[i] = 0;
        }
        int index = 0;
        while(!charMap.isEmpty()) {
            //取次数最多和次多的两个字符
            int maxCount = 0,secondCount = 0;
            char maxChar = 0,secondChar = 0;
            for (Map.Entry<Character,Integer> entry : charMap.entrySet()) {
                if (entry.getValue() > secondCount) {
                    secondChar = entry.getKey();
                    secondCount = entry.getValue();
                }
                if (secondCount > maxCount) {
                    int temp = maxCount;
                    maxCount = secondCount;
                    secondCount = temp;

                    char tempChar = maxChar;
                    maxChar = secondChar;
                    secondChar = tempChar;
                }
            }
            //如果只剩一种字符
            if (secondChar == 0) {
                if (chars.length == 1) {
                    chars[index] = maxChar;
                    break;
                }
                //只剩一个字符,并且还剩一个位置且前一个位置不是相同字符
                if (maxCount == 1 && index == (chars.length - 1)
                        && maxChar != chars[index - 1]) {
                    chars[index] = maxChar;
                    break;
                }
                return "";
            }
            //放置这两个字符
            if (index != 0 && maxChar == chars[index - 1]) {
                chars[index ++] = secondChar;
                chars[index ++] = maxChar;
            }else {
                chars[index ++] = maxChar;
                chars[index ++] = secondChar;
            }
            if (secondChar != 0 && secondCount == 1) {
                charMap.remove(secondChar);
            }else {
                //次数减1
                charMap.put(secondChar,secondCount - 1);
            }
            if (maxChar != 0 && maxCount == 1) {
                charMap.remove(maxChar);
            }else {
                //次数减1
                charMap.put(maxChar,maxCount - 1);
            }
        }
        return new String(chars).toString();
    }



    //递归   但性能不符合要求
//    public String reorganizeString(String S) {
//        Map<Character,Integer> charMap = new HashMap<>();
//        for (char c : S.toCharArray()) {
//            charMap.put(c,charMap.getOrDefault(c,0) + 1);
//        }
//        char[] chars = new char[charMap.size()];
//        int index = 0;
//        for (Map.Entry<Character,Integer> entry : charMap.entrySet()) {
//            chars[index ++] = entry.getKey();
//        }
//        String result = nextStep("",S.length(),0,charMap,chars);
//        return result.length() == S.length() ? result : "";
//    }
//    private String nextStep(String s,int n, int index, Map<Character,Integer> charMap,char[] chars) {
//        if (index > n) {
//            return s;
//        }
//        for (int i = 0;i < chars.length;i ++) {
//            if ((s.length() == 0) || (s.charAt(s.length() - 1) != chars[i]  && charMap.get(chars[i]) > 0)) {
//                charMap.put(chars[i],charMap.get(chars[i]) - 1);
//                String str = nextStep(s + chars[i],n,index + 1,charMap,chars);
//                if (str.length() == n) {
//                    return str;
//                }
//                charMap.put(chars[i],charMap.get(chars[i]) + 1);
//            }
//        }
//        return s;
//    }
}

package practice.jianzhi;

import java.util.*;
/**
 * Created by liuzhugu on 2020/03/06.
 * 面试题50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        char result = ' ';
        if (s == null || s.length() == 0) return result;
        List<Character> list = new ArrayList<>();
        Map<Character,Integer> exist = new HashMap<>();
        for (int i = 0;i < s.length();i ++) {
            if (! exist.containsKey(s.charAt(i))) {
                list.add(s.charAt(i));
            }
            exist.put(s.charAt(i),exist.getOrDefault(s.charAt(i),0) + 1);
        }
        //找出第一个 且 只出现一次的字符
        for (char c : list) {
            if (exist.get(c) == 1) {
                result = c;
                break;
            }
        }
        return result;
    }
}

package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuzhugu on 2020/03/17.
 * 1160. 拼写单词
 *  给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 */
public class CountCharacters {
    public int countCharacters(String[] words, String chars) {
        if (chars == null || chars.length() == 0 || words == null || words.length == 0) {
            return 0;
        }
        int count = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (char c : chars.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for (String str : words) {
            Map<Character,Integer> tmp = new HashMap<>(map);
            boolean connect = true;
            for (char c : str.toCharArray()) {
                if (! tmp.containsKey(c)) {
                    connect = false;
                    break;
                }
                if (tmp.get(c) == 1) {
                    tmp.remove(c);
                } else {
                    tmp.put(c,tmp.get(c) - 1);
                }

            }
            if (connect) {
                count = count + str.length();
            }
        }
        return count;
    }
}

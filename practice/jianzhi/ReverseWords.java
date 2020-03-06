package practice.jianzhi;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by liuzhugu on 2020/03/03.
 * 面试题58 - I. 翻转单词顺序
 *  输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
 *  标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class ReverseWords {
    public String reverseWords(String s) {
        //给单词排序
        int i = 0;
        List<String> list = new ArrayList<>();
        while (i < s.length()) {
            //跳过空格
            while (i < s.length() && s.charAt(i) == ' ') i ++;
            if (i == s.length()) break;
            StringBuilder stringBuilder = new StringBuilder();
            while (i < s.length() && s.charAt(i) != ' ') {
                stringBuilder.append(s.charAt(i));
                i ++;
            }
            list.add(stringBuilder.toString());
        }
        //逆序拼接
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = list.size() - 1;j > 0;j --) {
            stringBuilder.append(list.get(j) + " ");
        }
        if (! list.isEmpty()) {
            stringBuilder.append(list.get(0));
        }
        return stringBuilder.toString();
    }
}

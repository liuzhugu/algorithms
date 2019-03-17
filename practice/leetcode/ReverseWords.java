package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2019/03/17.
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] strings = s.split(" ");
        if (s == null || s.length() == 0) {
            return "";
        }
        List<String> stringList = new ArrayList<>();
        for (String string : strings) {
            //去掉""
            if (! string.equals("")) {
                stringList.add(string);
            }
        }
        if (stringList.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = stringList.size() - 1;i > 0;i --) {
                //逆序拼接
                stringBuilder.append(stringList.get(i)).append(" ");
            }
            //拼接头部
            stringBuilder.append(stringList.get(0));
            return stringBuilder.toString();
        }else {
            return "";
        }
    }
}

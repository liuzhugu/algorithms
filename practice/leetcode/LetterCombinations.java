package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2019/12/05.
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下(与电话按键相同)。注意1不对应任何字母。
 */
public class LetterCombinations {
    String[] strings = new String[]{
            "abc","def","ghi","jkl","mno",
            "pqrs","tuv","wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0 || digits == null) {
            return result;
        }
        result.add("");
        for (int i = 0;i < digits.length();i ++) {
            List<String> tmp = new ArrayList<>();
            char c = digits.charAt(i);
            int num = c - '2';
            String string = strings[num];
            for (String str : result) {
                for (int j = 0;j < string.length();j ++) {
                    tmp.add(str + string.charAt(j));
                }
            }
            result.clear();
            result = tmp;
        }
        return result;
    }
}

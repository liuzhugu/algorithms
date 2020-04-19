package leetcode.editor.cn;

import java.util.*;

/**
 * Created by liuzhugu on 2019/12/30.
 * 524. 通过删除字母匹配到字典里最长单词
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，
 * 该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，
 * 返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 */
public class FindLongestWord {
    //按题目要求对字典排序  在遍历比较
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() == o2.length() ? o1.compareTo(o2)
                        : o2.length() - o1.length();
            }
        });
        String result = "";
        Iterator<String> iterator = d.iterator();
        while(iterator.hasNext()){
            String tmp = iterator.next();
            if (match(s,tmp)) {
                result = tmp;
                break;
            }
        }
        return result;
    }
    public boolean match(String s1,String s2) {
        int i = 0,j = 0;
        for (;i < s1.length() && j < s2.length();i ++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j ++;
            }
        }
        return j == s2.length();
    }
}

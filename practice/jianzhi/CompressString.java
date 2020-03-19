package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/16.
 * 面试题 01.06. 字符串压缩
 *  字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 *  比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 *  你可以假设字符串中只包含大小写英文字母（a至z）。
 */
public class CompressString {
    public String compressString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        char c = ' ';
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < S.length();i ++) {
            char tmp = S.charAt(i);
            if (c == ' ') {
                c = tmp;
            }
            if (tmp == c) {
                count ++;
            } else {
                stringBuilder.append(c).append(count);
                c = tmp;
                count = 1;
            }
        }
        stringBuilder.append(c).append(count);
        String result = stringBuilder.toString();
        return result.length() < S.length() ? result : S;
    }
}

package leetcode.editor.cn;

/**
 * Created by liuzhugu on 2019/03/19.
 * 792. 匹配子序列的单词数
 * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
 */
public class NumMatchingSubseq {
    public int numMatchingSubseq(String S, String[] words) {
        if (S == null || S.length() == 0 || words == null || words.length == 0) {
            return 0;
        }
        //统计各字符数量
        int result = 0;
        nextString:for (String s : words) {
            int first = 0,second = 0;
            while(second < s.length()) {
                if (first == S.length()) {
                    continue nextString;
                }
                if (S.charAt(first) == s.charAt(second)) {
                    first ++;
                    second ++;
                }else {
                    first ++;
                }
            }
            result ++;
        }
        return result;
    }
}

package practice.leetcode;

/**
 * Created by liuzhugu on 2019/11/24.
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，
 * 每步可以删除任意一个字符串中的一个字符
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        //找到最长公共序列
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        return word1.length() + word2.length() - 2 * findLongCommonSequence(word1,word2,word1.length(),word2.length(),memo);
    }

    //回溯法    两边分别消去一个字符然后找相同  找到相同的同时消去并且计数+1
    //通过回溯法把去掉字符的情况遍历过
    int findLongCommonSequence(String word1, String word2,int m,int n,int[][] memo) {
        if (m == 0 || n == 0) {
            return 0;
        }
        //已有结果
        if (memo[m][n] > 0) {
            return memo[m][n];
        }
        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            memo[m][n] = 1 + findLongCommonSequence(word1,word2,m - 1,n - 1,memo);
        }else {
            memo[m][n] = Math.max(findLongCommonSequence(word1,word2,m - 1,n,memo),
                    findLongCommonSequence(word1,word2,m,n - 1,memo));
        }
        return memo[m][n];
    }
}

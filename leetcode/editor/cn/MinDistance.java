package leetcode.editor.cn;

/**
 * Created by liuzhugu on 2020/04/06.
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，
 * 每步可以删除任意一个字符串中的一个字符
 * 你可以对一个单词进行如下三种操作：
 *    插入一个字符
 *    删除一个字符
 *    替换一个字符
 */
public class MinDistance {
    // 如果i和j指向的字符相等那么  dp[i][j] = dp[i - 1][j - 1]
    //                         增             删           换
    // 否则 dp[i][j] = min(dp[i][j - 1],dp[i - 1][j],dp[i - 1][j - 1]) + 1
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //有一项为0
        if (m * n == 0) {
            return m + n;
        }
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0;i <= m;i ++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        //初始化边界条件
        for (int i = 0;i <= m;i ++) {
            //删
            dp[i][0] = i;
        }
        for (int j = 0;j <= n;j ++) {
            //增
            dp[0][j] = j;
        }

        for (int i = 1;i <= m;i ++) {
            for (int j = 1;j <= n;j ++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //增操作会使dp[i][j] = dp[i][j - 1],
                    // 因为第二个字符串的第j个字符被新增的字符对消了
                    dp[i][j] = Math.min(dp[i][j],dp[i][j - 1]);
                    //删操作会使第一个字符串的第i - 1个字符和第二个字符串的第j个字符对消
                    dp[i][j] = Math.min(dp[i][j],dp[i - 1][j]);
                    //替换操作使得两边的最后一个字符都不用考虑
                    dp[i][j] = Math.min(dp[i][j],dp[i - 1][j - 1]);
                    dp[i][j] = dp[i][j] + 1;
                }
            }
        }
        return dp[m][n];
    }
}

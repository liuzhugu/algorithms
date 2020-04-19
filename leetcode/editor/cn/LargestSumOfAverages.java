package leetcode.editor.cn;

/**
 * Created by liuzhugu on 2019/12/15.
 * 813. 最大平均值和的分组
 * 我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。
 * 计算我们所能得到的最大分数是多少。注意我们必须使用 A 数组中的每一个数进行分组，
 * 并且分数不一定需要是整数
 */
public class LargestSumOfAverages {
    /**
     dp[i][k]表示前i个数构成k个子数组时的最大平均值, 那么对于所有 0 <= j <= i-1
     dp[i][k] = Math.max(dp[i][k], dp[j][k-1] + (A[j+1] + ... + A[i+1]) / (i-j))
     **/
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] dp = new double[n + 1][K + 1];
        double[] sum = new double[n + 1];
        sum[0] = 0;
        for (int i = 1;i <= n;i ++) {
            sum[i] = sum[i - 1] + A[i - 1];
            dp[i][1] = sum[i] / i;
        }
        //遍历
        for (int i = 1;i <= n;i ++) {
            for (int k = 2;k <= K;k ++) {
                for (int j = k - 1;j < i;j ++) {
                    dp[i][k] = Math.max(dp[i][k],
                            dp[j][k - 1] + (sum[i] - sum[j])/(i - j));
                }
            }
        }
        return dp[n][K];
    }
}

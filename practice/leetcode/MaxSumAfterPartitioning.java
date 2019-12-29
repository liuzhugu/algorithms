package practice.leetcode;

public class MaxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length];
        //先往左覆盖
        for (int i = 0;i < A.length;i ++) {
            //不断从前一层去元素下来跟当前数组组成一个新的子数组
            int max = A[i];
            for (int j = 1;j <= K && (i - j + 1) >= 0;j ++) {
                max = Math.max(max,A[i - j + 1]);
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i],dp[i - j] + j * max);
                }else {
                    //大小不足K
                    dp[i] = Math.max(dp[i],j * max);
                }
            }
        }
        return dp[A.length - 1];
    }
}

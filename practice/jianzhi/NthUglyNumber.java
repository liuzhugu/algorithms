package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/11.
 * 面试题49. 丑数
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        //素数等于前面某素数乘2或乘3或乘5可得
        int p2 = 0,p3 = 0,p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1;i < n;i ++ ) {
            int min = Math.min(dp[p2] * 2,Math.min(dp[p3] * 3,dp[p5] * 5));
            if (min == dp[p2] * 2) p2 ++;
            if (min == dp[p3] * 3) p3 ++;
            if (min == dp[p5] * 5) p5 ++;
            dp[i] = min;
        }
        return dp[n - 1];
    }
}

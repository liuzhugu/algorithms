package practice.jianzhi;


/**
 * Created by liuzhugu on 2019/04/02.
 * 面试题60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */
public class TwoSum {
    public double[] twoSum(int n) {
        //概率等于可能情况数量 除以 情况总数

        //第一维是骰子个数  第二维是相应之和
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int i = 1;i <= 6;i ++) {
            //情况数
            dp[1][i] = 1;
        }
        for (int i = 2;i <= n;i ++) {
            for (int j = i;j <= 6 * i;j ++) {
                for (int k = 1;k <= 6;k ++) {
                    if (j - k >= i - 1) {
                        //F(n,s) = F(n−1,s−1) + F(n−1,s−2) + F(n−1,s−3)
                        // + F(n−1,s−4) + F(n−1,s−5) + F(n−1,s−6)

                        //骰子点数可能的情况 注重于过程 需要全排列
                        //但骰子之和   注重于结果  因此可以用动态规划
                        dp[i][j] = + dp[i - 1][j - k];
                    }
                }
            }
        }
        //情况总数
        double total = Math.pow(6,n);
        double[] ans = new double[5 * n + 1];
        for (int i = n;i <= 6 * n;i ++) {
            //情况数  除以  情况总数
            ans[i - n] = dp[n][i] / total;
        }
        return ans;
    }
}

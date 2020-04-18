package practice.jianzhi;

/**
 * Created by liuzhugu on 2019/04/19.
 * 面试题10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *      F(0) = 0,   F(1) = 1
 *      F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Fib {
    public int fib(int n) {
        int[] ans = new int[n + 1];
        int mod = (int)1e9+7;
        for (int i = 0;i <= n;i ++) {
            if (i == 0) {
                ans[i] = 0;
                continue;
            }
            if (i == 1) {
                ans[i] = 1;
                continue;
            }
            ans[i] = (ans[i - 1] + ans[i - 2]) % mod;
        }
        return ans[n];
    }
}

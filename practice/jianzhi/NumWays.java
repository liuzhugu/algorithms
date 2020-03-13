package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/12.
 * 面试题10- II. 青蛙跳台阶问题
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class NumWays {
    public int numWays(int n) {
        return intercept(get(n));
    }

    private int intercept(int num) {
        return num > 1000000007 ? num - 1000000007 : num;
    }
    private int get(int num) {
        int[] results = new int[num + 1];
        results[0] = 1;
        results[1] = 1;
        for (int i = 2;i <= num;i ++) {
            results[i] = intercept(results[i - 1]) + intercept(results[i - 2]);
        }
        return results[num];
    }
}

package practice.leetcode;

/**
 * Created by liuzhugu on 2019/12/27.
 * 1015. 可被 K 整除的最小整数
 * 给定正整数 K，你需要找出可以被 K 整除的、仅包含数字 1 的最小正整数 N。
 * 返回 N 的长度。如果不存在这样的 N，就返回 -1。
 */
public class SmallestRepunitDivByK {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        int x = 1;
        int len = 1;
        while (x % K != 0) {
            x = (x % K) * 10 + 1;
            len ++;
        }
        return len;
    }
}

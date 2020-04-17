package practice.leetcode;
/**
 * Created by liuzhugu on 2020/04/17.
 * 343. 整数拆分
 *  给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int end = n / 3 >= 2 ? n / 3 : 2;
        int ans = 0;
        for (int i = 2;i <= end;i ++) {
            int remainder = n % i;
            int quotient = n / i;
            int num = i;
            int product = 1;
            while (num > 0) {
                if (remainder != 0) {
                    product = product * (quotient + 1);
                    remainder --;
                } else {
                    product = product * quotient ;
                }
                num --;
            }
            if (product > ans) {
                ans = product;
            }
        }
        return ans;
    }
}

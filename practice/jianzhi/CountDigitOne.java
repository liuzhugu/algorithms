package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/03.
 * 面试题43. 1～n整数中1出现的次数
 *  输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *  例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */
public class CountDigitOne {
    /**
     * 1. 去掉第一位的情况   firstSituation
     * 2. 第一种情况剩余的情况
     *       2.1 最高位有1  secondSituation
     *       2.2 最高位没1  thirdSituation
     * */
    public int countDigitOne(int n) {
        return f(n);
    }
    public int f(int n) {
        if (n == 0) return 0;
        if (n <= 9 && n > 0) return 1;
        int digit = 1,quotient = n,first = 0;
        while (quotient / 10 != 0) {
            quotient = quotient / 10;
            digit++;
            first = quotient;
        }
        int firstSituation = 0,secondSituation = 0,thirdSituation = 0;
        if (first == 1) {
            secondSituation = n - (int)Math.pow(10,digit - 1) + 1;
        } else {
            secondSituation = (int)Math.pow(10,digit - 1);
        }
        //因为第一位不为1   先不考虑第一位   其他位置任意一位为1  那么其他位置可以为0-9
        //因此有pow(10,digit - 2)种情况  1可以选的位置有(digit -1)情况   最后加上有第一位的情况
        thirdSituation = first * (digit -1) * (int)Math.pow(10,digit - 2) ;

        firstSituation = f(n - first *  (int)Math.pow(10,digit - 1));
        return firstSituation + secondSituation + thirdSituation;
    }
}

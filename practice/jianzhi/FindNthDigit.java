package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/04/17.
 * 面试题44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，
 * 第19位是4，等等。请写一个函数，求任意第n位对应的数字。
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        //先判断它是多少位数
        int ans = 0;
        long count = 10,start = 0,length = 0;
        int digits = 1;
        while (length < n) {
            long nextLength = length + count * digits;
            //数在该范围内
            if (nextLength >= n) {
                length = n - length;
                //商
                long quotient = length / digits;
                //余数
                int remainder = (int)(length % digits);
                long num = start + quotient;
                char[] result = String.valueOf(num).toCharArray();
                ans = result[remainder] - '0';
                break;
            }
            //下一个范围
            start = (int)Math.pow(10,digits);
            digits ++;
            count = start * 9;
            length = nextLength;
        }
        return ans;
    }
}

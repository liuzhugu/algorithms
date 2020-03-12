package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/12.
 * 面试题17. 打印从1到最大的n位数
 *  输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数999。
 *
 */
public class PrintNumbers {
    public int[] printNumbers(int n) {
        int num = (int)Math.pow(10,n);
        int[] result = new int[num - 1];
        for (int i = 1;i < num;i ++) {
            result[i - 1] = i;
        }
        return result;
    }
}

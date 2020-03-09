package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/09.
 * 面试题37. 序列化二叉树
 *  请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class MinArray {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int result = numbers[numbers.length - 1],i = numbers.length - 2;
        while (i >= 0) {
            if (numbers[i] <= result) {
                result = numbers[i];
            } else {
                break;
            }
            i --;
        }
        return result;
    }
}

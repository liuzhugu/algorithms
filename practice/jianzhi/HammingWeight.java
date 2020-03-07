package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/07.
 * 面试题15. 二进制中1的个数
 *  请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，
 *  有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int count = 0;
        do {
            if ((1 & n) != 0) {
                count ++;
            }
            n = n >>> 1;
        } while (n != 0);
        return count;
    }


    //n不会溢出  但mask可能会溢出  因此改为移动n
//    public int hammingWeight(int n) {
//        int count = 0;
//        int mask = 1;
//        do {
//            if ((mask & n) != 0) {
//                count ++;
//            }
//            mask = mask << 1;
//        } while (mask <= n);
//        return count;
//    }
}

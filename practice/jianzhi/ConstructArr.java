package practice.jianzhi;


/**
 * Created by liuzhugu on 2020/04/07.
 * 面试题66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素
 * B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class ConstructArr {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int n = a.length;
        //从左到右乘 left
        int[] left = new int[n];
        left[0] = a[0];
        for (int i = 1;i < n;i ++) {
            left[i] = left[i - 1] * a[i];
        }
        //从右到左乘 right
        int[] right = new int[n];
        right[n - 1] = a[n - 1];
        for (int i = n - 2;i >= 0;i --) {
            right[i] = right[i + 1] * a[i];
        }
        //那么b[i] = left[i - 1] * right[i + 1]
        for (int i = 0;i < n;i ++) {
            int first = 1,second = 1;
            if (i > 0) {
                first = left[i - 1];
            }
            if (i < n - 1) {
                second = right[i + 1];
            }
            a[i] = first * second;
        }
        return a;
    }
}

package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/04.
 * 面试题29. 顺时针打印矩阵
 *  输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        int[] result = new int[]{};
        if (matrix == null || matrix.length == 0) return result;
        result = new int[matrix.length * matrix[0].length];
        int top = 0,buttom = matrix.length - 1,left = 0,right = matrix[0].length - 1,index = 0;
        while (left <= right && top <= buttom) {
            int i;
            //从左到右
            for (i = left;i <= right;i ++) {
                result[index ++] = matrix[top][i];
            }
            //从上到下
            if (buttom > top) {
                for (i = top + 1;i <= buttom;i ++) {
                    result[index ++] = matrix[i][right];
                }
            }
            if (right > left && buttom > top) {
                //从右到左
                for (i = right - 1;i >= left;i --) {
                    result[index ++] = matrix[buttom][i];
                }
            }
            //从下到上
            if (buttom - 1 > top && right > left) {
                for (i = buttom - 1;i > top;i --) {
                    result[index ++] = matrix[i][left];
                }
            }
            left ++;
            right --;
            top ++;
            buttom --;
        }
        return result;
    }
}

package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/02/12.
 * 面试题04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindNumberIn2DArray {

    //从左到右递增  从上到下递增
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //从右上角开始
        int i = 0,j = matrix[0].length;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] > target) {
                j --;
            } else if (matrix[i][j] < target) {
                i ++;
            } else {
                return true;
            }
        }
        return false;
    }
}

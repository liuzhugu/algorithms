package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/04/07.
 * 面试题 01.07. 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 不占用额外内存空间能否做到？
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        //先以斜对角线做对称交换
        for (int i = 0;i < n;i ++) {
            for (int j = i + 1;j < n;j ++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //再以每行中点做对称交换
        for (int i = 0;i < n;i ++) {
            for (int j = 0;j < n;j ++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}

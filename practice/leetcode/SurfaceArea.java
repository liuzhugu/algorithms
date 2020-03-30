package practice.leetcode;

/**
 * Created by liuzhugu on 2020/03/26。
 * 892. 三维形体的表面积
 *  在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 */
public class SurfaceArea {
    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0;i < grid.length;i ++) {
            for (int j = 0;j < grid[0].length;j ++) {
                int num = grid[i][j];
                if (num == 0) continue;
                int left = num,right = num,top = num,buttom = num;
                if (i > 0) {
                    left = num - grid[i - 1][j];
                    if (left < 0) {
                        left = 0;
                    }
                }
                if (i + 1 < grid.length) {
                    right = num - grid[i + 1][j];
                    if (right < 0) {
                        right = 0;
                    }
                }
                if (j > 0) {
                    top = num - grid[i][j - 1];
                    if (top < 0) {
                        top = 0;
                    }
                }
                if (j + 1 < grid[0].length) {
                    buttom = num - grid[i][j + 1];
                    if (buttom < 0) {
                        buttom = 0;
                    }
                }
                result = result + left + right + top + buttom + 2;
            }
        }
        return result;
    }
}

package practice.leetcode;

/**
 * Created by liuzhugu on 2019/03/18.
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        if(obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0;i < obstacleGrid.length;i ++) {
            for (int j = 0;j < obstacleGrid[0].length;j ++) {
                if (i == 0 && j == 0 && obstacleGrid[i][j] != 1) {
                    matrix[i][j] = 1;
                    continue;
                }
                int top = 0,left = 0;
                if (i != 0 && obstacleGrid[i - 1][j] != 1) {
                    top = matrix[i - 1][j];
                }
                if (j != 0 && obstacleGrid[i][j - 1] != 1) {
                    left = matrix[i][j - 1];
                }
                matrix[i][j] = (top + left);
            }
        }
        return matrix[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    //超时
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if (obstacleGrid == null || obstacleGrid.length == 0) {
//            return 0;
//        }
//        return nextStep(obstacleGrid,0,0,0);
//    }
//    private int nextStep(int[][] obstacleGrid,int i,int j,int result) {
//        int rightResult = result, downResult = result;
//        //抵达终点
//        if ((i == obstacleGrid.length - 1) && (j == obstacleGrid[0].length - 1)) {
//            return result + 1;
//        }
//        //往右走
//        if ((i + 1) < obstacleGrid.length && obstacleGrid[i + 1][j] != 1) {
//            rightResult = nextStep(obstacleGrid,i + 1,j,result);
//        }
//        //往下走
//        if ((j + 1) < obstacleGrid[0].length && obstacleGrid[i][j + 1] != 1) {
//            downResult = nextStep(obstacleGrid,i,j + 1,result);
//        }
//        return downResult > rightResult ? downResult : rightResult;
//    }
}

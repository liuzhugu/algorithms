package practice.jianzhi;


/**
 * Created by liuzhugu on 2020/03/22.
 * 面试题47. 礼物的最大价值
 *  在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 *  你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 *  给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        //递推公式  每个格子的最多价值等于其左边格子和上边格子中的较大值加上本格
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0;i < grid.length;i ++) {
            for (int j = 0;j < grid[0].length;j ++) {
                int left = 0,right = 0;
                if (i != 0) {
                    left = dp[i - 1][j];
                }
                if (j != 0) {
                    right = dp[i][j - 1];
                }
                dp[i][j] = grid[i][j] + Math.max(left,right);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}

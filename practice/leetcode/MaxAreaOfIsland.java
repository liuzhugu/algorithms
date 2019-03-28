package practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuzhugu on 2019/03/28.
 * 695. 岛屿的最大面积
 * 给定一个包含了一些0和1的非空二维数组grid,一个岛屿是由四个方向(水平或垂直)的1(代表土地)构成的组合。
 * 你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积(如果没有岛屿，则返回面积为0)
 * 岛屿只能包含水平或垂直的四个方向的‘1’。
 */
public class MaxAreaOfIsland {
    boolean arrive[][];
    int max = 0;
    int temp = 0;
    private boolean[][] init(int m,int n) {
        arrive = new boolean[m][n];
        return arrive;
    }
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length,n = grid[0].length;
        arrive = init(m,n);
        for (int i = 0;i < m;i ++) {
            for (int j = 0;j < n;j ++) {
                if (grid[i][j] == 1) {
                    //从该点开始向四周探索
                    //设置全局变量,可以避免在递归中带来带去,但记得重置
                    arrive = init(m,n);
                    dfs(i,j,m,n,0,grid);
                    if (temp > max) {
                        max = temp;
                    }
                    temp = 0;
                }
            }
        }
        return max;
    }
    private void dfs(int i,int j,int m,int n,int area,int[][] grid) {
        if (i < 0 || j < 0 || i >= m || j >= n || arrive[i][j] == true || grid[i][j] == 0) {
            return;
        }
        temp ++;
        arrive[i][j] = true;
        dfs(i - 1,j,m,n,area,grid);
        dfs(i + 1,j,m,n,area,grid);
        dfs(i,j - 1,m,n,area,grid);
        dfs(i,j + 1,m,n,area,grid);

    }
    //不是单向的
//    public int maxAreaOfIsland(int[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//        int[][] result = new int[grid.length][grid[0].length];
//        int max = 0;
//        //key是i_j value是相应节点所能连通的点
//        Map<String, Set<String>> map = new HashMap<>();
//        for (int i = 0;i < grid.length;i ++) {
//            for (int j = 0;j < grid[0].length;j ++) {
//                if (grid[i][j] == 0) {
//                    result[i][j] = 0;
//                    continue;
//                }
//                Set<String> land = new HashSet<>();
//                if (i > 0 && grid[i - 1][j] == 1) {
//                    land.addAll(map.get((i - 1) + "_" +(j)));
//                }
//                if (j > 0 && grid[i][j - 1] == 1) {
//                    land.addAll(map.get((i) + "_" +(j - 1)));
//                }
//                land.add(i + "_" + j);
//                map.put(i + "_" + j,land);
//                result[i][j] = land.size();
//                //将同一行的与其连通的赋成同样的值
//                for (int k = j - 1;k >= 0;k --) {
//                    if (grid[i][k] == 1) {
//                        map.put(i + "_" + k,land);
//                        result[i][k] = land.size();
//                    }else {
//                        break;
//                    }
//                }
//                if (result[i][j] > max) {
//                    max = result[i][j];
//                }
//            }
//        }
//        return max;
//    }
}

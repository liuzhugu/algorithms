package leetcode.editor.cn;

/**
 * Created by liuzhugu on 2019/03/30.
 * 542. 01 矩阵
 * 给定一个由0和1组成的矩阵，找出每个元素到最近的0的距离。
 * 两个相邻元素间的距离为1。
 */
public class UpdateMatrix {

    //双向dp
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[][]{};
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        //从左上到右下
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Integer.MAX_VALUE;
                    //上边
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                    }
                    //左边
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                    }
                    dp[i][j]++;
                }
            }
        }
        //从右下到左上
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Integer.MAX_VALUE;
                    //下边
                    if (j < n - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1]);
                    }
                    //右边
                    if (i < m - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1]);
                    }
                    //上边
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                    }
                    //左边
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);

                    }
                    dp[i][j] ++;
                }
            }
        }
        return dp;
    }

//    //优化版DFS,从零开始优化周围的值
//    //上下左右的向量
//    private int[][] ventor = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//    public int[][] updateMatrix(int[][] matrix) {
//        if (matrix == null || matrix.length == 0) {
//            return new int[][]{};
//        }
//        int m = matrix.length,n = matrix[0].length;
//        for (int i = 0;i < m;i ++) {
//            for (int j = 0;j < n;j ++) {
//                // 优化：如果元素在 0 附近，保留元素值 1，不在 0 附近，初始化为一个较大值
//                if (matrix[i][j] == 1
//                        && !((i > 0 && matrix[i - 1][j] == 0)
//                        || (i < m - 1 && matrix[i + 1][j] == 0)
//                        || (j > 0 && matrix[i][j - 1] == 0)
//                        || (j < n - 1 && matrix[i][j + 1] == 0))) {
//                    matrix[i][j] = m + n;
//                }
//            }
//        }
//        for (int i = 0;i < m;i ++) {
//            for (int j = 0;j < n;j ++) {
//                //优化：将元素值为 1 的点作为深搜起点，降低递归深度
//                if (matrix[i][j] == 1) {
//                    updateMatrix(matrix,i,j);
//                }
//            }
//        }
//        return matrix;
//    }
//    private void updateMatrix(int[][] matrix,int i,int j) {
//        //向上下左右遍历
//        for (int[] v : ventor) {
//            int nextX = i + v[0],nextY = j + v[1];
//            if (nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length
//            && matrix[i][j] + 1 < matrix[nextX][nextY]) {
//                matrix[nextX][nextY] =  matrix[i][j] + 1;
//                updateMatrix(matrix,nextX,nextY);
//            }
//        }
//    }

        //DFS  但超时
//    boolean[][] arrive;
//    private void init(int m,int n) {
//        arrive = new boolean[m][n];
//    }
//    public int[][] updateMatrix(int[][] matrix) {
//        if (matrix == null || matrix.length == 0) {
//            return new int[][]{};
//        }
//        //广度优先遍历
//        int m = matrix.length,n = matrix[0].length;
//        int[][] result = new int[m][n];
//        for (int i = 0;i < m;i ++) {
//            nextNum :for (int j = 0;j < n;j ++) {
//                List<Point> points = new ArrayList<>();
//                if (matrix[i][j] == 0){
//                    result[i][j] = 0;
//                    continue nextNum;
//                }
//                init(m,n);
//                points.add(new Point(i,j));
//                int num = 0;
//                while (! points.isEmpty()) {
//                    List<Point> nextPoints = new ArrayList<>();
//                    for (Point point : points) {
//                        if (arrive[point.x][point.y] == true) {
//                            continue;
//                        }
//                        arrive[point.x][point.y] = true;
//                        if (matrix[point.x][point.y] == 0) {
//                            result[i][j] = num;
//                            continue nextNum;
//                        }
//                        //访问其上下左右
//                        if ((point.x - 1) >= 0 && arrive[point.x - 1][point.y] == false) {
//                            nextPoints.add(new Point(point.x - 1,point.y));
//                        }
//                        if ((point.x + 1) < m && arrive[point.x + 1][point.y] == false) {
//                            nextPoints.add(new Point(point.x + 1,point.y));
//                        }
//                        if ((point.y - 1) >= 0 && arrive[point.x][point.y - 1] == false) {
//                            nextPoints.add(new Point(point.x,point.y - 1));
//                        }
//                        if ((point.y + 1) < n && arrive[point.x][point.y + 1] == false) {
//                            nextPoints.add(new Point(point.x,point.y + 1));
//                        }
//                    }
//                    num ++;
//                    points = nextPoints;
//                }
//
//            }
//        }
//        return result;
//    }
}


package leetcode.editor.cn;



/**
 * Created by liuzhugu on 2020/03/29。
 * 1162. 地图分析
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。
 * 其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的
 * 陆地区域的距离。我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 
 * 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。如果我们的地图上只有陆地或者海洋，请返回 -1。
 */
public class MaxDistance {

    //双向递推
    public int maxDistance(int[][] grid) {
        int[][] min = new int[grid.length][grid.length];
        //初始dp
        for (int i = 0;i < grid.length;i ++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    min[i][j] = (int)Math.pow(10,6);
                } else {
                    min[i][j] = 0;
                }
            }
        }
        //求左上到右下的 最近距离
        for (int i = 0;i < grid.length;i ++) {
            for (int j = 0;j < grid.length;j ++) {
                if (grid[i][j] == 1) continue;
                if (i - 1 >= 0) min[i][j] = Math.min(min[i][j], min[i - 1][j] + 1);
                if (j - 1 >= 0) min[i][j] = Math.min(min[i][j], min[i][j - 1] + 1);
            }
        }
        //求右下到左上的最近距离
        for (int i = grid.length - 1;i >= 0;i --) {
            for (int j = grid.length - 1;j >= 0;j --) {
                if (grid[i][j] == 1) continue;
                if (i + 1 < grid.length) min[i][j] = Math.min(min[i][j], min[i + 1][j] + 1);
                if (j + 1 < grid.length) min[i][j] = Math.min(min[i][j], min[i][j + 1] + 1);
            }
        }
        int ans = -1;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid.length; ++j) {
                if (min[i][j] != 0) {
                    ans = Math.max(ans, min[i][j]);
                }
            }
        }
        return ans == (int)Math.pow(10,6) ? -1 : ans;
    }

    //BFS
//    public int maxDistance(int[][] grid) {
//        int[][] visit = new int[][]{
//                {0,-1},
//                {0,1},
//                {-1,0},
//                {1,0}
//        };
//        Deque<int[]> deque;
//        int result = 0;
//        for (int i = 0;i < grid.length;i ++) {
//            for (int j = 0;j < grid[0].length;j ++) {
//                //陆地不处理
//                if (grid[i][j] == 1) {
//                    continue;
//                }
//                deque = new LinkedList<>();
//                boolean[][] flag = new boolean[grid.length][grid[0].length];
//                deque.add(new int[]{i,j});
//                flag[i][j] = true;
//                while (! deque.isEmpty()) {
//                    int[] position = deque.removeFirst();
//                    int x = position[0],y = position[1];
//                    //找到最近的陆地了
//                    if (grid[x][y] == 1) {
//                        int distance = Math.abs(i - x) + Math.abs(j - y);
//                        if (distance > result) {
//                            result = distance;
//                        }
//                        //结束
//                        deque.clear();
//                    } else {
//                        //将周围的地点加入待访问队列
//                        int nextX,nextY;
//                        for (int[] tmp : visit) {
//                            nextX = x + tmp[0];
//                            nextY = y + tmp[1];
//                            if (nextX < 0 || nextX >= grid.length || nextY < 0
//                                    || nextY >= grid[0].length) {
//                                //越界  不处理
//                                continue;
//                            }
//                            if (flag[nextX][nextY] == false) {
//                                deque.add(new int[]{nextX,nextY});
//                                flag[nextX][nextY] = true;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }

    //超时
//    public int maxDistance(int[][] grid) {
//        List<int[]> list = new ArrayList<>();
//        for (int i = 0;i < grid.length;i ++) {
//            for (int j = 0;j < grid[0].length;j ++) {
//                if (grid[i][j] == 1) {
//                    list.add(new int[]{i,j});
//                }
//            }
//        }
//        if (list.size() == 0) {
//            return -1;
//        }
//        if (list.size() == grid.length * grid[0].length) {
//            return -1;
//        }
//        int result = 0;
//        for (int i = 0;i < grid.length;i ++) {
//            for (int j = 0;j < grid[0].length;j ++) {
//                if (grid[i][j] == 1) {
//                    continue;
//                }
//                //海洋
//                int min = Integer.MAX_VALUE;
//                for (int[] nums : list) {
//                    int distance = Math.abs(i - nums[0]) + Math.abs(j - nums[1]);
//                    min = Math.min(distance,min);
//                }
//                if(min > result) {
//                    result = min;
//                }
//            }
//
//        }
//        return result;
//    }
}

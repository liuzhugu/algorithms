//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：200:岛屿数量  BFS 染色  2020/04/20
public class NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        //TO TEST
        String str = "[[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"0\",\"0\",\"1\",\"0\",\"0\"],[\"0\",\"0\",\"0\",\"1\",\"1\"]]";
        //System.out.println(str.replace("\"","'").replace("[","{").replace("]","}"));
        System.out.println(solution.numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int color = 1;
            int m = grid.length,n = grid[0].length;
            //染色情况  不同数字代表不同颜色  要染的颜色优先最低数字
            int[][] colors = new int[m][n];
            for (int i = 0;i < m;i ++) {
                for (int j = 0;j < n;j ++) {
                    //未被染色的岛屿
                    if (grid[i][j] == '1' && colors[i][j] == 0) {
                        //遍历染色
                        Deque<int[]> deque = new LinkedList<>();
                        deque.add(new int[]{i,j});
                        while (! deque.isEmpty()) {
                            int[] coordinate = deque.removeFirst();
                            //染色
                            int x = coordinate[0],y = coordinate[1];
                            //不是岛屿 或者 已着色
                            if (grid[x][y] == '0' || colors[x][y] != 0) {
                                continue;
                            }
                            colors[x][y] = color;
                            //向四周着色
                            if (x > 0) {
                                deque.add(new int[]{x - 1,y});
                            }
                            if (y > 0) {
                                deque.add(new int[]{x,y - 1});
                            }
                            if (x < m - 1) {
                                deque.add(new int[]{x + 1,y});
                            }
                            if (y < n - 1) {
                                deque.add(new int[]{x,y + 1});
                            }
                        }
                        //变换颜色
                        color ++;
                    }
                }
            }
            //用了多少种颜色
            return color - 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
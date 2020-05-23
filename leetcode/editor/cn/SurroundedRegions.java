//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
// X O O X
// X X O X
// X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：130:被围绕的区域 2020/05/18
public class SurroundedRegions{
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
        //TO TEST
        solution.solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0) {
                return;
            }
            int m = board.length,n = board[0].length;
            Queue<int[]> zoreQueue = new LinkedList<>();
            boolean[][] shouldReplace = new boolean[m][n];
            for (int i = 0;i < m;i ++) {
                for (int j = 0;j < n;j ++) {
                    if (board[i][j] == 'O') {
                        shouldReplace[i][j] = true;
                    }
                }
            }
            //取所有边界为0的
            for (int i = 0;i < m;i ++) {
                if (board[i][0] == 'O') {
                    zoreQueue.add(new int[]{i,0});
                    shouldReplace[i][0] = false;
                }
                if (board[i][n - 1] == 'O') {
                    zoreQueue.add(new int[]{i,n - 1});
                    shouldReplace[i][n - 1] = false;
                }
            }
            for (int i = 0;i < n;i ++) {
                if (board[0][i] == 'O') {
                    zoreQueue.add(new int[]{0,i});
                    shouldReplace[0][i] = false;

                }
                if (board[m - 1][i] == 'O') {
                    zoreQueue.add(new int[]{m - 1,i});
                    shouldReplace[m - 1][i] = false;
                }
            }
            //与这些边界上的0直接或间接相连的都不应该被替换
            //BFS
            while (! zoreQueue.isEmpty()) {
                int[] num = zoreQueue.poll();
                int i = num[0],j = num[1];
                //向四向遍历
                if (judge(board,i + 1,j) && shouldReplace[i + 1][j]) {
                    shouldReplace[i + 1][j] = false;
                    zoreQueue.add(new int[]{i + 1,j});
                }
                if (judge(board,i - 1,j) && shouldReplace[i - 1][j]) {
                    shouldReplace[i - 1][j] = false;
                    zoreQueue.add(new int[]{i - 1,j});
                }
                if (judge(board,i,j + 1) && shouldReplace[i][j + 1]) {
                    shouldReplace[i][j + 1] = false;
                    zoreQueue.add(new int[]{i,j + 1});
                }
                if (judge(board,i,j - 1) && shouldReplace[i][j - 1]) {
                    shouldReplace[i][j - 1] = false;
                    zoreQueue.add(new int[]{i,j - 1});
                }
            }
            //替换
            for (int i = 0;i < m;i ++) {
                for (int j = 0;j < n;j ++) {
                    if (board[i][j] == 'O' && shouldReplace[i][j]) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
        private boolean judge(char[][] board,int i,int j) {
            //越界
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
                return false;
            }
            //非 0
            if (board[i][j] == 'X') {
                return false;
            }
            //非边界
            if (i == 0 || i == board.length - 1) {
                return false;
            }
            if (j == 0 || j == board[0].length - 1) {
                return false;
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
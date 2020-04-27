//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：37:解数独 回溯法  2020/04/27
public class SudokuSolver{
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
        //TO TEST
        //System.out.println(LeetCodeTest.strDeal("[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]"));
        solution.solveSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            if (board == null || board.length == 0) {
                return;
            }
            int m = board.length;
            //横
            x = new int[m];
            //纵
            y = new int[m];
            //每三格
            piece = new int[m / 3][m / 3];
            //待填地方
            List<int[]> list = new ArrayList<>();
            //根据已有数据初始化
            for (int i = 0;i < m;i ++) {
                for (int j = 0;j < m;j ++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '0';
                        x[i] = x[i] | 1 << num;
                        y[j] = y[j] | 1 << num;
                        int X = (i + 3) / 3 - 1;
                        int Y = (j + 3) / 3 - 1;
                        piece[X][Y] = piece[X][Y] | 1 << num;
                    } else {
                        list.add(new int[]{i,j});
                    }
                }
            }
            //开始回溯
            visit(board,list,0);
        }
        //横
        private int[] x;
        //纵
        private int[] y;
        //每三格
        private int[][] piece;
        private boolean visit(char[][] board,List<int[]> list,int index) {
            if (index == list.size()) {
                return true;
            }
            int[] coordinate = list.get(index);
            int X = coordinate[0],Y = coordinate[1];
            for (int i = 1;i <= 9;i ++) {
                int tmpX = (X + 3) / 3 - 1;
                int tmpY = (Y + 3) / 3 - 1;
                //保存原值  方便复原
                int preX = x[X],preY = y[Y],prePiece = piece[tmpX][tmpY];
                //该行没有这个数
                if ((x[X] & (1 << i)) != 0) {
                    continue;
                }
                //该列没有这个数
                if ((y[Y] & (1 << i)) != 0) {
                    continue;
                }
                //该3 * 3格子没有这个数
                if ((piece[tmpX][tmpY] & 1 << i) != 0) {
                    continue;
                }
                //赋值
                board[X][Y] = (char) (i + '0');
                x[X] = x[X] | (1 << i);
                y[Y] = y[Y] | (1 << i);
                piece[tmpX][tmpY] = piece[tmpX][tmpY] | 1 << i;
                //试下一个
                if (visit(board,list,index + 1)) {
                    return true;
                }
                //失败 恢复现场 换其他数字尝试
                board[X][Y] = '.';
                x[X] = preX;
                y[Y] = preY;
                piece[tmpX][tmpY] = prePiece;
            }
            //都试过不行 回溯到上一个
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
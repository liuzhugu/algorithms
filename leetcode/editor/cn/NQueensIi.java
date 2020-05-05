//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：52:N皇后 II  回溯法 2020/05/03
public class NQueensIi{
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        //TO TEST
        solution.totalNQueens(4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalNQueens(int m) {
            //纵
            y = new boolean[m];
            //每三格
            boundary = new boolean[m][m];
            visit(0,m);
            return ans;
        }
        //纵
        private boolean[] y;
        //斜 只需边界
        private boolean[][] boundary;
        private int ans = 0;
        private void visit(int i,int m) {
            if (i == m) {
                ans ++;
                return;
            }
            next :for (int j = 0;j < m;j ++) {
                //判断纵
                if (y[j]) {
                    continue;
                }
                //判断斜
                int x1 = i,y1 = j;
                //左上
                while (x1 > 0 && y1 > 0) {
                    x1 --;
                    y1 --;
                    if (boundary[x1][y1]) {
                        continue next;
                    }
                }

                //左下
                int x3 = i,y3 = j;
                while (x3 > 0 && y3 < m - 1) {
                    x3 --;
                    y3 ++;
                    if (boundary[x3][y3]) {
                        continue next;
                    }
                }
                //右下
                int x2 = i,y2 = j;
                while (x2 < m - 1 && y2 < m - 1) {
                    x2 ++;
                    y2 ++;
                    if (boundary[x2][y2]) {
                        continue next;
                    }
                }
                //右上
                int x4 = i,y4 = j;
                while (x4 < m - 1 && y4 > 0) {
                    x4 ++;
                    y4 --;
                    if (boundary[x4][y4]) {
                        continue next;
                    }
                }

                //赋值
                y[j] = true;
                boundary[i][j] = true;
                visit(i + 1,m);
                //还原现场
                y[j] = false;
                boundary[i][j] = false;

            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}